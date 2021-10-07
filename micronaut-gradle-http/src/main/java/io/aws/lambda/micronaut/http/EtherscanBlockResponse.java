package io.aws.lambda.micronaut.http;

import io.micronaut.core.annotation.TypeHint;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(value = EtherscanBlockResponse.class, accessType = TypeHint.AccessType.ALL_PUBLIC)
@Setter
@Getter
public class EtherscanBlockResponse {

    public String status;
    public String message;
    public EtherscanBlock result;
}
