package br.com.challenge.picpay.infra.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

	@ExceptionHandler(IllegalTransactionRequest.class)
	public ResponseEntity<ResponseError> illegalTransactionRequest(IllegalTransactionRequest e, HttpServletRequest request){
		ResponseError error = new ResponseError(e.getMessage(), request.getRequestURI(), "Solicitação de transferência invalida.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(AuthorizationTransferException.class)
	public ResponseEntity<ResponseError> authorizationTransferException(AuthorizationTransferException e, HttpServletRequest request){
		ResponseError error = new ResponseError(e.getMessage(), request.getRequestURI(), "Transfência não autorizada.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(InsufficientFunds.class)
	public ResponseEntity<ResponseError> insufficientFunds(InsufficientFunds e, HttpServletRequest request){
		ResponseError error = new ResponseError(e.getMessage(), request.getRequestURI(), "A conta não tem saldo suficiente.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}
