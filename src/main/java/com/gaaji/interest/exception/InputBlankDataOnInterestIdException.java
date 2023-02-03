package com.gaaji.interest.exception;

import static com.gaaji.interest.exception.InterestErrorCode.INPUT_BLANK_DATA_ON_INTEREST_ID;

public class InputBlankDataOnInterestIdException extends AbstractApiException{

    public InputBlankDataOnInterestIdException() {
        super(INPUT_BLANK_DATA_ON_INTEREST_ID);
    }
}
