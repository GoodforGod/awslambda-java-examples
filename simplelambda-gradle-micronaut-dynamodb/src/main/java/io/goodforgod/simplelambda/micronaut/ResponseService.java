package io.goodforgod.simplelambda.micronaut;

import io.micronaut.core.annotation.Introspected;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.UUID;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@Introspected
@Singleton
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Response getResponse(Request request) {
        logger.info("Processing User with name: {}", request.getName());
        return new Response(UUID.randomUUID().toString(), "Hello - " + request.getName());
    }
}