package io.aws.lambda.simple;

import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@Data
public class Response {

    private final String id;
    private final String message;
}
