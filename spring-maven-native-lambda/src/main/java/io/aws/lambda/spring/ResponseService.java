package io.aws.lambda.spring;

import org.springframework.stereotype.Service;

import javax.inject.Singleton;
import java.util.UUID;

/**
 * Please Add Description Here.
 *
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@Service
public class ResponseService {

    public Response getResponse(Request request) {
        return new Response(UUID.randomUUID().toString(), "Hello - " + request.getName());
    }
}
