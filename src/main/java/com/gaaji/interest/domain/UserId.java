package com.gaaji.interest.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

@AccessType(Type.FIELD)
@AllArgsConstructor
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Embeddable
public class UserId {

    @Column(name = "user_id")
    private String id;

    public static UserId of(String userId) {
        return new UserId(userId);
    }

    public String getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserId userId1 = (UserId) o;
        return Objects.equals(id, userId1.id);
    }
}
