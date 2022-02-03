package io.goodforgod.simplelambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

import java.util.Map;
import java.util.UUID;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    private final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
//            .withRegion("eu-central-1")
//            .build();
//
//    private final DynamoDB dynamoDB = new DynamoDB(client);

    private final DynamoDbClient client = DynamoDbClient.builder()
            .region(Region.EU_CENTRAL_1)
            .build();

    public Response getResponse(Request request) {
        logger.info("Processing User with name: {}", request.getName());

        final String id = UUID.randomUUID().toString();

        final PutItemResponse response = client.putItem(PutItemRequest.builder()
                        .tableName("Names")
                        .item(Map.of("id", AttributeValue.builder() .s(id) .build(),
                                "name", AttributeValue.builder().s(request.getName()).build()))
                .build());

        logger.info("DDB response code: {}", response.sdkHttpResponse().statusCode());

//        final Table table = dynamoDB.getTable("Names");
//        table.putItem(new Item()
//                .withPrimaryKey("uuid", id)
//                .withJSON("name", request.getName()));

        return new Response(id, "Hello - " + request.getName());
    }
}
