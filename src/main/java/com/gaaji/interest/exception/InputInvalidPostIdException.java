package com.gaaji.interest.exception;

import static com.gaaji.interest.exception.InterestErrorCode.INPUT_INVALID_POST_ID;

public class InputInvalidPostIdException extends AbstractApiException{

    public InputInvalidPostIdException() {
        super(INPUT_INVALID_POST_ID);
    }
}
