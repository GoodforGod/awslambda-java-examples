package io.aws.lambda.spring;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    private final String id;
    private final String message;
}
