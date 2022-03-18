package io.goodforgod.spring.http;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.scheduler.Schedulers;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@Service
public class EtherscanService {

    private static final String MODULE = "module";
    private static final String ACTION = "action";
    private static final String BLOCKNO = "blockno";

    private final WebClient etherscanClient;

    @Autowired
    public EtherscanService() {
        this.etherscanClient = WebClient.create("https://api.etherscan.io");
    }

    public EtherscanBlock getBlockByNumber(int blockNumber) {
        final ResponseEntity<EtherscanBlockResponse> responseEntity = etherscanClient.get()
                .uri(b -> b.path("/api")
                        .queryParam(MODULE, "block")
                        .queryParam(ACTION, "getblockreward")
                        .queryParam(BLOCKNO, blockNumber)
                        .build())
                .retrieve()
                .toEntity(EtherscanBlockResponse.class)
                .subscribeOn(Schedulers.immediate())
                .timeout(Duration.ofSeconds(5))
                .toFuture()
                .join();

        final EtherscanBlockResponse response = responseEntity.getBody();
        if ("1".equals(response.status())) {
            return response.result();
        } else {
            final int statusCode = Integer.parseInt(response.status());
            throw new ResponseStatusException(HttpStatus.valueOf(statusCode), response.message());
        }
    }
}
