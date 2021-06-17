package io.aws.lambda.spring;

import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourceHint;
import org.springframework.nativex.type.NativeConfiguration;

@NativeHint(
        resources = @ResourceHint(patterns = "native-image.properties"))
public class LambdaHints implements NativeConfiguration {
}
