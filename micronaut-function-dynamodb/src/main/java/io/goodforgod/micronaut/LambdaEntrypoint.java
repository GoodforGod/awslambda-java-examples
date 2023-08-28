package io.goodforgod.micronaut;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.annotation.TypeHint;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.commons.logging.impl.SimpleLog;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@TypeHint(value = { LogFactory.class, LogFactoryImpl.class, SimpleLog.class }, accessType = TypeHint.AccessType.ALL_PUBLIC)
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
        return new LambdaHandler();
    }
}
