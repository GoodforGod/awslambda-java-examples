package io.aws.lambda.micronaut;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;

public class AwsLambdaRuntime
        extends AbstractMicronautLambdaRuntime<User, UserResponse, User, UserResponse> {

    public static void main(String[] args) {
        try {
            new AwsLambdaRuntime().run(args);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    protected RequestHandler<User, UserResponse> createRequestHandler(String... args) {
        return new HelloWorldLambda();
    }
}
