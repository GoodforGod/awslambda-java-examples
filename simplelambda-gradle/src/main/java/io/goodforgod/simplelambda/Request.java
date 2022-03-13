package io.goodforgod.simplelambda;

import io.goodforgod.graalvm.hint.annotation.ReflectionHint;
import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@ReflectionHint
@Data
public class Request {

    private String name;
}
