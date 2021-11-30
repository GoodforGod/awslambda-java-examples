package io.aws.lambda.spring.http;

import lombok.Getter;
import lombok.Setter;
import org.springframework.nativex.hint.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(types = { EtherscanBlockResponse.class })
@Setter
@Getter
public class EtherscanBlockResponse {

    public String status;
    public String message;
    public EtherscanBlock result;
}
