package com.example.kafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static  final  String TOPIC="testTopic";

    @Autowired
    private KafkaTemplate<String, Data> kafkaTemplate;
//private KafkaTemplate<String, String> kafkaTemplate;


    public  void writeMessage(Data msg){
        this.kafkaTemplate.send(TOPIC, msg);

    }
    @Bean
    public NewTopic createTopic(){

        return new NewTopic(TOPIC,3,(short)1);
    }

}