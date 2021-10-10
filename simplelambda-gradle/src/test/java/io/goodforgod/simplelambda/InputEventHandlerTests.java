package io.goodforgod.simplelambda;

import io.goodforgod.aws.simplelambda.handler.EventHandler;
import io.goodforgod.aws.simplelambda.handler.impl.InputEventHandler;
import io.goodforgod.aws.simplelambda.runtime.EventContext;
import io.goodforgod.aws.simplelambda.runtime.RuntimeContext;
import io.goodforgod.aws.simplelambda.runtime.SimpleRuntimeContext;
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
class InputEventHandlerTests extends Assertions {

    @Test
    void inputEventHandled() {
        try (final RuntimeContext context = new SimpleRuntimeContext(c -> new HelloWorldLambda(new ResponseService()))) {
            final EventHandler handler = context.getBean(InputEventHandler.class);

            final String eventAsString = "{\"name\":\"Steeven King\"}";
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
