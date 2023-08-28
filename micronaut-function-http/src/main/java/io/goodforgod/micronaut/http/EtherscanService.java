package io.goodforgod.micronaut.http;

import io.micronaut.context.exceptions.ConfigurationException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.exceptions.HttpStatusException;
import java.net.MalformedURLException;
import java.net.URI;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
public class EtherscanService {

    private final BlockingHttpClient etherscanHttpClient;

    public EtherscanService() {
        try {
            this.etherscanHttpClient = HttpClient.create(URI.create("https://api.etherscan.io/").toURL())
                    .toBlocking();
        } catch (MalformedURLException e) {
            throw new ConfigurationException(e.getMessage());
        }
    }

    public EtherscanBlock getBlockByNumber(int blockNumber) {
        final URI uri = URI.create("/api?module=block&action=getblockreward&blockno=" + blockNumber);
        final EtherscanBlockResponse response = etherscanHttpClient.retrieve(HttpRequest.GET(uri), EtherscanBlockResponse.class);
        if ("1".equals(response.status())) {
            return response.result();
        } else {
            final int statusCode = Integer.parseInt(response.status());
            throw new HttpStatusException(HttpStatus.valueOf(statusCode), response.message());
        }
    }
}
