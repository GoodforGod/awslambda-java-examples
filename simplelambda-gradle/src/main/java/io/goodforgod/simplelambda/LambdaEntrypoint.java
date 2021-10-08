package io.goodforgod.simplelambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.goodforgod.aws.lambda.simple.AbstractLambdaEntrypoint;
import io.goodforgod.graalvm.hint.annotation.InitializationHint;
import io.goodforgod.graalvm.hint.annotation.NativeImageHint;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 16.09.2021
 */
@NativeImageHint(entrypoint = LambdaEntrypoint.class)
@InitializationHint(typeNames = "io.goodforgod.simplelambda")
public class LambdaEntrypoint extends AbstractLambdaEntrypoint {

    public static void main(String[] args) {
        new LambdaEntrypoint().run(args);
    }

    @Override
    protected @NotNull RequestHandler getRequestHandler(String[] args) {
        return new HelloWorldLambda(new ResponseService());
    }
}
