package br.com.challenge.picpay.domain.transaction.validations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.challenge.picpay.domain.transaction.Transaction;
import br.com.challenge.picpay.infra.config.exception.InsufficientFunds;

@Component("ValidationBalance")
public class ValidationBalance implements ValidationTransaction{

	@Override
	public void validate(Transaction transaction) {
		BigDecimal value = transaction.getValueTransfer();
		BigDecimal balanceSource = transaction.getSourceAccount().getBalance();
		
		if (balanceSource.compareTo(value) < 0) {
			throw new InsufficientFunds("Saldo insuficiente");
		}
	}

}
