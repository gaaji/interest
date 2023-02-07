package com.gaaji.interest.exception;

import static com.gaaji.interest.exception.InterestErrorCode.INPUT_BLANK_DATA_ON_USER_ID;

public class InputBlankDataOnUserIdException extends AbstractApiException{

    public InputBlankDataOnUserIdException() {
        super(INPUT_BLANK_DATA_ON_USER_ID);
    }
}
