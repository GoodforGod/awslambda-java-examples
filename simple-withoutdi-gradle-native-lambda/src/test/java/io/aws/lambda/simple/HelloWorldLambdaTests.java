package io.aws.lambda.simple;

import io.aws.lambda.simple.runtime.LambdaContext;
import io.aws.lambda.simple.runtime.handler.EventHandler;
import io.aws.lambda.simple.runtime.handler.impl.BodyEventHandler;
import io.aws.lambda.simple.runtime.handler.impl.InputEventHandler;
import io.aws.lambda.simple.runtime.utils.InputStreamUtils;
import io.aws.lambda.simple.runtime.utils.SubscriberUtils;
import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Flow;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class HelloWorldLambdaTests extends Assertions {

    @Test
    void gatewayEvent() {
        try (final ApplicationContext context = ApplicationContext.run()) {
            final EventHandler handler = context.getBean(BodyEventHandler.class);

            final String eventAsString = "{\"httpMethod\":\"GET\",\"queryStringParameters\":{\"from\":\"one\",\"to\":\"ten\"},\"isBase64Encoded\":false,\"body\":\"{\\\"name\\\":\\\"bob\\\"}\"}";
            final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

            final Flow.Publisher<ByteBuffer> publisher = handler.handle(inputStream,
                    LambdaContext.ofRequestId(UUID.randomUUID().toString()));
            assertNotNull(publisher);

            final String responseAsString = SubscriberUtils.getPublisherString(publisher);
            assertNotNull(responseAsString);
            assertTrue(responseAsString.contains("Hello - bob"));
        }
    }

    @Test
    void directEvent() {
        try (final ApplicationContext context = ApplicationContext.run()) {
            final EventHandler handler = context.getBean(InputEventHandler.class);

            final String eventAsString = "{\"name\":\"bob\"}";
            final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

            final Flow.Publisher<ByteBuffer> publisher = handler.handle(inputStream,
                    LambdaContext.ofRequestId(UUID.randomUUID().toString()));
            assertNotNull(publisher);

            final String responseAsString = SubscriberUtils.getPublisherString(publisher);
            assertNotNull(responseAsString);
            assertTrue(responseAsString.contains("Hello - bob"));
        }
    }
}
