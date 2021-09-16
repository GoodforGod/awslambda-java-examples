package io.aws.lambda.simple;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.aws.lambda.simple.runtime.AbstractLambdaEntrypoint;
import io.aws.lambda.simple.runtime.handler.EventHandler;
import io.aws.lambda.simple.runtime.handler.impl.InputEventHandler;
import io.aws.lambda.simple.runtime.runtime.RuntimeContext;
import io.aws.lambda.simple.runtime.runtime.SimpleRuntimeContext;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 16.09.2021
 */
public class LambdaEntrypoint extends AbstractLambdaEntrypoint {

    public static class HelloWorldContext extends SimpleRuntimeContext {

        @Override
        protected @NotNull RequestHandler createRequestHandler() {
            return new HelloWorldLambda(new ResponseService());
        }
    }

    public static void main(String[] args) {
        new LambdaEntrypoint().run(args);
    }

    @Override
    protected @NotNull Class<? extends EventHandler> getEventHandlerType(String[] args) {
        return InputEventHandler.class;
    }

    @Override
    protected @NotNull RuntimeContext getRuntimeContext(String[] args) {
        return new HelloWorldContext();
    }
}
