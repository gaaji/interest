package com.gaaji.interest.applicationservice;

import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.PostType;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class InterestExistRetrieveService {

    private final InterestRepository interestRepository;

    public boolean isExistInterest(String postId, String userId, PostType postType) {
        return interestRepository.isExistInterest(PostId.of(postId), UserId.of(userId), postType);
    }
}
