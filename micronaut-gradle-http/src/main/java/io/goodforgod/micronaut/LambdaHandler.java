package io.goodforgod.micronaut;

import io.goodforgod.micronaut.http.EtherscanBlock;
import io.goodforgod.micronaut.http.EtherscanService;
import io.micronaut.function.aws.MicronautRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class LambdaHandler extends MicronautRequestHandler<Request, Response> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EtherscanService etherscanService;

    public LambdaHandler(EtherscanService etherscanService) {
        this.etherscanService = etherscanService;
    }

    @Override
    public Response execute(Request request) {
        logger.info("Processing Block with number: {}", request.blockNumber());
        final long started = System.currentTimeMillis();

        final EtherscanBlock block = etherscanService.getBlockByNumber(request.blockNumber());

        logger.info("Block retrieval took '{}' millis", System.currentTimeMillis() - started);
        return new Response(block.blockReward(), "Hello Miner - " + block.blockMiner());
    }
}
