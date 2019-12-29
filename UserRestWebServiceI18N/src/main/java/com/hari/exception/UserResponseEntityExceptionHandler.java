package com.hari.exception;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UserResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionResource> handleUserNotFoundException(UserNotFoundException ex,
			WebRequest request) {
		final ExceptionResource exceptionResource = new ExceptionResource(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResource, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResource> handleAllExceptions(Exception ex, WebRequest request) {
		final ExceptionResource exceptionResource = new ExceptionResource(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResource, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		final ExceptionResource exceptionResource = new ExceptionResource(new Date(), "Validation Failed!",
				ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
						.collect(Collectors.joining(", ")));

		for (final ObjectError objectError : ex.getBindingResult().getAllErrors()) {
			System.out.println(objectError.getDefaultMessage());
		}
		return new ResponseEntity<>(exceptionResource, HttpStatus.BAD_REQUEST);
	}

}
