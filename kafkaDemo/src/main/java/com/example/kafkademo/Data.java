package com.example.kafkademo;

import org.springframework.stereotype.Component;

@Component
public class Data {
    int numberToCheck;
    String operationName;

    public Data(){}
    public Data(int numberToCheck, String operationName) {
        this.numberToCheck = numberToCheck;
        this.operationName = operationName;
    }

    public void setNumberToCheck(int numberToCheck) {
        this.numberToCheck = numberToCheck;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public int getNumberToCheck() {
        return numberToCheck;
    }

    public String getOperationName() {
        return operationName;
    }
}
