package br.com.challenge.picpay.infra.config.exception;

public class IllegalTransactionRequest extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public IllegalTransactionRequest(String message) {
		super(message);
	}

}
