package io.aws.lambda.simple;

import com.amazonaws.services.lambda.runtime.Context;
import io.aws.lambda.simple.runtime.LambdaContext;
import io.aws.lambda.simple.runtime.handler.EventHandler;
import io.aws.lambda.simple.runtime.handler.impl.BodyEventHandler;
import io.aws.lambda.simple.runtime.handler.impl.InputEventHandler;
import io.aws.lambda.simple.runtime.utils.InputStreamUtils;
import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Collections;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class HelloWorldLambdaTests extends Assertions {

    @Test
    void gatewayEventHandled() {
        try (final ApplicationContext context = ApplicationContext.run()) {
            final EventHandler handler = context.getBean(BodyEventHandler.class);

            final Context requestContext = LambdaContext.ofHeaders(Collections.emptyMap());
            final String payload = "{\"httpMethod\":\"GET\",\"queryStringParameters\":{\"from\":\"one\",\"to\":\"ten\"},\"isBase64Encoded\":false,\"body\":\"{\\\"name\\\":\\\"bob\\\"}\"}";
            final InputStream inputStream = InputStreamUtils.getStringUTF8AsInputStream(payload);

            final String response = handler.handle(inputStream, requestContext);
            assertTrue(response.contains("Hello - bob"));
        }
    }

    @Test
    void rawEventHandled() {
        try (final ApplicationContext context = ApplicationContext.run()) {
            final EventHandler handler = context.getBean(InputEventHandler.class);

            final Context requestContext = LambdaContext.ofHeaders(Collections.emptyMap());
            final String payload = "{\"name\":\"bob\"}";
            final InputStream inputStream = InputStreamUtils.getStringUTF8AsInputStream(payload);

            final String response = handler.handle(inputStream, requestContext);
            assertTrue(response.contains("Hello - bob"));
        }
    }
}
