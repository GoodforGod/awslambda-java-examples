package io.lambda;

import io.micronaut.core.annotation.TypeHint;
import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { User.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
@Data
public class User {

    private String name;
}
