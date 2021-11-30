package io.goodforgod.micronaut;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.goodforgod.micronaut.http.EtherscanService;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class LambdaEntrypoint extends AbstractMicronautLambdaRuntime<Request, Response, Request, Response> {

    public static void main(String[] args) {
        try {
            new LambdaEntrypoint().run(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    @Nullable
    protected RequestHandler<Request, Response> createRequestHandler(String... args) {
        return new HelloWorldLambda(new ResponseService(new EtherscanService()));
    }
}
