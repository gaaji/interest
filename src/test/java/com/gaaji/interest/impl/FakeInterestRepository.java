package com.gaaji.interest.impl;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.InterestId;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.repository.InterestRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakeInterestRepository implements InterestRepository {

    private Map<InterestId, Interest> storage = new HashMap<>();

    @Override
    public void save(Interest interest) {

        storage.put(InterestId.of(interest.getInterestIdToString()), interest);

    }

    @Override
    public Optional<Interest> findByPostId(PostId postId) {

        return storage.values().stream()
                .filter(i -> PostId.of(i.getPostId()).equals(postId))
                .findFirst();
    }

    @Override
    public Optional<Interest> findByUserIdAndPostId(UserId userId, PostId postId) {
        return Optional.empty();
    }

    @Override
    public void delete(Interest interest) {

    }
}
