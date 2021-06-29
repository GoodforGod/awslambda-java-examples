package io.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Introspected;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.UUID;

@Introspected
@Singleton
public class HelloWorldLambda implements RequestHandler<User, UserResponse> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserResponse handleRequest(User user, Context context) {
        logger.info("Processing User with name: {}", user.getName());

        return new UserResponse(UUID.randomUUID().toString(), "Hello - " + user.getName());
    }
}
