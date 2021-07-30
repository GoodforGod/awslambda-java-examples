package io.aws.lambda;

import io.micronaut.core.annotation.TypeHint;
import lombok.Data;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { Request.class },
        accessType = { TypeHint.AccessType.ALL_DECLARED_CONSTRUCTORS, TypeHint.AccessType.ALL_DECLARED_FIELDS })
@Data
public class Request {

    private String name;
}
