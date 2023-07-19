package br.com.challenge.picpay.domain.transaction.validations;

import org.springframework.stereotype.Component;

import br.com.challenge.picpay.config.exception.IllegalTransactionRequest;
import br.com.challenge.picpay.domain.transaction.Transaction;

@Component("ValidationAccountDestination")
public class ValidationAccountDestination implements ValidationTransaction{

	@Override
	public void validate(Transaction transaction) {
		
		if (transaction.getSourceAccount().equals(transaction.getDestinationAccount())) {
			throw new IllegalTransactionRequest("A conta de destino precisa ser diferente da conta de origem.");
		}
	}
	
}
