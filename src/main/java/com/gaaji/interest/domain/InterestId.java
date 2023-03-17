package com.gaaji.interest.domain;

import com.gaaji.interest.exception.InputBlankDataOnInterestIdException;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.util.StringUtils;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AccessType(Type.FIELD)
@Embeddable
public class InterestId implements Serializable {

    @Column(name = "interest_id")
    private String id;

    public static InterestId of(String id){
        validateBlankData(id);
        return new InterestId(id);
    }

    private static void validateBlankData(String id) {
        if(!StringUtils.hasText(id))
            throw new InputBlankDataOnInterestIdException();
    }

    public String getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InterestId that = (InterestId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
