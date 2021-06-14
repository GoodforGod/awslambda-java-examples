package io.aws.lambda.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class AwsLambdaRuntime {

    public static void main(String[] args) {
        SpringApplication.run(AwsLambdaRuntime.class, args);
    }

    @Bean
    public Function<String, String> handle() {
        return String::toUpperCase;
    }
}
