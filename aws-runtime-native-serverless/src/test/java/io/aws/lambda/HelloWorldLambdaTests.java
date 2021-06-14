package io.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import io.aws.lambda.runtime.LambdaContext;
import io.aws.lambda.runtime.convert.Converter;
import io.aws.lambda.runtime.handler.EventHandler;
import io.aws.lambda.runtime.handler.impl.RawEventHandler;
import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class HelloWorldLambdaTests extends Assertions {

    @Test
    void handleSuccess() {
        try (final ApplicationContext context = ApplicationContext.run()) {
            final Converter converter = context.getBean(Converter.class);
            final EventHandler handler = new RawEventHandler(new HelloWorldLambda(), converter);
            final String payload = "{\"context\":{\"requestId\":\"ecbc9432-a41c-4b71-bf7b-832b391e9e1b\"},\"httpMethod\":\"GET\",\"queryStringParameters\":{\"from\":\"one\",\"to\":\"ten\"},\"isBase64Encoded\":false}";

            final Context requestContext = LambdaContext.ofRequestId(UUID.randomUUID().toString());
            final String response = handler.handle(payload, requestContext);
            assertEquals("{\"queryParams\":{\"from\":\"one\",\"to\":\"ten\"}}", response);
        }
    }
}
