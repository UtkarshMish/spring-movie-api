package com.learn.springboot2.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ValidationDetails extends ExceptionDetails {
private String field;
private String fieldError;
}
