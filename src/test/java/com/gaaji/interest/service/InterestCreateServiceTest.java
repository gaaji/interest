package com.gaaji.interest.service;

import static org.assertj.core.api.Assertions.*;

import com.gaaji.interest.adaptor.KafkaProducer;
import com.gaaji.interest.adaptor.UsedItemServiceClient;
import com.gaaji.interest.applicationservice.InterestCreateService;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.PostType;
import com.gaaji.interest.exception.InputInvalidPostIdException;
import com.gaaji.interest.impl.FakeInterestRepository;
import com.gaaji.interest.impl.StubKafkaProducer;
import com.gaaji.interest.impl.StubUsedItemServiceClientReturnFalse;
import com.gaaji.interest.impl.StubUsedItemServiceClientReturnTrue;
import com.gaaji.interest.repository.InterestRepository;
import org.junit.jupiter.api.Test;

class InterestCreateServiceTest {


    @Test
    void 정상_생성완료 () throws Exception{
        //given

        UsedItemServiceClient usedItemServiceClient = new StubUsedItemServiceClientReturnTrue();
        KafkaProducer kafkaProducer = new StubKafkaProducer();
        InterestRepository interestRepository = new FakeInterestRepository();
        InterestCreateService interestCreateService = new InterestCreateService(interestRepository, usedItemServiceClient, kafkaProducer);
        //when

        interestCreateService.createInterest("foo", PostType.USEDITEM,"bar");
        Interest interest = interestRepository.findByPostId(PostId.of("foo"))
                .orElseThrow();
        //then
        assertThat(interest).isNotNull();
        assertThat(interest.getPostId()).isEqualTo("foo");
        assertThat(interest.getPostType()).isEqualTo(PostType.USEDITEM);
    }

    @Test
    void 예외_Throw_Input_Invalid_Post_Id () throws Exception{
        //given
        UsedItemServiceClient usedItemServiceClient = new StubUsedItemServiceClientReturnFalse();
        KafkaProducer kafkaProducer = new StubKafkaProducer();
        InterestRepository interestRepository = new FakeInterestRepository();
        InterestCreateService interestCreateService = new InterestCreateService(interestRepository, usedItemServiceClient, kafkaProducer);
        //when

        assertThatThrownBy(() -> interestCreateService.createInterest("foo", PostType.USEDITEM,"bar"))
                .isInstanceOf(InputInvalidPostIdException.class);

    }

}
