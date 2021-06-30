package io.aws.lambda.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.nativex.hint.SerializationHint;

@SerializationHint(types = {Request.class, Response.class})
@SpringBootApplication
public class AwsLambdaRuntime implements ApplicationContextInitializer<GenericApplicationContext> {

    public static void main(final String[] args) {
        FunctionalSpringApplication.run(AwsLambdaRuntime.class, args);
    }

    @Override
    public void initialize(final GenericApplicationContext context) {
        context.registerBean(RequestHandler.FUNCTION_NAME,
                FunctionRegistration.class,
                () -> new FunctionRegistration<>(new RequestHandler()).type(FunctionType.from(String.class).to(String.class)));
    }
}
