package io.goodforgod.quarkus.http;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.08.2021
 */
@Path("/api")
@RegisterRestClient(configKey = "etherscan-api")
public interface EtherscanClient {

    @GET
    @Path("/")
    @Produces(value = MediaType.APPLICATION_JSON)
    EtherscanBlockResponse getBlockByNumber(@QueryParam("module") String module,
                                            @QueryParam("action") String action,
                                            @QueryParam("blockno") int blockNumber);
}
