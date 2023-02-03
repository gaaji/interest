package com.gaaji.interest.exception;

import static com.gaaji.interest.exception.InterestErrorCode.NO_SEARCH;;

public class NoSearchException extends AbstractApiException{

	public NoSearchException() {
		super(NO_SEARCH);
	}

}
