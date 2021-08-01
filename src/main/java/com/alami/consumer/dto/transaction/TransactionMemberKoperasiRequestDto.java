package com.alami.consumer.dto.transaction;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionMemberKoperasiRequestDto {
	private Double totalTransactionMemberKoperasi;
	@Temporal(TemporalType.DATE)
	private Date transactionDateMemberKoperasi;
	private String transactionTypeMemberKoperasi;
	
	private String memberId;
	private String memberName;
}
