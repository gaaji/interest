package com.gaaji.interest.impl;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.InterestId;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.PostType;
import com.gaaji.interest.domain.UserId;
import com.gaaji.interest.repository.InterestRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;

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

	@Override
	public List<Interest> findByUserId(UserId userId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public boolean isExistInterest(PostId postId, UserId userId, PostType postType) {
        return storage.values().stream()
                .filter(i -> PostId.of(i.getPostId()).equals(postId))
                .filter(i -> UserId.of(i.getUserId()).equals(userId))
                .anyMatch(i -> i.getPostType().equals(postType));
    }
}
