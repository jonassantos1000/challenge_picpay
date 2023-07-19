package br.com.challenge.picpay.domain.transaction.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.challenge.picpay.domain.transaction.Transaction;
import br.com.challenge.picpay.domain.transaction.TransactionAuthorization;
import br.com.challenge.picpay.http.AuthorizationExternalService;

@Component("ValidationAuthorizationTransfer")
public class ValidationAuthorizationTransfer implements ValidationTransaction {

	@Autowired
	private AuthorizationExternalService authorizationExternalService;
	
	@Override
	public void validate(Transaction transaction) {
		TransactionAuthorization authTransfer = authorizationExternalService.checkAuthorization();
		if (!authTransfer.message().equals("Autorizado")) {
			throw new IllegalArgumentException("Transferencia não autorizada!");
		}
	}

}
