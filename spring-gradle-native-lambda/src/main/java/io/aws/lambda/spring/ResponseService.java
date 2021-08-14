package io.aws.lambda.spring;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */

@Service
public class ResponseService {

    public Response getResponse(Request request) {
        return new Response(UUID.randomUUID().toString(), "Hello - " + request.getName());
    }
}
