package com.example.kafkademo;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    PrimeAndFibonacci primeAndFibonacci;
    //private  final KafkaTemplate<String ,String> kafkaTemplate;
    @KafkaListener(topics = "testTopic",groupId = "groupIdName")
    public void getMessage(Data message) throws ClassNotFoundException {
        primeAndFibonacci.primeAndFibonacci(message);
    }

}