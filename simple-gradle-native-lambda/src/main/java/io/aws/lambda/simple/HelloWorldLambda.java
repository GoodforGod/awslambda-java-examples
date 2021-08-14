package io.aws.lambda.simple;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Introspected;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@Introspected
@Singleton
public class HelloWorldLambda implements RequestHandler<Request, Response> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ResponseService responseService;

    @Inject
    public HelloWorldLambda(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public Response handleRequest(Request request, Context context) {
        logger.info("Processing User with name: {}", request.getName());

        return responseService.getResponse(request);
    }
}
