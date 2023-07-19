package br.com.challenge.picpay;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.challenge.picpay.account.Account;
import br.com.challenge.picpay.account.AccountRepository;
import br.com.challenge.picpay.domain.user.User;
import br.com.challenge.picpay.domain.user.UserComum;
import br.com.challenge.picpay.domain.user.UserLojista;
import br.com.challenge.picpay.domain.user.UserRepository;

@SpringBootApplication
public class PicpayApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PicpayApplication.class, args);
	}
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
		User comum1 = new UserComum(1L, "comum1", "50229624898", "teteste1@teste.com", "12345567");
		User comum2 = new UserComum(2L, "comum2", "57975303097", "teste2@teste.com", "12345567");
		User lojista = new UserLojista(3L, "lojista", "20689933096", "teste@teste.com", "12345567", "85580460000199");
		
		repository.saveAll(Arrays.asList(comum1, comum2, lojista));

		Account account1 = new Account(1L, comum1, BigDecimal.valueOf(150l));
		Account account2 = new Account(2L, comum2, BigDecimal.valueOf(120l));
		Account account3 = new Account(3L, lojista, BigDecimal.valueOf(120l));
		
		accountRepository.saveAll(Arrays.asList(account1, account2, account3));
	}

}
