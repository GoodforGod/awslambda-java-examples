package io.goodforgod.simplelambda.micronaut;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.goodforgod.aws.lambda.events.gateway.APIGatewayV2HTTPEvent;
import io.goodforgod.aws.lambda.simple.EventContextBuilder;
import io.goodforgod.aws.lambda.simple.convert.Converter;
import io.goodforgod.aws.lambda.simple.handler.EventHandler;
import io.goodforgod.aws.lambda.simple.handler.impl.BodyEventHandler;
import io.goodforgod.aws.lambda.simple.handler.impl.InputEventHandler;
import io.goodforgod.aws.lambda.simple.micronaut.MicronautInputLambdaEntrypoint;
import io.goodforgod.aws.lambda.simple.reactive.SubscriberUtils;
import io.goodforgod.aws.lambda.simple.runtime.RuntimeContext;
import io.goodforgod.aws.lambda.simple.utils.InputStreamUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Flow;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 30.11.2021
 */
class LambdaHandlerTests extends Assertions {

    private static final RuntimeContext CONTEXT = new MicronautInputLambdaEntrypoint().getRuntimeContext();

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
        final EventHandler eventHandler = CONTEXT.getBean(InputEventHandler.class);
        final RequestHandler requestHandler = CONTEXT.getBean(RequestHandler.class);

        final String eventAsString = "{\"name\":\"Steeven King\"}";
        final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

        final Context context = EventContextBuilder.builder().build();
        final Flow.Publisher<ByteBuffer> publisher = eventHandler.handle(requestHandler, inputStream, context);
        assertNotNull(publisher);

        final String responseAsString = SubscriberUtils.getPublisherString(publisher);
        assertNotNull(responseAsString);
        assertTrue(responseAsString.contains("Hello - Steeven King"));
    }

    @Test
    void bodyEventHandled() {
        final EventHandler eventHandler = CONTEXT.getBean(BodyEventHandler.class);
        final RequestHandler requestHandler = CONTEXT.getBean(RequestHandler.class);
        final Converter converter = CONTEXT.getBean(Converter.class);

        final String eventBody = "{\"name\":\"Steeven King\"}";
        final APIGatewayV2HTTPEvent event = new APIGatewayV2HTTPEvent().setBody(eventBody);
        final String eventAsString = converter.toString(event);
        final InputStream inputStream = InputStreamUtils.getInputStreamFromStringUTF8(eventAsString);

        final Context context = EventContextBuilder.builder().build();
        final Flow.Publisher<ByteBuffer> publisher = eventHandler.handle(requestHandler, inputStream, context);
        assertNotNull(publisher);

        final String responseAsString = SubscriberUtils.getPublisherString(publisher);
        assertNotNull(responseAsString);
        assertTrue(responseAsString.contains("Hello - Steeven King"));
    }
}