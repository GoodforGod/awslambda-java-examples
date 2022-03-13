package io.goodforgod.simplelambda;

import io.goodforgod.aws.simplelambda.AbstractInputLambdaEntrypoint;
import io.goodforgod.aws.simplelambda.runtime.SimpleRuntimeContext;
import io.goodforgod.graalvm.hint.annotation.InitializationHint;
import io.goodforgod.graalvm.hint.annotation.NativeImageHint;
import io.goodforgod.graalvm.hint.annotation.ReflectionHint;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.commons.logging.impl.SimpleLog;

import java.util.function.Consumer;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 16.09.2021
 */
@NativeImageHint(entrypoint = LambdaEntrypoint.class)
@InitializationHint(typeNames = "io.goodforgod.simplelambda")
@ReflectionHint(types = { LogFactory.class, LogFactoryImpl.class, SimpleLog.class })
public class LambdaEntrypoint extends AbstractInputLambdaEntrypoint {

    private static final LambdaEntrypoint ENTRYPOINT = new LambdaEntrypoint();

    public static void main(String[] args) {
        ENTRYPOINT.run(args);
    }

    @Override
    protected Consumer<SimpleRuntimeContext> setupInRuntime() {
        return context -> new HelloWorldLambda(new ResponseService());
    }
}
