package io.micronaut.aws;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;

public class AwsLambdaRuntime
        extends AbstractMicronautLambdaRuntime<Book, BookSaved, Book, BookSaved> {

    public static void main(String[] args) {
        try {
            new AwsLambdaRuntime().run(args);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    protected RequestHandler<Book, BookSaved> createRequestHandler(String... args) {
        return new BookLambda();
    }
}
