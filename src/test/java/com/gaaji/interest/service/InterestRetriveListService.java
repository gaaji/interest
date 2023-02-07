package com.gaaji.interest.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.InterestId;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.PostType;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.exception.NoSearchException;
import com.gaaji.interest.repository.JpaInterestRepository;

@Transactional
@SpringBootTest
public class InterestRetriveListService {

	@Autowired
    JpaInterestRepository jpaInterestRepository;

    
    @Test
    void 삭제서비스 () throws Exception{
        //given
    	int a =0;
    	
    	for(int i=1; i<12; i++) {
    		Interest interest = Interest.of(InterestId.of("a"+i), UserId.of("user"), PostId.of("post"+i), PostType.USEDITEM);
        	this.jpaInterestRepository.save(interest);
    	}
    	
    	PageRequest pageRequest = PageRequest.of(1, 10, Sort.by("createdAt").descending());
		List<Interest> interests = this.jpaInterestRepository.findByUserId(UserId.of("user"), pageRequest);
    	Interest interest = this.jpaInterestRepository.findByUserIdAndPostId(UserId.of("user"), PostId.of("post1")).orElseThrow(() -> new NoSearchException());;

    	
    	
    }
    
}
