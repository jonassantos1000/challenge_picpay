package br.com.challenge.picpay.domain.transaction;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransactionRequest {

	@NotBlank
	private Long sourceAccountId;
	
	@NotBlank
	private Long destinationAccountId;
	
	@NotNull
	private BigDecimal valueTransfer;
		
	public TransactionRequest() {
		
	}

	public TransactionRequest(@NotBlank Long sourceAccountId, @NotBlank Long destinationAccountId,
			@NotNull BigDecimal valueTransfer) {
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
		this.valueTransfer = valueTransfer;
	}

	public Long getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(Long sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public Long getDestinationAccountId() {
		return destinationAccountId;
	}

	public void setDestinationAccountId(Long destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}

	public BigDecimal getValueTransfer() {
		return valueTransfer;
	}

	public void setValueTransfer(BigDecimal valueTransfer) {
		this.valueTransfer = valueTransfer;
	}
	
}
