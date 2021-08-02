package com.example.calculatorsoapweb.model;

import org.springframework.stereotype.Component;

@Component
public class CalculateModel {

    String operation;
    int firstNumber;
    int secondNumber;
    int result;

    public CalculateModel() {
    }

    public CalculateModel(String operation, int firstNumber, int secondNumber, int result) {
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
