package io.aws.lambda.spring;

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
public class AwsLambdaRuntime implements ApplicationContextInitializer<GenericApplicationContext> {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(AwsLambdaRuntime.class, args);
    }

    @Override
    public void initialize(GenericApplicationContext context) {
        final HelloWorldLambda handler = new HelloWorldLambda(new ResponseService());
        context.registerBean(HelloWorldLambda.HANDLER_NAME,
                FunctionRegistration.class,
                () -> new FunctionRegistration<>(handler, HelloWorldLambda.HANDLER_NAME)
                        .type(FunctionType.from(Request.class).to(Response.class)));
    }
}
