package com.alami.consumer.repository.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.alami.consumer.model.transaction.TransactionMemberKoperasi;
public class TransactionMemberKoperasiRepositoryImpl implements TransactionMemberKoperasiRepositoryCustom {

	@Autowired
    private MongoTemplate mongoTemplate;
	
	public List<TransactionMemberKoperasi> getListTransactionByMember(String memberId){
		
		Query query = new Query();
        query.addCriteria(Criteria.where("memberId").is(memberId));

		return mongoTemplate.find(query, TransactionMemberKoperasi.class);
	}
	
}
