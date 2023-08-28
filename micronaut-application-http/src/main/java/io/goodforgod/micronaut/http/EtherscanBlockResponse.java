package io.goodforgod.micronaut.http;

import io.micronaut.core.annotation.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(value = EtherscanBlockResponse.class, accessType = TypeHint.AccessType.ALL_PUBLIC)
public record EtherscanBlockResponse(String status, String message, EtherscanBlock result) {}
