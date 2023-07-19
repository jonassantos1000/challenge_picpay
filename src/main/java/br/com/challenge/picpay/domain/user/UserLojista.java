package br.com.challenge.picpay.domain.user;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LOJISTA")
public class UserLojista extends User{

	@CNPJ
	private String cnpj;
	
	public UserLojista() {

	}

	public UserLojista(Long id, String name, String cpf, String email, String password, String cnpj) {
		super(id, name, cpf, email, password);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
