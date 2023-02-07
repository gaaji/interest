package com.gaaji.interest.applicationservice;

import com.gaaji.interest.adaptor.KafkaProducer;
import com.gaaji.interest.adaptor.UsedItemServiceClient;
import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.InterestId;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.PostType;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.exception.InputInvalidPostIdException;
import com.gaaji.interest.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class InterestCreateService {

    private final InterestRepository interestRepository;
    private final UsedItemServiceClient usedItemServiceClient;
    private final KafkaProducer kafkaProducer;

    public void createInterest(String postId, PostType postType, String authId) {

        validatePostId(postId);
        createEntityAndSave(postId, postType, authId);
        sendCommandToUsedItemService();

    }

    private void sendCommandToUsedItemService() {
        kafkaProducer.sendIncreaseInterestCount();
    }

    private void createEntityAndSave(String postId, PostType postType, String authId) {
        interestRepository.save(Interest.of(InterestId.of(interestRepository.nextId()), UserId.of(
                        authId),
                PostId.of(postId), postType));
    }

    private void validatePostId(String postId) {
        if(!usedItemServiceClient.isExistPostId(postId))
            throw new InputInvalidPostIdException();
    }
}
