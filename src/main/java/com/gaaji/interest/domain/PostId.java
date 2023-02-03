package com.gaaji.interest.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


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
        return new PostId(postId);
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
