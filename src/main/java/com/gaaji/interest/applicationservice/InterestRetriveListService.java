package com.gaaji.interest.applicationservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.repository.InterestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class InterestRetriveListService {

	private final InterestRepository interestRepository;
	
	public List<Interest> retriveInterestList(String userId, int pageNum) {
		
		PageRequest pageRequest = PageRequest.of(pageNum, 10, Sort.by("interest.createdAt").descending());
		return this.interestRepository.findByUserId(UserId.of(userId), pageRequest);
		
	}

}
