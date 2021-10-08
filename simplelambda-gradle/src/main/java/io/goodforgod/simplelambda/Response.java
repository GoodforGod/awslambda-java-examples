package io.goodforgod.simplelambda;

import io.goodforgod.graalvm.hint.annotation.TypeHint;
import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint
@Data
public class Response {

    private final String id;
    private final String message;
}
