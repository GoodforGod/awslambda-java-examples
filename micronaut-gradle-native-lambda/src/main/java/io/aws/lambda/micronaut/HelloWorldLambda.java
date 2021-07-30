package io.aws.lambda.micronaut;

import io.micronaut.function.aws.MicronautRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HelloWorldLambda extends MicronautRequestHandler<Request, Response> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ResponseService responseService;

    @Inject
    public HelloWorldLambda(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public Response execute(Request request) {
        logger.info("Processing User with name: {}", request.getName());

        return responseService.getResponse(request);
    }
}
