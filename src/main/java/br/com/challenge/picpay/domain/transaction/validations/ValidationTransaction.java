package br.com.challenge.picpay.domain.transaction.validations;

import br.com.challenge.picpay.domain.transaction.Transaction;

public interface ValidationTransaction {
	void validate(Transaction transaction);
}
