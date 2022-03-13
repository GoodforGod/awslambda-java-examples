package io.goodforgod.simplelambda;

import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Response getResponse(Request request) {
        logger.info("Processing User with name: {}", request.getName());
        return new Response(UUID.randomUUID().toString(), "Hello - " + request.getName());
    }
}
