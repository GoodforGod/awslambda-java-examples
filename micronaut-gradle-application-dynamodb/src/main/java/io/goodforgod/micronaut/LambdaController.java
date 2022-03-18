package io.goodforgod.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;
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
@Introspected
@Controller
public class LambdaController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final DynamoDbClient client = DynamoDbClient.builder()
            .region(Region.EU_CENTRAL_1)
            .build();

    @Post
    public Response getResponse(@Valid Request request) {
        logger.info("Processing User with name: {}", request.name());

        final String id = UUID.randomUUID().toString();
        final PutItemResponse response = client.putItem(PutItemRequest.builder()
                .tableName("Names")
                .item(Map.of("id", AttributeValue.builder().s(id).build(),
                        "name", AttributeValue.builder().s(request.name()).build()))
                .build());

        logger.info("DDB response code: {}", response.sdkHttpResponse().statusCode());
        return new Response(id, "Hello - " + request.name());
    }
}
