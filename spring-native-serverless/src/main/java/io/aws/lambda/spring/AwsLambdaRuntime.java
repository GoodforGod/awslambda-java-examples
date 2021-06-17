package io.aws.lambda.spring;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootConfiguration
public class AwsLambdaRuntime implements ApplicationContextInitializer<GenericApplicationContext> {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(AwsLambdaRuntime.class, args);
    }

    @Override
    public void initialize(GenericApplicationContext context) {
        context.registerBean("requestHandler",
                FunctionRegistration.class,
                () -> new FunctionRegistration<>(new RequestHandler()).type(RequestHandler.class));
    }
}
