package io.goodforgod.quarkus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.commons.logging.impl.SimpleLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 28.07.2021
 */
@RegisterForReflection(targets = { LogFactory.class, LogFactoryImpl.class, SimpleLog.class })
@Named("hello-world")
@ApplicationScoped
public class LambdaHandler implements RequestHandler<Request, Response> {

    private static final Logger logger = LoggerFactory.getLogger(LambdaHandler.class);

    private static final DynamoDbClient client = DynamoDbClient.builder()
            .httpClient(ApacheHttpClient.create())
            .region(Region.EU_CENTRAL_1)
            .build();

    @Override
    public Response handleRequest(Request request, Context context) {
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
