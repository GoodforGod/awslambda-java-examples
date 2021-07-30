package io.aws.lambda.quarkus;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@ApplicationScoped
public class ResponseService {

    public Response getResponse(Request request) {
        return new Response(UUID.randomUUID().toString(), "Hello - " + request.getName());
    }
}
