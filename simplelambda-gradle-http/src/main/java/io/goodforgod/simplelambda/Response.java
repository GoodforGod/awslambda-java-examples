package io.goodforgod.simplelambda;

import io.goodforgod.graalvm.hint.annotation.ReflectionHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@ReflectionHint
public record Response(String blockReward, String message) {}
