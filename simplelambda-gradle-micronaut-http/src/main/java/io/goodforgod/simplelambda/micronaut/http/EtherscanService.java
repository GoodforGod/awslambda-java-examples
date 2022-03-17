package io.goodforgod.simplelambda.micronaut.http;

import io.goodforgod.aws.lambda.simple.convert.Converter;
import io.goodforgod.aws.lambda.simple.http.SimpleHttpClient;
import io.goodforgod.aws.lambda.simple.http.SimpleHttpResponse;
import io.goodforgod.http.common.HttpStatus;
import io.goodforgod.http.common.exception.HttpStatusException;
import io.goodforgod.http.common.uri.URIBuilder;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.net.URI;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@Introspected
@Singleton
public class EtherscanService {

    private final URI baseUri;
    private final Converter converter;
    private final SimpleHttpClient httpClient;

    @Inject
    public EtherscanService(Converter converter, SimpleHttpClient httpClient) {
        this.converter = converter;
        this.httpClient = httpClient;
        this.baseUri = URIBuilder.of("https://api.etherscan.io").path("/api")
                .param("module", "block")
                .param("action", "getblockreward")
                .build();
    }

    public EtherscanBlock getBlockByNumber(int blockNumber) {
        final URI uri = URIBuilder.of(baseUri)
                .param("blockno", blockNumber)
                .build();

        final SimpleHttpResponse httpResponse = httpClient.get(uri);
        if (!httpResponse.status().equals(HttpStatus.OK))
            throw new HttpStatusException(httpResponse.status(), "Error retrieving block");

        final EtherscanBlockResponse response = converter.fromString(httpResponse.bodyAsString(), EtherscanBlockResponse.class);
        if (response.status().equals("1")) {
            return response.result();
        } else {
            final int statusCode = Integer.parseInt(response.status());
            throw new HttpStatusException(HttpStatus.valueOf(statusCode), response.message());
        }
    }
}
