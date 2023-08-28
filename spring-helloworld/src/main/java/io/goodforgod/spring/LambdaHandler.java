package io.goodforgod.spring;

import java.util.UUID;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@Service
public class LambdaHandler implements Function<Request, Response> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response apply(Request request) {
        logger.info("Processing User with name: {}", request.name());
        return new Response(UUID.randomUUID().toString(), "Hello - " + request.name());
    }
}
