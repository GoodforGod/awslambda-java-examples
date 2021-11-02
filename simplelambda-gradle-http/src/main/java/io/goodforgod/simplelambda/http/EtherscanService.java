package io.goodforgod.simplelambda.http;

import io.goodforgod.aws.simplelambda.convert.Converter;
import io.goodforgod.aws.simplelambda.error.StatusException;
import io.goodforgod.aws.simplelambda.http.SimpleHttpClient;
import io.goodforgod.aws.simplelambda.http.SimpleHttpResponse;
import io.goodforgod.net.uri.URIBuilder;

import java.net.URI;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
public class EtherscanService {

    private final URI baseUri;
    private final Converter converter;
    private final SimpleHttpClient httpClient;

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

        final EtherscanBlockResponse response = converter.fromString(httpResponse.bodyAsString(), EtherscanBlockResponse.class);
        if (response.getStatus().equals("1")) {
            return response.getResult();
        } else {
            final int statusCode = Integer.parseInt(response.getStatus());
            throw new StatusException(statusCode, response.getMessage());
        }
    }
}
