package com.gaaji.interest.repository;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class InterestRepositoryImpl implements InterestRepository{

    private final JpaInterestRepository jpaInterestRepository;

    @Override
    public void save(Interest interest) {
        jpaInterestRepository.save(interest);
    }

    @Override
    public Optional<Interest> findByPostId(PostId postId) {
        return jpaInterestRepository.findByPostId(postId);
    }

    @Override
    public Optional<Interest> findByUserIdAndPostId(UserId userId, PostId postId) {
        return this.jpaInterestRepository.findByUserIdAndPostId(userId,  postId);
    }

    @Override
    public void delete(Interest interest) {
        this.jpaInterestRepository.delete(interest);
    }
}
