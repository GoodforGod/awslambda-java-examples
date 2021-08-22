package io.aws.lambda.quarkus.http;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@Setter
@Getter
public class EtherscanBlockResponse {

    public String status;
    public String message;
    public EtherscanBlock result;
}
