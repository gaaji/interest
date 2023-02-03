package com.gaaji.interest.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class InterestRepositoryImpl implements InterestRepository {

	private final JpaInterestRepository jpaInterestRepository ;

	@Override
	public Optional<Interest> findByUserIdAndPostId(UserId userId, PostId postId) {
		return this.jpaInterestRepository.findByUserIdAndPostId(userId,  postId);
	}

	@Override
	public void delete(Interest interest) {
		this.jpaInterestRepository.delete(interest);
	}
}
