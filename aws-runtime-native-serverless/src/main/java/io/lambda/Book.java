package io.lambda;

import io.micronaut.core.annotation.TypeHint;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { Book.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
@Getter
@AllArgsConstructor
public class Book {

    private final String id;
    private final String name;
}
