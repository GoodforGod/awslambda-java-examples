package io.lambda;

import io.micronaut.core.annotation.TypeHint;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { User.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
@Getter
@Setter
public class User {

    private String id;
    private String name;
}
