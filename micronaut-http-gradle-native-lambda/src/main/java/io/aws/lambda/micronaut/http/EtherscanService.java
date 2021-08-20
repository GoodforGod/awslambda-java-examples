package io.aws.lambda.micronaut.http;

import io.micronaut.context.exceptions.ConfigurationException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.exceptions.HttpStatusException;

import java.net.MalformedURLException;
import java.net.URI;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
public class EtherscanService {

    private final RxHttpClient etherscanHttpClient;

    public EtherscanService() {
        try {
            this.etherscanHttpClient = RxHttpClient.create(URI.create("https://api.etherscan.io/").toURL());
        } catch (MalformedURLException e) {
            throw new ConfigurationException(e.getMessage());
        }
    }

    public EtherscanBlock getBlockByNumber(int blockNumber) {
        final URI uri = URI.create("/api?module=block&action=getblockreward&blockno=" + blockNumber);
        final EtherscanBlockResponse response = etherscanHttpClient.retrieve(HttpRequest.GET(uri), EtherscanBlockResponse.class)
                .blockingFirst();
        if (response.getStatus().equals("1")) {
            return response.getResult();
        } else {
            final Integer statusCode = Integer.valueOf(response.getStatus());
            throw new HttpStatusException(HttpStatus.valueOf(statusCode), response.getMessage());
        }
    }
}
