package com.gaaji.interest.adaptor;

public interface KafkaProducer {

    void sendIncreaseInterestCount(String postId);

	void sendDecreaseInterestCount(String postId);
}
