package io.aws.lambda.micronaut;

import io.micronaut.function.aws.MicronautRequestHandler;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class HelloWorldLambda extends MicronautRequestHandler<Request, Response> {

    private final ResponseService responseService;

    public HelloWorldLambda(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public Response execute(Request request) {
        return responseService.getResponse(request);
    }
}
