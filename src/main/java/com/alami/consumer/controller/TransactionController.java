package com.alami.consumer.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alami.consumer.dto.controller.response.Response;
import com.alami.consumer.model.transaction.TransactionMemberKoperasi;
import com.alami.consumer.repository.transaction.TransactionMemberKoperasiRepository;
import com.alami.consumer.repository.transaction.TransactionMemberKoperasiRepositoryCustom;
import com.alami.consumer.util.DateUtil;
import com.alami.consumer.util.UniqueID;

@RestController
@RequestMapping("/")
public class TransactionController {
	@Autowired
	private TransactionMemberKoperasiRepository transactionMemberKoperasiRepository;
	
	@Autowired
	private TransactionMemberKoperasiRepositoryCustom transactionMemberKoperasiRepositoryCustom;

	@KafkaListener(topics = "test", groupId = "test-consumer-group")
	void commonListenerForMultipleTopics(String message) {

		try {
			TransactionMemberKoperasi data = new TransactionMemberKoperasi();

			// convert to object
			JSONObject json = new JSONObject(message);

			data.setTransactionMemberKoperasiId(UniqueID.getUUID());
			data.setMemberId(json.getString("memberId"));
			data.setMemberName(json.getString("memberName"));
			data.setTotalTransactionMemberKoperasi(json.getDouble("totalTransactionMemberKoperasi"));
			data.setTransactionDateMemberKoperasi(
					DateUtil.convertDate(json.getString("transactionDateMemberKoperasi")));
			data.setTransactionTypeMemberKoperasi(json.getString("transactionTypeMemberKoperasi"));

			transactionMemberKoperasiRepository.save(data);

			System.out.print("Success insert data");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public Response<List<TransactionMemberKoperasi>> listbymember(@RequestParam(value="memberId", required = true)String memberId) {
		List<TransactionMemberKoperasi> listTransaction = transactionMemberKoperasiRepositoryCustom.getListTransactionByMember(memberId);
		
		Response<List<TransactionMemberKoperasi>> response = new Response<List<TransactionMemberKoperasi>>(listTransaction);
		return response;
	}
}
