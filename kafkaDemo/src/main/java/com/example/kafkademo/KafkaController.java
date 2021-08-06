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
    PrimeAndFibonacci primeAndFibonacci;

    @Autowired
    private final KafkaProducer producer;

    private  KafkaController(KafkaProducer producer){
        this.producer  =producer;
    }



    @PostMapping("/publish")
    public void  writeMessageToTopic(@RequestBody Data data){
        System.out.println(data.getNumberToCheck());
        System.out.println(data.getOperationName());
        this.data = data;
        primeAndFibonacci.primeAndFibonacci(data);
    }



}