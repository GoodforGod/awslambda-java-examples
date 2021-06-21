package io.aws.lambda.spring;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.function.Function;

@Slf4j
public class RequestHandler implements Function<String, String> {

    public static final String FUNCTION_NAME = "requestHandler";

    @Override
    public String apply(final String request) {
        return "{\"id\":\"" + UUID.randomUUID() + "\"}";
    }
}
