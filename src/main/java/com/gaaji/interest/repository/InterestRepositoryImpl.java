package com.gaaji.interest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class InterestRepositoryImpl implements InterestRepository{

    private final JpaInterestRepository jpaInterestRepository;

	@Override
	public Optional<Interest> findByUserIdAndPostId(UserId userId, PostId postId) {
		return this.jpaInterestRepository.findByUserIdAndPostId(userId, postId);
	}
    @Override
    public void save(Interest interest) {
        jpaInterestRepository.save(interest);
    }

	@Override
	public void delete(Interest interest) {
		this.jpaInterestRepository.delete(interest);
	}

	@Override
	public List<Interest> findByUserId(UserId userId, PageRequest pageRequest) {
		return this.jpaInterestRepository.findByUserId(userId, pageRequest);
	}

    @Override
    public Optional<Interest> findByPostId(PostId postId) {
        return jpaInterestRepository.findByPostId(postId);
    }


}
