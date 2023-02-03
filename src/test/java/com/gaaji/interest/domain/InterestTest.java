package com.gaaji.interest.domain;

import static org.assertj.core.api.Assertions.*;

import com.gaaji.interest.exception.InputBlankDataOnInterestIdException;
import com.gaaji.interest.exception.InputBlankDataOnPostIdException;
import com.gaaji.interest.exception.InputBlankDataOnUserIdException;
import com.gaaji.interest.exception.InputNullDataOnPostTypeException;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InterestTest {


    @Test
    void 생성_테스트_모든_값이_Null이_아니고_초기_값과_같아야_한다 () throws Exception{
        //given
        String foo = "foo";
        String bar = "bar";
        String foobar = "foobar";
        PostType useditem = PostType.USEDITEM;

        //when
        Interest interest = Interest.of(InterestId.of(foo), UserId.of(bar), PostId.of(foobar)
                , useditem);
        //then
        assertThat(interest).isNotNull();
        assertThat(interest.getInterestId()).isEqualTo(foo);
        assertThat(interest.getPostId()).isEqualTo(foobar);
        assertThat(interest.getUserId()).isEqualTo(bar);
        assertThat(interest.getPostType()).isEqualTo(useditem);

    }
    @Test
    void 생성_테스트_생성_시간이_더_최근이어야_한다 () throws Exception{
        //given

        LocalDateTime now = LocalDateTime.now();

        //when
        Interest interest = Interest.of(InterestId.of("foo"), UserId.of("bar"), PostId.of("foobar")
                , PostType.USEDITEM);
        //then
        assertThat(interest.getCreatedAt()).isAfter(now);
    }

    @Test
    void 예외_Throw_InputBlankDataOnInterestId () throws Exception{
        //given
        String foo = "";
        String bar = "bar";
        String foobar = "foobar";
        PostType useditem = PostType.USEDITEM;

        //when //then
        assertThatThrownBy(() -> Interest.of(InterestId.of(foo), UserId.of(bar), PostId.of(foobar),useditem))
                .isInstanceOf(InputBlankDataOnInterestIdException.class);
    }

    @Test
    void 예외_Throw_InputBlankDataOnUserId () throws Exception{
        //given
        String foo = "foo";
        String bar = "";
        String foobar = "foobar";
        PostType useditem = PostType.USEDITEM;

        //when //then
        assertThatThrownBy(() -> Interest.of(InterestId.of(foo), UserId.of(bar), PostId.of(foobar),useditem))
                .isInstanceOf(InputBlankDataOnUserIdException.class);
    }
    @Test
    void 예외_Throw_InputBlankDataOnPostId () throws Exception{
        //given
        String foo = "foo";
        String bar = "bar";
        String foobar = "";
        PostType useditem = PostType.USEDITEM;

        //when //then
        assertThatThrownBy(() -> Interest.of(InterestId.of(foo), UserId.of(bar), PostId.of(foobar),useditem))
                .isInstanceOf(InputBlankDataOnPostIdException.class);
    }
    @Test
    void 예외_Throw_InputNullDataOnPostType () throws Exception{
        //given
        String foo = "foo";
        String bar = "bar";
        String foobar = "foobar";
        PostType useditem = null;

        //when //then
        assertThatThrownBy(() -> Interest.of(InterestId.of(foo), UserId.of(bar), PostId.of(foobar),useditem))
                .isInstanceOf(InputNullDataOnPostTypeException.class);
    }

}
