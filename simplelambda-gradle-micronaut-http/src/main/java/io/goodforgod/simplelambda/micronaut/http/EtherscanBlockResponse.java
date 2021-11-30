package io.goodforgod.simplelambda.micronaut.http;

import io.goodforgod.graalvm.hint.annotation.TypeHint;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(value = { TypeHint.AccessType.ALL_DECLARED })
@Setter
@Getter
public class EtherscanBlockResponse {

    private String status;
    private String message;
    private EtherscanBlock result;
}
