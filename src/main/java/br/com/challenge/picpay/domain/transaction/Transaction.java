package br.com.challenge.picpay.domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.challenge.picpay.account.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "source_account_id")
	private Account sourceAccount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "destination_account_id")
	private Account destinationAccount;
	
	private BigDecimal valueTransfer;
	private LocalDateTime dateTransaction;
	 
	
	public Transaction() {
		this.dateTransaction = LocalDateTime.now();
	}

	public Transaction(Account sourceAccount, Account destinationAccount, BigDecimal valueTransfer) {
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.valueTransfer = valueTransfer;
		this.dateTransaction = LocalDateTime.now();
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public LocalDateTime getDateTransaction() {
		return dateTransaction;
	}

	public BigDecimal getValueTransfer() {
		return valueTransfer;
	}
	
}
