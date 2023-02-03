package com.gaaji.interest.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.CreatedDate;

@AccessType(Type.FIELD)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Interest {


    @EmbeddedId
    private InterestId interestId;

    @Embedded
    private UserId userId;
    @Embedded
    private PostId postId;
    @Enumerated(EnumType.STRING)
    private PostType postType;
    private LocalDateTime createdAt;

    public static Interest of(InterestId interestId,UserId userId, PostId postId,PostType postType ){
        return new Interest(interestId, userId,  postId, postType, LocalDateTime.now());
    }

    public InterestId getInterestId(){
        return this.interestId;
    }
    public String getUserId(){
        return userId.getId();
    }
    public String getPostId(){
        return postId.getId();
    }

    public PostType getPostType(){
        return postType;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Interest interest = (Interest) o;
        return Objects.equals(interestId, interest.interestId) && Objects.equals(
                userId, interest.userId) && Objects.equals(postId, interest.postId)
                && postType == interest.postType && Objects.equals(createdAt,
                interest.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interestId, userId, postId, postType, createdAt);
    }
}
