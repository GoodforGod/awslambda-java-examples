package io.micronaut.aws;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.TypeHint;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@TypeHint(value = { BookSaved.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
@Accessors(chain = true)
@Getter
@Setter
@Introspected
public class BookSaved {

    @NonNull
    @NotBlank
    private String name;

    @NonNull
    @NotBlank
    private String isbn;
}
