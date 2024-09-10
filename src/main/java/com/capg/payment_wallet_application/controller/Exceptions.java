package com.capg.payment_wallet_application.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.capg.payment_wallet_application.exception.InsufficientBalanceException;
import com.capg.payment_wallet_application.exception.InvalidInputException;
import com.capg.payment_wallet_application.exception.WalletNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class Exceptions {

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> exceptionConstraintViolationException(ConstraintViolationException exception) {
		StringBuilder msg = new StringBuilder();
		exception.getConstraintViolations().forEach(i -> msg.append(i.getConstraintDescriptor().getMessageTemplate()));
		return new ResponseEntity<>(msg.toString(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = InsufficientBalanceException.class)
	public ResponseEntity<Object> exceptionInsufficientBalanceException(InsufficientBalanceException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidInputException.class)
	public ResponseEntity<Object> exceptionInvalidInputException(InvalidInputException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> exceptionMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException exception) {
		ResponseEntity<Object> response = null;
		if (exception.getRequiredType() == java.time.LocalDate.class) {
			response = new ResponseEntity<>("Enter date format as dd-MM-yyyy", HttpStatus.NOT_ACCEPTABLE);
		}else {
			response = new ResponseEntity<>(exception.getRequiredType(), HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	@ExceptionHandler(value = InvalidFormatException.class)
	public ResponseEntity<Object> exceptionInvalidFormatException(InvalidFormatException exception) {
		ResponseEntity<Object> response = null;
		if (exception.getTargetType() == com.capg.payment_wallet_application.beans.BillType.class) {
			response = new ResponseEntity<>("Enter a valid bill type", HttpStatus.NOT_ACCEPTABLE);
		}else {
			response = new ResponseEntity<>(exception.getTargetType(), HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	@ExceptionHandler(value = WalletNotFoundException.class)
	public ResponseEntity<Object> exceptionWalletNotFoundException(WalletNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
