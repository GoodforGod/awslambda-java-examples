package io.aws.lambda.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */

@Service
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Response getResponse(Request request) {
        logger.info("Processing User with name: {}", request.getName());
        return new Response(UUID.randomUUID().toString(), "Hello - " + request.getName());
    }
}
