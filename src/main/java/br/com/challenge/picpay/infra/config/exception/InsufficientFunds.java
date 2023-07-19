package br.com.challenge.picpay.infra.config.exception;

public class InsufficientFunds extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InsufficientFunds(String message) {
		super(message);
	}
	
}
