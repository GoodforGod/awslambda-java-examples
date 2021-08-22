package io.aws.lambda.quarkus;

import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@Data
public class Response {

    private final String blockReward;
    private final String message;
}
