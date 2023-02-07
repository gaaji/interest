package com.gaaji.interest.impl;

import com.gaaji.interest.adaptor.KafkaProducer;

public class StubKafkaProducer implements KafkaProducer {

    @Override
    public void sendIncreaseInterestCount(String postId) {

    }

	@Override
	public void sendDecreaseInterestCount(String postId) {
		// TODO Auto-generated method stub
		
	}
}
