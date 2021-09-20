package io.aws.lambda.simple;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.aws.lambda.simple.runtime.AbstractLambdaEntrypoint;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 16.09.2021
 */
public class LambdaEntrypoint extends AbstractLambdaEntrypoint {

    public static void main(String[] args) {
        new LambdaEntrypoint().run(args);
    }

    @Override
    protected @NotNull RequestHandler getRequestHandler(String[] args) {
        return new HelloWorldLambda(new ResponseService());
    }
}
