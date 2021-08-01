package com.alami.consumer.model.transaction;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "TRANSACTION_MEMBER_KOPERASI")
@JsonView(DataTablesOutput.View.class)
public class TransactionMemberKoperasi {
	@Id
	private String transactionMemberKoperasiId;
	
	private Double totalTransactionMemberKoperasi;
	@Temporal(TemporalType.DATE)
	private Date transactionDateMemberKoperasi;
	private String transactionTypeMemberKoperasi;
	
	private String memberId;
	private String memberName;
}
