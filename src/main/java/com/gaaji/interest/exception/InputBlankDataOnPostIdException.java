package com.gaaji.interest.exception;

import static com.gaaji.interest.exception.InterestErrorCode.INPUT_BLANK_DATA_ON_POST_ID;

public class InputBlankDataOnPostIdException extends AbstractApiException{

    public InputBlankDataOnPostIdException() {
        super(INPUT_BLANK_DATA_ON_POST_ID);
    }
}
