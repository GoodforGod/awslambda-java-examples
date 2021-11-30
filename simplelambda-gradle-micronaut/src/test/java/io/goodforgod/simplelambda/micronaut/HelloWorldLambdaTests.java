package io.goodforgod.simplelambda.micronaut;

import io.goodforgod.aws.lambda.events.gateway.APIGatewayV2HTTPEvent;
import io.goodforgod.aws.simplelambda.convert.Converter;
import io.goodforgod.aws.simplelambda.handler.EventHandler;
import io.goodforgod.aws.simplelambda.handler.impl.BodyEventHandler;
import io.goodforgod.aws.simplelambda.handler.impl.InputEventHandler;
import io.goodforgod.aws.simplelambda.micronaut.MicronautBodyLambdaEntrypoint;
import io.goodforgod.aws.simplelambda.runtime.EventContext;
import io.goodforgod.aws.simplelambda.runtime.RuntimeContext;
import io.goodforgod.aws.simplelambda.utils.InputStreamUtils;
import io.goodforgod.aws.simplelambda.utils.SubscriberUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Flow;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class HelloWorldLambdaTests extends Assertions {

    private static final RuntimeContext CONTEXT = new MicronautBodyLambdaEntrypoint().getRuntimeContext();

    @BeforeAll
    public static void setup() {
        CONTEXT.setupInRuntime();
    }

    @AfterAll
    public static void cleanup() throws Exception {
        CONTEXT.close();
    }

    @Test
    void inputEventHandled() {
        final EventHandler handler = CONTEXT.getBean(InputEventHandler.class);

        final String eventAsString = "{\"name\":\"Steeven King\"}";
        final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

        final Flow.Publisher<ByteBuffer> publisher = handler.handle(inputStream, EventContext.ofRequestId(UUID.randomUUID().toString()));
        assertNotNull(publisher);

        final String responseAsString = SubscriberUtils.getPublisherString(publisher);
        assertNotNull(responseAsString);
        assertTrue(responseAsString.contains("Hello - Steeven King"));
    }

    @Test
    void bodyEventHandled() {
        final EventHandler handler = CONTEXT.getBean(BodyEventHandler.class);
        final Converter converter = CONTEXT.getBean(Converter.class);

        final String eventBody = "{\"name\":\"Steeven King\"}";
        final APIGatewayV2HTTPEvent event = new APIGatewayV2HTTPEvent().setBody(eventBody);
        final String eventAsString = converter.toString(event);
        final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

        final Flow.Publisher<ByteBuffer> publisher = handler.handle(inputStream, EventContext.ofRequestId(UUID.randomUUID().toString()));
        assertNotNull(publisher);

        final String responseAsString = SubscriberUtils.getPublisherString(publisher);
        assertNotNull(responseAsString);
        assertTrue(responseAsString.contains("Hello - Steeven King"));
    }
}
