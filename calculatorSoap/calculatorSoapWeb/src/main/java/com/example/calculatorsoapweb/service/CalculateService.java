package com.example.calculatorsoapweb.service;

import com.example.calculatorsoapweb.controller.CalculatorController;
import com.example.calculatorsoapweb.model.CalculateModel;
import com.example.calculatorsoapweb.soap.Calculator;
import com.example.calculatorsoapweb.soap.CalculatorSoap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Service
public class CalculateService {

    private static final Logger logger =  LogManager.getLogger(CalculatorController.class);

    String endpoint = "http://www.dneonline.com/calculator.asmx";

    URL url = URI.create(endpoint).toURL();

    Calculator service = new Calculator(url);

    CalculatorSoap port = service.getPort(CalculatorSoap.class);

    public CalculateService() throws MalformedURLException {
    }


    public int add(CalculateModel calculateModel){
        logger.info("CalculateService added " +calculateModel.getFirstNumber()+
                "and" + calculateModel.getSecondNumber()+
                "!");
        return port.add(calculateModel.getFirstNumber(),  calculateModel.getSecondNumber()) ;
    }

    public int subtract(CalculateModel calculateModel){
        logger.info("CalculateService subtracted " +calculateModel.getFirstNumber()+
                "and" + calculateModel.getSecondNumber()+
                "!");
        return port.subtract(calculateModel.getFirstNumber(),  calculateModel.getSecondNumber()) ;
    }

    public int multiply(CalculateModel calculateModel){
        logger.info("CalculateService multiplied " +calculateModel.getFirstNumber()+
                "and" + calculateModel.getSecondNumber()+
                "!");
        return port.multiply(calculateModel.getFirstNumber(),  calculateModel.getSecondNumber()) ;
    }

    public double divide(CalculateModel calculateModel){
        logger.info("CalculateService divided " +calculateModel.getFirstNumber()+
                "and" + calculateModel.getSecondNumber()+
                "!");
        return port.divide(calculateModel.getFirstNumber(),  calculateModel.getSecondNumber()) ;
    }
}
