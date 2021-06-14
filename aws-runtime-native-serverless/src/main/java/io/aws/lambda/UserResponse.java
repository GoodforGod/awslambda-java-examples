package io.aws.lambda;

import io.micronaut.core.annotation.TypeHint;
import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { UserResponse.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
@Data
public class UserResponse {

    private final String id;
    private final String message;
}
