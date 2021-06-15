package io.aws.lambda.spring;

import java.util.UUID;
import java.util.function.Function;

public class RequestHandler implements Function<User, UserResponse> {

    @Override
    public UserResponse apply(User user) {
        return new UserResponse(UUID.randomUUID().toString(), "Hello - " + user.getName());
    }
}
