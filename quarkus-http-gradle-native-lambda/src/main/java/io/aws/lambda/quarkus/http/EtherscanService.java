package io.aws.lambda.quarkus.http;

import io.vertx.ext.web.handler.HttpException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@Singleton
public class EtherscanService {

    private static final String MODULE = "block";
    private static final String ACTION = "getblockreward";

    private final EtherscanClient etherscanClient;

    @Inject
    public EtherscanService(@RestClient EtherscanClient etherscanClient) {
        this.etherscanClient = etherscanClient;
    }

    public EtherscanBlock getBlockByNumber(int blockNumber) {
        final EtherscanBlockResponse response = etherscanClient.getBlockByNumber(MODULE, ACTION, blockNumber);
        if ("1".equals(response.getStatus())) {
            return response.getResult();
        } else {
            final int statusCode = Integer.parseInt(response.getStatus());
            throw new HttpException(statusCode, response.getMessage());
        }
    }
}
