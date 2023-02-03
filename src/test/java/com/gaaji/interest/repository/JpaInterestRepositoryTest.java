package com.gaaji.interest.repository;

import com.gaaji.interest.domain.Interest;
import com.gaaji.interest.domain.InterestId;
import com.gaaji.interest.domain.PostId;
import com.gaaji.interest.domain.PostType;
import com.gaaji.interest.domain.UserId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class JpaInterestRepositoryTest {
    
    @Autowired
    JpaInterestRepository jpaInterestRepository;
    
    
    @Test
    void 저장_후_아이디로_찾기 () throws Exception{
        //given
        String foo = "foo";
        String bar = "bar";
        String foobar = "foobar";
        PostType useditem = PostType.USEDITEM;

        //when
        Interest interest = Interest.of(InterestId.of(foo), UserId.of(bar), PostId.of(foobar)
                , useditem);
        jpaInterestRepository.save(interest);
        //when
        Interest finded = jpaInterestRepository.findByPostId(PostId.of(foobar))
                .orElseThrow();
        //then
        Assertions.assertThat(interest).isEqualTo(finded);
        
    
    }

}