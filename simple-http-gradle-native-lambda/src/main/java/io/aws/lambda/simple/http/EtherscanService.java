package io.aws.lambda.simple.http;

import io.aws.lambda.simple.runtime.convert.Converter;
import io.aws.lambda.simple.runtime.error.StatusException;
import io.aws.lambda.simple.runtime.http.SimpleHttpClient;
import io.aws.lambda.simple.runtime.http.SimpleHttpResponse;
import io.micronaut.core.annotation.Introspected;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URI;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@Introspected
@Singleton
public class EtherscanService {

    private final Converter converter;
    private final SimpleHttpClient httpClient;

    @Inject
    public EtherscanService(Converter converter, SimpleHttpClient httpClient) {
        this.converter = converter;
        this.httpClient = httpClient;
    }

    public EtherscanBlock getBlockByNumber(int blockNumber) {
        final URI uri = URI.create("https://api.etherscan.io/api?module=block&action=getblockreward&blockno=" + blockNumber);
        final SimpleHttpResponse httpResponse = httpClient.get(uri);
        if (httpResponse.statusCode() != 200)
            throw new StatusException("Error retrieving block", httpResponse.statusCode());

        final EtherscanBlockResponse response = converter.fromJson(httpResponse.bodyAsString(), EtherscanBlockResponse.class);
        if (response.getStatus().equals("1")) {
            return response.getResult();
        } else {
            final int statusCode = Integer.parseInt(response.getStatus());
            throw new StatusException(response.getMessage(), statusCode);
        }
    }
}
