package com.gaaji.interest.applicationservice;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaaji.interest.adaptor.KafkaProducer;
import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.exception.NoSearchException;
import com.gaaji.interest.repository.InterestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class InterestDeleteService {
	
	private final InterestRepository interestRepository;
	private final KafkaProducer kafkaProducer;
	

	public void deleteInterest(String userId, String postId) {
		Interest interest =  this.interestRepository.findByUserIdAndPostId(UserId.of(userId),PostId.of(postId)).orElseThrow(() -> new NoSearchException());
		this.interestRepository.delete(interest);
		this.kafkaProducer.sendDecreaseInterestCount(postId);
	}


}
