package io.lambda;

import io.aws.lambda.runtime.convert.Converter;
import io.aws.lambda.runtime.handler.impl.AwsEventHandler;
import io.aws.lambda.runtime.logger.LambdaLogger;
import io.aws.lambda.runtime.model.AwsRequestContext;
import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class BookLambdaTests extends Assertions {

    @Test
    void handleSuccess() {
        try (final ApplicationContext context = ApplicationContext.run()) {
            final Converter converter = context.getBean(Converter.class);
            final LambdaLogger logger = context.getBean(LambdaLogger.class);
            final AwsEventHandler handler = new AwsEventHandler(new BookLambda(), converter, logger);
            final String payload = "{\"context\":{\"requestId\":\"ecbc9432-a41c-4b71-bf7b-832b391e9e1b\"},\"httpMethod\":\"GET\",\"queryStringParameters\":{\"from\":\"one\",\"to\":\"ten\"},\"isBase64Encoded\":false}";

            final AwsRequestContext requestContext = new AwsRequestContext(UUID.randomUUID().toString(), UUID.randomUUID().toString());
            final String response = handler.handle(payload, requestContext);
            assertEquals("{\"queryParams\":{\"from\":\"one\",\"to\":\"ten\"}}", response);
        }
    }
}
