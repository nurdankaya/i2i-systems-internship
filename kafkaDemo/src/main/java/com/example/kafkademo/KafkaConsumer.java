package com.example.kafkademo;
import org.apache.kafka.common.internals.Topic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    //private  final KafkaTemplate<String ,String> kafkaTemplate;
    @KafkaListener(topics = "testTopic",groupId = "groupIdName")
    public void getMessage(String message){
        System.out.println("message:");
        System.out.println(message);
    }


}