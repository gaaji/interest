package com.gaaji.interest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.InterestId;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;
import java.util.Optional;

public interface JpaInterestRepository extends JpaRepository<Interest, InterestId> {

	Optional<Interest> findByUserIdAndPostId(UserId userId, PostId postId);

	List<Interest> findByUserId(@Param("userId")UserId userId, PageRequest pageRequest);


    Optional<Interest> findByPostId(PostId postId);
    

}
