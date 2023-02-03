package com.gaaji.interest.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum InterestErrorCode implements ErrorCode {

	NO_SEARCH(HttpStatus.BAD_REQUEST, "i-0001","차단 해제 대상자를 찾지 못했습니다."),

    ;
	
	private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    public String getErrorName() {
        return this.name();
    }
}
