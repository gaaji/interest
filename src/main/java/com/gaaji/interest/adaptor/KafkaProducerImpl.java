package com.gaaji.interest.adaptor;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaProducerImpl implements KafkaProducer{
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendIncreaseInterestCount(String postId)  {
        this.kafkaTemplate.send("used-item-increase-interest-count", postId);
    }
    
    @Override
    public void sendDecreaseInterestCount(String postId)  {
        this.kafkaTemplate.send("used-item-decrease-interest-count", postId);
    }
}
