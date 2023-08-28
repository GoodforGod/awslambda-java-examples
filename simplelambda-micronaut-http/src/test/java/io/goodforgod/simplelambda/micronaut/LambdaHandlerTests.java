package io.goodforgod.simplelambda.micronaut;

import io.goodforgod.aws.lambda.events.gateway.APIGatewayV2HTTPEvent;
import io.goodforgod.aws.lambda.simple.convert.Converter;
import io.goodforgod.aws.lambda.simple.micronaut.MicronautBodyLambdaEntrypoint;
import io.goodforgod.aws.lambda.simple.micronaut.MicronautInputLambdaEntrypoint;
import io.goodforgod.aws.lambda.simple.testing.AwsLambdaAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 27.10.2020
 */
class LambdaHandlerTests extends Assertions {

    @Test
    void gatewayEvent() {
        final Request request = new Request(1);
        final Response response = AwsLambdaAssertions.ofEntrypoint(new MicronautBodyLambdaEntrypoint())
                .input(context -> {
                    final Converter converter = context.getBean(Converter.class);
                    final String req = converter.toString(request);
                    final String event = converter.toString(new APIGatewayV2HTTPEvent().setBody(req));
                    return event.getBytes();
                })
                .expectJson(Response.class);

        assertNotNull(response.message());
        assertNotNull(response.blockReward());
    }

    @Test
    void directEvent() {
        final Request request = new Request(1);
        final Response response = AwsLambdaAssertions.ofEntrypoint(new MicronautInputLambdaEntrypoint())
                .inputJson(request)
                .expectJson(Response.class);

        assertNotNull(response.message());
        assertNotNull(response.blockReward());
    }
}
