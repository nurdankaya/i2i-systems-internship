package com.example.kafkademo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    Data data;

    @Autowired
    KafkaProducer kafkaProducer;
    @Autowired
    KafkaConsumer kafkaConsumer;

    @Autowired
    private final KafkaProducer producer;

    private  KafkaController(KafkaProducer producer){
        this.producer  =producer;
    }



    @PostMapping("/publish")
    public void  writeMessageToTopic(@RequestBody Data data) throws ClassNotFoundException {
        Data takenData = null;
        this.data = data;
        kafkaProducer.createTopic();
        kafkaProducer.writeMessage(data);
    }



}