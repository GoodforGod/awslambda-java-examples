package io.goodforgod.simplelambda;

import io.goodforgod.aws.lambda.events.gateway.APIGatewayV2HTTPEvent;
import io.goodforgod.aws.lambda.simple.convert.Converter;
import io.goodforgod.aws.lambda.simple.testing.AwsLambdaAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class LambdaHandlerTests extends Assertions {

    @Test
    void inputEventHandled() {
        final Request request = new Request(1);
        final Response response = AwsLambdaAssertions.ofEntrypoint(new LambdaEntrypoint())
                .input(context -> {
                    final Converter converter = context.getBean(Converter.class);
                    final String req = converter.toString(request);
                    final String event = converter.toString(new APIGatewayV2HTTPEvent().setBody(req));
                    return event.getBytes();
                })
                .expectJson(Response.class);

        assertEquals("Hello - Steeven King", response.message());
    }

    @Test
    void bodyEventHandled() {
        final Request request = new Request(1);
        final Response response = AwsLambdaAssertions.ofEntrypoint(new LambdaEntrypoint())
                .inputJson(request)
                .expectJson(Response.class);

        assertEquals("Hello - Steeven King", response.message());
    }
}
