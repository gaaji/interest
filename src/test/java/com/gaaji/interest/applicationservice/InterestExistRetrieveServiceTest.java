package com.gaaji.interest.applicationservice;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.InterestId;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.PostType;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.impl.FakeInterestRepository;
import com.gaaji.interest.repository.InterestRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InterestExistRetrieveServiceTest {
    
    @Test
    void 리턴_TRUE () throws Exception{
        //given
        Interest interest = Interest.of(InterestId.of("aaa"), UserId.of("bbb"), PostId.of("ccc"), PostType.USEDITEM);
        InterestRepository interestRepository = new FakeInterestRepository();
        InterestExistRetrieveService interestExistRetrieveService = new InterestExistRetrieveService(interestRepository);

        interestRepository.save(interest);

        //when
        boolean existInterest = interestExistRetrieveService.isExistInterest("ccc", "bbb",
                PostType.USEDITEM);
        //then
        assertThat(existInterest).isTrue();
    }

    @Test
    void 리턴_FALSE () throws Exception{
        //given
        Interest interest = Interest.of(InterestId.of("aaa"), UserId.of("bbb"), PostId.of("asdasdasd"), PostType.USEDITEM);
        InterestRepository interestRepository = new FakeInterestRepository();
        InterestExistRetrieveService interestExistRetrieveService = new InterestExistRetrieveService(interestRepository);

        interestRepository.save(interest);

        //when
        boolean existInterest = interestExistRetrieveService.isExistInterest("ccc", "bbb",
                PostType.USEDITEM);
        //then
        assertThat(existInterest).isFalse();
    }

}