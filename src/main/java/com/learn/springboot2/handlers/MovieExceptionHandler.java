package com.learn.springboot2.handlers;

import com.learn.springboot2.exceptions.ResourceNotFoundDetails;
import com.learn.springboot2.exceptions.ResourceNotFoundException;
import com.learn.springboot2.utils.CommonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MovieExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ResourceNotFoundDetails> resourceNotFoundHandler(ResourceNotFoundException resourceNotFoundException) {
	return new ResponseEntity(
			ResourceNotFoundDetails.builder()
					.status(HttpStatus.NOT_FOUND.value())
					.timeStamp(new CommonUtils().localDateToDatabaseDate(LocalDateTime.now()))
					.details(resourceNotFoundException.getMessage())
					.title("Resources Not Found")
					.developerMessage(resourceNotFoundException.getClass().getSimpleName())
					.build()
			, HttpStatus.NOT_FOUND);
}
}
