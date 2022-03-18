package io.goodforgod.spring;

import io.goodforgod.spring.http.EtherscanService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@SpringBootApplication
public class LambdaEntrypoint implements ApplicationContextInitializer<GenericApplicationContext> {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(LambdaEntrypoint.class, args);
    }

    @Override
    public void initialize(GenericApplicationContext context) {
        final LambdaHandler handler = new LambdaHandler(new EtherscanService());
        context.registerBean(LambdaHandler.HANDLER_NAME,
                FunctionRegistration.class,
                () -> new FunctionRegistration<>(handler, LambdaHandler.HANDLER_NAME)
                        .type(FunctionType.from(Request.class).to(Response.class)));
    }
}
