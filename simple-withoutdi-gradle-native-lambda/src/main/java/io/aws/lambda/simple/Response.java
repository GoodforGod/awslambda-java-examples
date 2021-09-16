package io.aws.lambda.simple;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.TypeHint;
import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { Response.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
@Introspected
@Data
public class Response {

    private final String id;
    private final String message;
}
