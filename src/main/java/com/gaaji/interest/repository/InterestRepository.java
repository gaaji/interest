package com.gaaji.interest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;

public interface InterestRepository {

	Optional<Interest> findByUserIdAndPostId(UserId userId, PostId postId);

	void delete(Interest interest);

	List<Interest> findByUserId(UserId userId, PageRequest pageRequest);

}
