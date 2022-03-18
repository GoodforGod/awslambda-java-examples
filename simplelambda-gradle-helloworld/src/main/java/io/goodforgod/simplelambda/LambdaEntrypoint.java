package io.goodforgod.simplelambda;

import io.goodforgod.aws.lambda.simple.AbstractInputLambdaEntrypoint;
import io.goodforgod.aws.lambda.simple.runtime.SimpleRuntimeContext;
import io.goodforgod.graalvm.hint.annotation.InitializationHint;
import io.goodforgod.graalvm.hint.annotation.NativeImageHint;
import java.util.function.Consumer;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 16.09.2021
 */
@NativeImageHint(entrypoint = LambdaEntrypoint.class)
@InitializationHint(typeNames = "io.goodforgod.simplelambda")
public class LambdaEntrypoint extends AbstractInputLambdaEntrypoint {

    private static final LambdaEntrypoint ENTRYPOINT = new LambdaEntrypoint();

    public static void main(String[] args) {
        ENTRYPOINT.run(args);
    }

    @Override
    protected Consumer<SimpleRuntimeContext> setupInCompileTime() {
        return context -> {
            final LambdaHandler lambda = new LambdaHandler();
            context.registerBean(lambda);
        };
    }
}
