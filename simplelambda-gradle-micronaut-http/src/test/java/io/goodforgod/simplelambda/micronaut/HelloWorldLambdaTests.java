package io.goodforgod.simplelambda.micronaut;

import io.goodforgod.aws.simplelambda.handler.EventHandler;
import io.goodforgod.aws.simplelambda.handler.impl.BodyEventHandler;
import io.goodforgod.aws.simplelambda.handler.impl.InputEventHandler;
import io.goodforgod.aws.simplelambda.micronaut.MicronautBodyLambdaEntrypoint;
import io.goodforgod.aws.simplelambda.runtime.EventContext;
import io.goodforgod.aws.simplelambda.runtime.RuntimeContext;
import io.goodforgod.aws.simplelambda.utils.InputStreamUtils;
import io.goodforgod.aws.simplelambda.utils.SubscriberUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
    void gatewayEvent() throws Exception {
        final EventHandler handler = CONTEXT.getBean(BodyEventHandler.class);

        final String eventAsString = "{\"httpMethod\":\"GET\",\"queryStringParameters\":{\"from\":\"one\",\"to\":\"ten\"},\"isBase64Encoded\":false,\"body\":\"{\\\"blockNumber\\\":1}\"}";
        final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

        final Flow.Publisher<ByteBuffer> publisher = handler.handle(inputStream,
                EventContext.ofRequestId(UUID.randomUUID().toString()));
        assertNotNull(publisher);

        final String responseAsString = SubscriberUtils.getPublisherString(publisher);
        assertNotNull(responseAsString);
        assertTrue(responseAsString.contains("{\"blockReward\":\"5000000000000000000\""));
    }

    @Test
    void directEvent() throws Exception {
        final EventHandler handler = CONTEXT.getBean(InputEventHandler.class);

        final String eventAsString = "{\"blockNumber\":1}";
        final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

        final Flow.Publisher<ByteBuffer> publisher = handler.handle(inputStream,
                EventContext.ofRequestId(UUID.randomUUID().toString()));
        assertNotNull(publisher);

        final String responseAsString = SubscriberUtils.getPublisherString(publisher);
        assertNotNull(responseAsString);
        assertTrue(responseAsString.contains("{\"blockReward\":\"5000000000000000000\""));
    }
}
