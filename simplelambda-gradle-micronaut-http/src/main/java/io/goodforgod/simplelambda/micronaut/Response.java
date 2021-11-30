package io.goodforgod.simplelambda.micronaut;

import io.goodforgod.graalvm.hint.annotation.TypeHint;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { TypeHint.AccessType.ALL_DECLARED })
@Introspected
@Data
public class Response {

    private final String blockReward;
    private final String message;
}
