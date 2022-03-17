package io.goodforgod.simplelambda.micronaut;

import io.goodforgod.simplelambda.micronaut.http.EtherscanBlock;
import io.goodforgod.simplelambda.micronaut.http.EtherscanService;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@Introspected
@Singleton
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EtherscanService etherscanService;

    @Inject
    public ResponseService(EtherscanService etherscanService) {
        this.etherscanService = etherscanService;
    }

    public Response getResponse(Request request) {
        logger.info("Processing Block with number: {}", request.blockNumber());
        final long started = System.currentTimeMillis();

        final EtherscanBlock block = etherscanService.getBlockByNumber(request.blockNumber());

        logger.info("Block retrieval took '{}' millis", System.currentTimeMillis() - started);
        return new Response(block.blockReward(), "Hello Miner - " + block.blockMiner());
    }
}
