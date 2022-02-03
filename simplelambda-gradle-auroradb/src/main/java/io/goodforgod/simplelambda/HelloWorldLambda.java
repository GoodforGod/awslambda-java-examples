package io.goodforgod.simplelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class HelloWorldLambda implements RequestHandler<Request, Response> {

    private final ResponseService responseService;

    public HelloWorldLambda(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public Response handleRequest(Request request, Context context) {
        return responseService.getResponse(request);
    }
}
