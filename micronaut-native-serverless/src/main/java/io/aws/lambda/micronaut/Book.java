package io.aws.lambda.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.TypeHint;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@TypeHint(value = { Book.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
@Getter
@Setter
@Introspected
public class Book {

    @NonNull
    @NotBlank
    private String name;
}
