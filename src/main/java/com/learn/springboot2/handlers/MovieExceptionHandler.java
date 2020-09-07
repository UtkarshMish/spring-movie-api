package com.learn.springboot2.handlers;

import com.learn.springboot2.exceptions.ResourceNotFoundDetails;
import com.learn.springboot2.exceptions.ResourceNotFoundException;
import com.learn.springboot2.exceptions.ValidationDetails;
import com.learn.springboot2.utils.CommonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

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

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ResourceNotFoundDetails> validationHandler(MethodArgumentNotValidException notValidException) {
	var field = notValidException.getBindingResult().getFieldErrors().stream().map(FieldError::getField).collect(Collectors.joining(", "));
	return new ResponseEntity(
			ValidationDetails.builder()
					.status(HttpStatus.BAD_REQUEST.value())
					.timeStamp(new CommonUtils().localDateToDatabaseDate(LocalDateTime.now()))
					.details("Check " + notValidException.getBindingResult().getFieldErrorCount() + " field(s) below.")
					.title("Validation Error")
					.developerMessage(notValidException.getClass().getSimpleName())
					.fieldError(field + " of " + notValidException.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", ")))
					.field(field)
					.build()
			, HttpStatus.BAD_REQUEST);
}
}
