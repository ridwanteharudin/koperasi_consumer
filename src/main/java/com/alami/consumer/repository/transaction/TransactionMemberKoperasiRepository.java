package com.alami.consumer.repository.transaction;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alami.consumer.model.transaction.TransactionMemberKoperasi;

public interface TransactionMemberKoperasiRepository extends MongoRepository<TransactionMemberKoperasi, String>{

}
