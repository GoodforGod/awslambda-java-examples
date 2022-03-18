package io.goodforgod.spring;

import org.springframework.nativex.hint.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@TypeHint(types = { Response.class })
public record Request(String name) {}
