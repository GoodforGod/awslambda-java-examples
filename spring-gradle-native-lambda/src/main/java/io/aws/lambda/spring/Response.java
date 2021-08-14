package io.aws.lambda.spring;

import lombok.Data;
import org.springframework.nativex.hint.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(types = { Response.class })
@Data
public class Response {

    private final String id;
    private final String message;
}