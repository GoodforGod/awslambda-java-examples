package io.aws.lambda.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Introspected
public class HelloWorldLambda extends MicronautRequestHandler<User, UserResponse> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserResponse execute(User user) {
        logger.info("Processing User with name: {}", user.getName());

        return new UserResponse(UUID.randomUUID().toString(), "Hello - " + user.getName());
    }
}
