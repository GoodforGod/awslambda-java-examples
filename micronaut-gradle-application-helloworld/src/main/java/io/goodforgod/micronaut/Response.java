package io.goodforgod.micronaut;

import io.micronaut.core.annotation.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { Response.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
public record Response(String id, String message) {}
