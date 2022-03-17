package io.goodforgod.simplelambda.micronaut;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.goodforgod.aws.lambda.simple.EventContextBuilder;
import io.goodforgod.aws.lambda.simple.handler.EventHandler;
import io.goodforgod.aws.lambda.simple.handler.impl.BodyEventHandler;
import io.goodforgod.aws.lambda.simple.handler.impl.InputEventHandler;
import io.goodforgod.aws.lambda.simple.micronaut.MicronautBodyLambdaEntrypoint;
import io.goodforgod.aws.lambda.simple.reactive.SubscriberUtils;
import io.goodforgod.aws.lambda.simple.runtime.RuntimeContext;
import io.goodforgod.aws.lambda.simple.utils.InputStreamUtils;
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
    void gatewayEvent() {
        final EventHandler eventHandler = CONTEXT.getBean(BodyEventHandler.class);
        final RequestHandler requestHandler = CONTEXT.getBean(RequestHandler.class);

        final String eventAsString = "{\"httpMethod\":\"GET\",\"queryStringParameters\":{\"from\":\"one\",\"to\":\"ten\"},\"isBase64Encoded\":false,\"body\":\"{\\\"blockNumber\\\":1}\"}";
        final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

        final Context eventContext = EventContextBuilder.builder().setAwsRequestId(UUID.randomUUID().toString()).build();
        final Flow.Publisher<ByteBuffer> publisher = eventHandler.handle(requestHandler, inputStream, eventContext);
        assertNotNull(publisher);

        final String responseAsString = SubscriberUtils.getPublisherString(publisher);
        assertNotNull(responseAsString);
        assertTrue(responseAsString.contains("{\"blockReward\":\"5000000000000000000\""));
    }

    @Test
    void directEvent() {
        final EventHandler eventHandler = CONTEXT.getBean(InputEventHandler.class);
        final RequestHandler requestHandler = CONTEXT.getBean(RequestHandler.class);

        final String eventAsString = "{\"blockNumber\":1}";
        final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

        final Context eventContext = EventContextBuilder.builder().setAwsRequestId(UUID.randomUUID().toString()).build();
        final Flow.Publisher<ByteBuffer> publisher = eventHandler.handle(requestHandler, inputStream, eventContext);
        assertNotNull(publisher);

        final String responseAsString = SubscriberUtils.getPublisherString(publisher);
        assertNotNull(responseAsString);
        assertTrue(responseAsString.contains("{\"blockReward\":\"5000000000000000000\""));
    }
}
