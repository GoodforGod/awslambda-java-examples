package io.aws.lambda.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class HelloWorldLambda implements Function<Request, Response> {

    /**
     * Write that in AWS Lambda Handler name (Runtime Settings)
     */
    public static final String HANDLER_NAME = "hello-world";

    private final ResponseService responseService;

    @Autowired
    public HelloWorldLambda(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public Response apply(Request request) {
        return responseService.getResponse(request);
    }
}
