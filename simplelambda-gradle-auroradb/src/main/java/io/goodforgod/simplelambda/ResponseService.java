package io.goodforgod.simplelambda;

import io.goodforgod.aws.simplelambda.error.LambdaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Response getResponse(Request request) {
        logger.info("Processing User with name: {}", request.getName());
        final String id = UUID.randomUUID().toString();

        final String jdbcUrl = "jdbc:mariadb:aurora//localhost:3306/DB?allowMultiQueries=true&useSSL=false";
        try(Connection connection = DriverManager.getConnection(jdbcUrl, "", "")) {

        } catch (SQLException e) {
            throw new LambdaException(e.getMessage());
        }

        return new Response(id, "Hello - " + request.getName());
    }
}
