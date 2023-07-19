package br.com.challenge.picpay.domain.transaction.validations;

import org.springframework.stereotype.Component;

import br.com.challenge.picpay.domain.transaction.Transaction;
import br.com.challenge.picpay.infra.config.exception.IllegalTransactionRequest;
import jakarta.persistence.DiscriminatorValue;

@Component("ValidationAccountSource")
public class ValidationAccountSource implements ValidationTransaction{

	@Override
	public void validate(Transaction transaction) {
		var typeUser = transaction.getSourceAccount().getUser().getClass().getAnnotation(DiscriminatorValue.class);

		if (typeUser.value().equals("LOJISTA")) {
			throw new IllegalTransactionRequest("Lojistas só podem receber transfêrencias");
		}
	}

}
