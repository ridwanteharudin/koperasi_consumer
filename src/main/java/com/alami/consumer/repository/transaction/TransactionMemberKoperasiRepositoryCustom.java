package com.alami.consumer.repository.transaction;

import java.util.List;

import com.alami.consumer.model.transaction.TransactionMemberKoperasi;

public interface TransactionMemberKoperasiRepositoryCustom {
	
	public List<TransactionMemberKoperasi> getListTransactionByMember(String memberId);
	
}
