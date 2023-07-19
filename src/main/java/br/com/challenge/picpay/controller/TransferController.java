package br.com.challenge.picpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.picpay.domain.transaction.Status;
import br.com.challenge.picpay.domain.transaction.Transaction;
import br.com.challenge.picpay.domain.transaction.TransactionRequest;
import br.com.challenge.picpay.domain.transaction.TransactionResponse;
import br.com.challenge.picpay.domain.transaction.TransactionService;

@RestController
@RequestMapping("/transfer")
public class TransferController {

	@Autowired
	TransactionService service;

	@PostMapping
	public ResponseEntity<TransactionResponse> requestTransfer(@RequestBody TransactionRequest data) {
		Transaction transaction = service.requestTransfer(data);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new TransactionResponse(Status.EFETUADO, "Transferencia efetuada com sucesso.", transaction.getValueTransfer()));
	}

}
