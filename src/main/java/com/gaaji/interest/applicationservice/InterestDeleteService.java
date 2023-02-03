package com.gaaji.interest.applicationservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.repository.InterestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class InterestDeleteService {
	
	private final InterestRepository interestRepository;

	public void deleteInterest(String userId, String postId) {
		Interest interest =  this.interestRepository.findByUserIdAndPostId(UserId.of(userId),PostId.of(postId)).orElseThrow(() -> new RuntimeException());
		this.interestRepository.delete(interest);
	}


}
