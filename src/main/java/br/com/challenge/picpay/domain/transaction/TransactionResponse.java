package br.com.challenge.picpay.domain.transaction;

import java.math.BigDecimal;

public class TransactionResponse {
	
	private Status status;
	private BigDecimal valueTransfer;
	private String message;
	
	public TransactionResponse() {
		
	}
	
	public TransactionResponse(Status status, String message, BigDecimal valueTransfer) {
		this.status = status;
		this.message = message;
		this.valueTransfer = valueTransfer;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BigDecimal getValueTransfer() {
		return valueTransfer;
	}

	public void setValueTransfer(BigDecimal valueTransfer) {
		this.valueTransfer = valueTransfer;
	}

}
