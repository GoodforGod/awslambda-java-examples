package io.aws.lambda.simple;

import io.micronaut.core.annotation.TypeHint;

/**
 * Please Add Description Here.
 *
 * @author Anton Kurako (GoodforGod)
 * @since 22.09.2021
 */
@TypeHint(value = { Response.class, Request.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
public interface Hints {
}
