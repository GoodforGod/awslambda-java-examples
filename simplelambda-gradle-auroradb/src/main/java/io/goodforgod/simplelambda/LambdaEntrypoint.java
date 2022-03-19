package io.goodforgod.simplelambda;

import io.goodforgod.aws.lambda.simple.AbstractInputLambdaEntrypoint;
import io.goodforgod.aws.lambda.simple.runtime.SimpleRuntimeContext;
import io.goodforgod.graalvm.hint.annotation.*;
import java.sql.DriverManager;
import java.util.function.Consumer;
import org.mariadb.jdbc.Driver;
import org.mariadb.jdbc.util.Options;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 16.09.2021
 */
@NativeImageHint(entrypoint = LambdaEntrypoint.class,
        options = { NativeImageOptions.ALLOW_INCOMPLETE_CLASSPATH, NativeImageOptions.REPORT_UNSUPPORTED })
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
@ReflectionHint(types = { Driver.class, DriverManager.class, Options.class })
@ResourceHint(patterns = {
        "META-INF/services/java.sql.Driver",
        "META-INF/services/org.mariadb.jdbc.authentication.AuthenticationPlugin",
        "META-INF/services/org.mariadb.jdbc.credential.CredentialPlugin",
        "META-INF/services/org.mariadb.jdbc.tls.TlsSocketPlugin",
})
public class LambdaEntrypoint extends AbstractInputLambdaEntrypoint {

    private static final LambdaEntrypoint ENTRYPOINT = new LambdaEntrypoint();

    public static void main(String[] args) {
        ENTRYPOINT.run(args);
    }

    @Override
    protected Consumer<SimpleRuntimeContext> setupInCompileTime() {
        return context -> {
            final LambdaHandler lambda = new LambdaHandler();
            context.registerBean(lambda);
        };
    }
}
