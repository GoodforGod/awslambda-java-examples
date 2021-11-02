package io.goodforgod.simplelambda.http;

import io.goodforgod.graalvm.hint.annotation.TypeHint;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint
@Setter
@Getter
public class EtherscanBlockResponse {

    public String status;
    public String message;
    public EtherscanBlock result;
}
