package io.goodforgod.simplelambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.goodforgod.aws.simplelambda.AbstractLambdaEntrypoint;
import io.goodforgod.aws.simplelambda.runtime.RuntimeContext;
import io.goodforgod.graalvm.hint.annotation.InitializationHint;
import io.goodforgod.graalvm.hint.annotation.NativeImageHint;
import java.util.function.Function;

import io.goodforgod.graalvm.hint.annotation.TypeHint;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.commons.logging.impl.SimpleLog;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 16.09.2021
 */
@NativeImageHint(entrypoint = LambdaEntrypoint.class)
@InitializationHint(typeNames = "io.goodforgod.simplelambda")
@TypeHint(types = { LogFactory.class, LogFactoryImpl.class, SimpleLog.class })
public class LambdaEntrypoint extends AbstractLambdaEntrypoint {

    private static final LambdaEntrypoint ENTRYPOINT = new LambdaEntrypoint();

    public static void main(String[] args) {
        ENTRYPOINT.run(args);
    }

    @Override
    protected @NotNull Function<RuntimeContext, RequestHandler> getRequestHandler() {
        return context -> new HelloWorldLambda(new ResponseService());
    }
}