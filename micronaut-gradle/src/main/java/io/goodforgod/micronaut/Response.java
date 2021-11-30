package io.goodforgod.micronaut;

import io.micronaut.core.annotation.TypeHint;
import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { Response.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
@Data
public class Response {

    private final String id;
    private final String message;
}
