package io.goodforgod.simplelambda;

import io.goodforgod.aws.lambda.events.gateway.APIGatewayV2HTTPEvent;
import io.goodforgod.aws.simplelambda.convert.Converter;
import io.goodforgod.aws.simplelambda.handler.EventHandler;
import io.goodforgod.aws.simplelambda.handler.impl.BodyEventHandler;
import io.goodforgod.aws.simplelambda.runtime.EventContext;
import io.goodforgod.aws.simplelambda.runtime.RuntimeContext;
import io.goodforgod.aws.simplelambda.utils.InputStreamUtils;
import io.goodforgod.aws.simplelambda.utils.SubscriberUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Flow.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class BodyEventHandlerTests extends Assertions {

    @Test
    void bodyEventHandled() {
        try (final RuntimeContext context = new LambdaEntrypoint().getRuntimeContext()) {
            final EventHandler handler = context.getBean(BodyEventHandler.class);
            final Converter converter = context.getBean(Converter.class);

            final String eventBody = "{\"name\":\"Steeven King\"}";
            final APIGatewayV2HTTPEvent event = new APIGatewayV2HTTPEvent().setBody(eventBody);
            final String eventAsString = converter.toString(event);
            final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

            final Publisher<ByteBuffer> publisher = handler.handle(inputStream, EventContext.ofRequestId(UUID.randomUUID().toString()));
            assertNotNull(publisher);

            final String responseAsString = SubscriberUtils.getPublisherString(publisher);
            assertNotNull(responseAsString);
            assertTrue(responseAsString.contains("Hello - Steeven King"));
        } catch (Exception e) {
            fail(e);
        }
    }
}
