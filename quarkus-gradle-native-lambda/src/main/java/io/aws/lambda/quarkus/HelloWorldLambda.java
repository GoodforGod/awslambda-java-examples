package io.aws.lambda.quarkus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Named;
import java.util.UUID;

/**
 * Please Add Description Here.
 *
 * @author Anton Kurako (GoodforGod)
 * @since 28.07.2021
 */
@Named("hello-world")
public class HelloWorldLambda implements RequestHandler<User, Response> {

    @Override
    public Response handleRequest(User user, Context context) {
        return new Response(UUID.randomUUID().toString(), "Hello - " + user.getName());
    }
}
