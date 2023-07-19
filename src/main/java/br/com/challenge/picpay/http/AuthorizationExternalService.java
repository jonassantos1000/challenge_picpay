package br.com.challenge.picpay.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.challenge.picpay.domain.transaction.TransactionAuthorization;

@Service
public class AuthorizationExternalService {

	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionAuthorization checkAuthorization() {
		ResponseEntity<TransactionAuthorization> response = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", TransactionAuthorization.class);
		return response.getBody();
	}
}
