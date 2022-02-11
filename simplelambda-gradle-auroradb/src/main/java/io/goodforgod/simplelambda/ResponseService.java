package io.goodforgod.simplelambda;

import io.goodforgod.aws.simplelambda.error.LambdaException;
import org.mariadb.jdbc.util.DefaultOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.UUID;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String SQL = """
            INSERT INTO users(id, name)
            VALUES (?, ?);
            """;

    public Response getResponse(Request request) {
        logger.info("Processing User with name: {}", request.getName());
        final String id = UUID.randomUUID().toString();

        logger.info("Getting envs");
        final String endpoint = System.getenv("AURORA_ENDPOINT");
        final String user = System.getenv("AURORA_USER");
        final String pass = System.getenv("AURORA_PASS");
        final String database = System.getenv("AURORA_DB");

        final String jdbcUrl = "jdbc:mariadb:aurora//" + endpoint + ":3306/" + database;
        logger.info("Getting connection");
        Properties info = new Properties();
        info.put(DefaultOptions.USER.getOptionName(), user);
        info.put(DefaultOptions.PASSWORD.getOptionName(), pass);
        info.put(DefaultOptions.CONNECT_TIMEOUT.getOptionName(), 2000);

        try (final Connection connection = DriverManager.getConnection(jdbcUrl, info)) {
            logger.info("Got connection");
            try (final PreparedStatement statement = connection.prepareStatement(SQL)) {
                logger.info("Got statement");
                statement.setString(1, id);
                statement.setString(2, request.getName());
                logger.info("Executing statement");
                statement.executeUpdate();
                logger.info("Statement executed");
            }
        } catch (Exception e) {
            throw new LambdaException(e.getMessage());
        }

        return new Response(id, "Hello - " + request.getName());
    }
}
