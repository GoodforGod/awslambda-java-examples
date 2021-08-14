package io.aws.lambda.quarkus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 28.07.2021
 */
@Named("hello-world")
@ApplicationScoped
public class HelloWorldLambda implements RequestHandler<Request, Response> {

    private final ResponseService responseService;

    @Inject
    public HelloWorldLambda(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public Response handleRequest(Request request, Context context) {
        return responseService.getResponse(request);
    }
}
