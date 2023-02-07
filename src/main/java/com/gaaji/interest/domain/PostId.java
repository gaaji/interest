package com.gaaji.interest.domain;

import com.gaaji.interest.exception.InputBlankDataOnPostIdException;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;


@AllArgsConstructor
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Embeddable
public class PostId implements Serializable {

    @Column(name = "post_id")
    private String id;

    public String getId(){
        return id;
    }

    public static PostId of(String postId) {
        validateBlankData(postId);
        return new PostId(postId);
    }

    private static void validateBlankData(String postId) {
        if(!StringUtils.hasText(postId))
            throw new InputBlankDataOnPostIdException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostId postId1 = (PostId) o;
        return Objects.equals(id, postId1.id);
    }
}
