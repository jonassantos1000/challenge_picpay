package br.com.challenge.picpay.domain.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.picpay.domain.account.Account;
import br.com.challenge.picpay.domain.account.AccountRepository;
import br.com.challenge.picpay.domain.transaction.validations.ValidationTransaction;

@Service
public class TransactionService {

	@Autowired
	private List<ValidationTransaction> validations;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	public Transaction requestTransfer(TransactionRequest transactionData) {
		Account accountSourced = accountRepository.findById(transactionData.getSourceAccountId()).get();
		Account accountDestination = accountRepository.findById(transactionData.getDestinationAccountId()).get();
		Transaction transaction = new Transaction(accountSourced, accountDestination,
				transactionData.getValueTransfer());

		this.validations.forEach(validation -> validation.validate(transaction));
		executeTransfer(transaction);
		
		return transactionRepository.save(transaction);
	}

	private void executeTransfer(Transaction transaction) {
		Account accountSourced = transaction.getSourceAccount();
		Account accountDestination = transaction.getDestinationAccount();

		accountSourced.setBalance(accountSourced.getBalance().subtract(transaction.getValueTransfer()));
		accountDestination.setBalance(accountDestination.getBalance().add(transaction.getValueTransfer()));
	}

}
