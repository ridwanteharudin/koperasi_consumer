package com.alami.consumer.dto.transaction;

import java.util.Date;

import com.alami.consumer.serializer.JsonDateDeserializer;
import com.alami.consumer.serializer.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionMemberKoperasiResponseDto {

	private String transactionMemberKoperasiId;
	
	private String totalTransactionMemberKoperasi;
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date transactionDateMemberKoperasi;
	private String transactionTypeMemberKoperasi;
	
	private String memberId;
	private String memberName;
}