package com.gaaji.interest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.InterestId;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;

public interface JpaInterestRepository extends JpaRepository<Interest, InterestId> {

	Optional<Interest> findByUserIdAndPostId(UserId userId, PostId postId);



}
