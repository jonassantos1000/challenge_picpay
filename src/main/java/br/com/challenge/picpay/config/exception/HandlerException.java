package br.com.challenge.picpay.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

	@ExceptionHandler(IllegalTransactionRequest.class)
	public ResponseEntity<ResponseError> tratarErro404(IllegalTransactionRequest e, HttpServletRequest request){
		ResponseError error = new ResponseError(e.getMessage(), request.getRequestURI(), "Solicitação de transferência invalida.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(AuthorizationTransferException.class)
	public ResponseEntity<ResponseError> tratarErro404(AuthorizationTransferException e, HttpServletRequest request){
		ResponseError error = new ResponseError(e.getMessage(), request.getRequestURI(), "Transfência não autorizada.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}
