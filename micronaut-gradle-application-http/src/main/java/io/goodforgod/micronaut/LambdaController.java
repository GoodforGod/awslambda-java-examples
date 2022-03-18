package io.goodforgod.micronaut;

import io.goodforgod.micronaut.http.EtherscanBlock;
import io.goodforgod.micronaut.http.EtherscanService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@Introspected
@Controller
public class LambdaController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EtherscanService etherscanService;

    @Inject
    public LambdaController(EtherscanService etherscanService) {
        this.etherscanService = etherscanService;
    }

    @Post
    public Response getResponse(@Valid Request request) {
        logger.info("Processing Block with number: {}", request.blockNumber());
        final long started = System.currentTimeMillis();

        final EtherscanBlock block = etherscanService.getBlockByNumber(request.blockNumber());

        logger.info("Block retrieval took '{}' millis", System.currentTimeMillis() - started);
        return new Response(block.blockReward(), "Hello Miner - " + block.blockMiner());
    }
}
