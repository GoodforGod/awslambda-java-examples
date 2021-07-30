package io.aws.lambda.micronaut;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;

public class AwsLambdaRuntime
        extends AbstractMicronautLambdaRuntime<Request, Response, Request, Response> {

    public static void main(String[] args) {
        try {
            new AwsLambdaRuntime().run(args);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    protected RequestHandler<Request, Response> createRequestHandler(String... args) {
        return getApplicationContext().getBean(HelloWorldLambda.class);
    }
}
