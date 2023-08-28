package io.goodforgod.simplelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class LambdaHandler implements RequestHandler<Request, Response> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response handleRequest(Request request, Context context) {
        logger.info("Processing User with name: {}", request.name());
        return new Response(UUID.randomUUID().toString(), "Hello - " + request.name());
    }
}
