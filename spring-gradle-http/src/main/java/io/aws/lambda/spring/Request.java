package io.aws.lambda.spring;

import lombok.Data;
import org.springframework.nativex.hint.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@TypeHint(types = { Response.class })
@Data
public class Request {

    private int blockNumber;
}
