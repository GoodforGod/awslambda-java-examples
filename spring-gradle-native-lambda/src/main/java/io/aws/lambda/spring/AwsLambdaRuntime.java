package io.aws.lambda.spring;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class AwsLambdaRuntime implements ApplicationContextInitializer<GenericApplicationContext> {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(AwsLambdaRuntime.class, args);
    }

    @Override
    public void initialize(GenericApplicationContext context) {
        final SpringLambdaHandler handler = new HelloWorldLambda(new ResponseService());
        context.registerBean(handler.name(),
                FunctionRegistration.class,
                () -> new FunctionRegistration<>(handler, handler.name()).type(FunctionType.from(Request.class).to(Response.class)));
    }
}
