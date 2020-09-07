package com.learn.springboot2.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResourceNotFoundDetails {
private String title;
private int status;
private String details;
private String developerMessage;
private String timeStamp;
}
