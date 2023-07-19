package br.com.challenge.picpay.domain.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMUM")
public class UserComum extends User{

	public UserComum() {

	}

	public UserComum(Long id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
	}
	
}
