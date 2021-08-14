package io.aws.lambda.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class HelloWorldLambda implements SpringLambdaHandler, Function<Request, Response> {

    private final ResponseService responseService;

    @Autowired
    public HelloWorldLambda(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public String name() {
        return "hello-world";
    }

    @Override
    public Response apply(Request request) {
        return responseService.getResponse(request);
    }
}
