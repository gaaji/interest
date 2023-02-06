package com.gaaji.interest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class BlockDeleteJpaTest {

	@Autowired
    JpaInterestRepository jpaInterestRepository;
	
    
    @Test
    void 삭제서비스 () throws Exception{
        //given

    	Interest interest = Interest.of(InterestId.of("123"), UserId.of("user"), PostId.of("post"), PostType.USEDITEM);
    	this.jpaInterestRepository.save(interest);
    	interest = this.jpaInterestRepository.findByUserIdAndPostId(UserId.of("user"), PostId.of("post")).orElseThrow(() -> new NoSearchException());;
    	this.jpaInterestRepository.delete(interest);
    	//System.out.println(interest.getPostId());
    }
    
}
