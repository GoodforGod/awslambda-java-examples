package io.goodforgod.quarkus.http;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
public record EtherscanBlockResponse(String status, String message, EtherscanBlock result) {}
