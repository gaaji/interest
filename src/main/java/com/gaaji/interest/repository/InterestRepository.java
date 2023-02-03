package com.gaaji.interest.repository;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.PostId;
import java.util.Optional;
import java.util.UUID;

public interface InterestRepository {

    void save(Interest interest);

    Optional<Interest> findByPostId(PostId postId);

    default String nextId(){
        return UUID.randomUUID().toString();
    }

}
