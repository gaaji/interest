package com.gaaji.interest.exception;

import static com.gaaji.interest.exception.InterestErrorCode.INPUT_NULL_DATA_ON_POST_TYPE;

public class InputNullDataOnPostTypeException extends AbstractApiException{

    public InputNullDataOnPostTypeException() {
        super(INPUT_NULL_DATA_ON_POST_TYPE);
    }
}
