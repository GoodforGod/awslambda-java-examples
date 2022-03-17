package io.goodforgod.simplelambda.http;

import io.goodforgod.graalvm.hint.annotation.ReflectionHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@ReflectionHint
public record EtherscanBlockResponse(String status, String message, EtherscanBlock result) {}
