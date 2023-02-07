package com.gaaji.interest.repository;

import org.springframework.data.domain.PageRequest;
import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InterestRepository {

    void save(Interest interest);

    Optional<Interest> findByPostId(PostId postId);

    Optional<Interest> findByUserIdAndPostId(UserId userId, PostId postId);

    void delete(Interest interest);

    default String nextId(){
        return UUID.randomUUID().toString();
    }

	List<Interest> findByUserId(UserId userId, PageRequest pageRequest);

}
