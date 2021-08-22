package io.aws.lambda.quarkus;

import io.aws.lambda.quarkus.http.EtherscanBlock;
import io.aws.lambda.quarkus.http.EtherscanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@ApplicationScoped
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EtherscanService etherscanService;

    @Inject
    public ResponseService(EtherscanService etherscanService) {
        this.etherscanService = etherscanService;
    }

    public Response getResponse(Request request) {
        logger.info("Processing Block with number: {}", request.getBlockNumber());
        final long started = System.currentTimeMillis();

        final EtherscanBlock block = etherscanService.getBlockByNumber(request.getBlockNumber());

        logger.info("Block retrieval took '{}' millis", System.currentTimeMillis() - started);
        return new Response(block.getBlockReward(), "Hello Miner - " + block.getBlockMiner());
    }
}
