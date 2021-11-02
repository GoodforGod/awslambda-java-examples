package io.goodforgod.simplelambda;

import io.goodforgod.simplelambda.http.EtherscanBlock;
import io.goodforgod.simplelambda.http.EtherscanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EtherscanService etherscanService;

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
