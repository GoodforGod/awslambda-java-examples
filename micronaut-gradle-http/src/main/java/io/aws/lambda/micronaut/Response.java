package io.aws.lambda.micronaut;

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

    private final String blockReward;
    private final String message;
}
