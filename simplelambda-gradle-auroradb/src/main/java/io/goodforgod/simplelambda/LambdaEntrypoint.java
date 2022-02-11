package io.goodforgod.simplelambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.goodforgod.aws.simplelambda.AbstractLambdaEntrypoint;
import io.goodforgod.aws.simplelambda.runtime.RuntimeContext;
import io.goodforgod.graalvm.hint.annotation.InitializationHint;
import io.goodforgod.graalvm.hint.annotation.NativeImageHint;
import io.goodforgod.graalvm.hint.annotation.ResourceHint;
import io.goodforgod.graalvm.hint.annotation.TypeHint;
import org.jetbrains.annotations.NotNull;
import org.mariadb.jdbc.Driver;
import org.mariadb.jdbc.internal.com.send.authentication.SendPamAuthPacket;
import org.mariadb.jdbc.internal.failover.impl.MastersFailoverListener;
import org.mariadb.jdbc.internal.failover.impl.MastersReplicasListener;
import org.mariadb.jdbc.internal.util.scheduler.DynamicSizedSchedulerImpl;
import org.mariadb.jdbc.util.Options;

import java.sql.DriverManager;
import java.util.function.Function;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 16.09.2021
 */
@NativeImageHint(entrypoint = LambdaEntrypoint.class, options = "--allow-incomplete-classpath")
@InitializationHint(typeNames = {
        "io.goodforgod.simplelambda",
        "java.sql.DriverManager",
        "org.mariadb"
})
@InitializationHint(value = InitializationHint.InitPhase.RUNTIME,
        typeNames = {
                "org.mariadb.jdbc.credential.aws",
                "org.mariadb.jdbc.internal.util.scheduler.DynamicSizedSchedulerImpl",
                "org.mariadb.jdbc.internal.failover.impl.MastersReplicasListener",
                "org.mariadb.jdbc.internal.failover.impl.MastersFailoverListener",
                "org.mariadb.jdbc.internal.com.send.authentication.SendPamAuthPacket",
        })
@TypeHint(types = {Driver.class, DriverManager.class, Options.class})
@ResourceHint(patterns = {
        "META-INF/services/java.sql.Driver",
        "META-INF/services/org.mariadb.jdbc.authentication.AuthenticationPlugin",
        "META-INF/services/org.mariadb.jdbc.credential.CredentialPlugin",
        "META-INF/services/org.mariadb.jdbc.tls.TlsSocketPlugin",
})
public class LambdaEntrypoint extends AbstractLambdaEntrypoint {

    private static final LambdaEntrypoint ENTRYPOINT = new LambdaEntrypoint();

    public static void main(String[] args) {
        ENTRYPOINT.run(args);
    }

    @Override
    public @NotNull RuntimeContext getRuntimeContext() {
        final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }

        return super.getRuntimeContext();
    }

    @Override
    protected @NotNull Function<RuntimeContext, RequestHandler> getRequestHandler() {
        return context -> new HelloWorldLambda(new ResponseService());
    }
}
