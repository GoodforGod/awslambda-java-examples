package io.aws.lambda.simple.http;

import io.aws.lambda.simple.runtime.convert.Converter;
import io.aws.lambda.simple.runtime.error.StatusException;
import io.aws.lambda.simple.runtime.http.SimpleHttpClient;
import io.aws.lambda.simple.runtime.http.SimpleHttpResponse;
import io.micronaut.core.annotation.Introspected;
import io.net.uri.builder.URIBuilder;
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
                .queryParam("module", "block")
                .queryParam("action", "getblockreward")
                .build();
    }

    public EtherscanBlock getBlockByNumber(int blockNumber) {
        final URI uri = URIBuilder.of(baseUri)
                .queryParam("blockno", blockNumber)
                .build();

        final SimpleHttpResponse httpResponse = httpClient.get(uri);
        if (httpResponse.statusCode() != 200)
            throw new StatusException(httpResponse.statusCode(), "Error retrieving block");

        final EtherscanBlockResponse response = converter.fromJson(httpResponse.bodyAsString(), EtherscanBlockResponse.class);
        if (response.getStatus().equals("1")) {
            return response.getResult();
        } else {
            final int statusCode = Integer.parseInt(response.getStatus());
            throw new StatusException(statusCode, response.getMessage());
        }
    }
}
