package io.goodforgod.simplelambda.micronaut;

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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class HelloWorldLambdaTests extends Assertions {

    @Test
    void gatewayEvent() throws Exception {
        try (RuntimeContext context = new MicronautBodyLambdaEntrypoint().getRuntimeContext()) {
            final EventHandler handler = context.getBean(BodyEventHandler.class);

            final String eventAsString = "{\"httpMethod\":\"GET\",\"queryStringParameters\":{\"from\":\"one\",\"to\":\"ten\"},\"isBase64Encoded\":false,\"body\":\"{\\\"name\\\":\\\"bob\\\"}\"}";
            final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

            final Flow.Publisher<ByteBuffer> publisher = handler.handle(inputStream,
                    EventContext.ofRequestId(UUID.randomUUID().toString()));
            assertNotNull(publisher);

            final String responseAsString = SubscriberUtils.getPublisherString(publisher);
            assertNotNull(responseAsString);
            assertTrue(responseAsString.contains("Hello - bob"));
        }
    }

    @Test
    void directEvent() throws Exception {
        try (RuntimeContext context = new MicronautBodyLambdaEntrypoint().getRuntimeContext()) {
            final EventHandler handler = context.getBean(InputEventHandler.class);

            final String eventAsString = "{\"name\":\"bob\"}";
            final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

            final Flow.Publisher<ByteBuffer> publisher = handler.handle(inputStream,
                    EventContext.ofRequestId(UUID.randomUUID().toString()));
            assertNotNull(publisher);

            final String responseAsString = SubscriberUtils.getPublisherString(publisher);
            assertNotNull(responseAsString);
            assertTrue(responseAsString.contains("Hello - bob"));
        }
    }
}
