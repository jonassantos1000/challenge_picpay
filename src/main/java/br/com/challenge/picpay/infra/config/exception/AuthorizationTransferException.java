package br.com.challenge.picpay.infra.config.exception;

public class AuthorizationTransferException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthorizationTransferException(String message) {
		super(message);
	}

}
