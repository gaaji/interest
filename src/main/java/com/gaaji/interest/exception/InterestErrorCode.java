package com.gaaji.interest.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum InterestErrorCode implements ErrorCode {

    INPUT_BLANK_DATA_ON_INTEREST_ID(HttpStatus.INTERNAL_SERVER_ERROR, "i-0001",
            "interestId를 생성할 때 Blank데이터(null or empty)를 넣었습니다."),
    INPUT_BLANK_DATA_ON_USER_ID(HttpStatus.INTERNAL_SERVER_ERROR, "i-0002",
            "userId를 생성할 때 Blank데이터(null or empty)를 넣었습니다."),
    INPUT_BLANK_DATA_ON_POST_ID(HttpStatus.INTERNAL_SERVER_ERROR, "i-0003",
            "postId를 생성할 때 Blank데이터(null or empty)를 넣었습니다."),
    INPUT_NULL_DATA_ON_POST_TYPE(HttpStatus.INTERNAL_SERVER_ERROR, "i-0004",
            "PostType 인자에 null이 들어왔습니다."),
    INPUT_INVALID_POST_ID(HttpStatus.BAD_REQUEST, "i-0005",
            "사용할 수 없는 PostId를 전달했습니다."),
	NO_SEARCH(HttpStatus.BAD_REQUEST, "i-0006","차단 해제 대상자를 찾지 못했습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    public String getErrorName() {
        return this.name();
    }
}
