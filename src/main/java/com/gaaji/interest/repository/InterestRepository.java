package com.gaaji.interest.repository;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.UserId;
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

}
