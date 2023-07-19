package br.com.challenge.picpay.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.challenge.picpay.domain.transaction.Transaction;
import br.com.challenge.picpay.domain.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	private BigDecimal balance;
	
	@OneToMany(mappedBy = "sourceAccount", cascade = CascadeType.ALL)
	private List<Transaction> transactionsAsSource;
	
	@OneToMany(mappedBy = "destinationAccount", cascade = CascadeType.ALL)
	private List<Transaction> transactionsAsDestination;

	public Account() {
		
	}
	
	public Account(Long id, User user, BigDecimal balance) {
		this.id = id;
		this.user = user;
		this.balance = balance;
		this.user.setAccount(this);
		this.transactionsAsDestination = new ArrayList<>();
		this.transactionsAsSource = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactionsAsSource() {
		return transactionsAsSource;
	}

	public void setTransactionsAsSource(List<Transaction> transactionsAsSource) {
		this.transactionsAsSource = transactionsAsSource;
	}

	public List<Transaction> getTransactionsAsDestination() {
		return transactionsAsDestination;
	}

	public void setTransactionsAsDestination(List<Transaction> transactionsAsDestination) {
		this.transactionsAsDestination = transactionsAsDestination;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id) && Objects.equals(user, other.user);
	}
	
}
