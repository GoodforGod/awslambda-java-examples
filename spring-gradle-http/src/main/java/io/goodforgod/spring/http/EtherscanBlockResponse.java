package io.goodforgod.spring.http;

import org.springframework.nativex.hint.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(types = { EtherscanBlockResponse.class })
public record EtherscanBlockResponse(String status, String message, EtherscanBlock result) {}
