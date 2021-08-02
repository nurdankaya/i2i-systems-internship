package com.example.calculatorsoapweb.service;

import com.example.calculatorsoapweb.model.CalculateModel;
import com.example.calculatorsoapweb.soap.Calculator;
import com.example.calculatorsoapweb.soap.CalculatorSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Service
public class CalculateService {



    String endpoint = "http://www.dneonline.com/calculator.asmx";

    URL url = URI.create(endpoint).toURL();

    Calculator service = new Calculator(url);

    CalculatorSoap port = service.getPort(CalculatorSoap.class);

    public CalculateService() throws MalformedURLException {
    }


    public int add(CalculateModel calculateModel){
        return port.add(calculateModel.getFirstNumber(),  calculateModel.getSecondNumber()) ;
    }

    public int subtract(CalculateModel calculateModel){
        return port.subtract(calculateModel.getFirstNumber(),  calculateModel.getSecondNumber()) ;
    }

    public int multiply(CalculateModel calculateModel){
        return port.multiply(calculateModel.getFirstNumber(),  calculateModel.getSecondNumber()) ;
    }

    public double divide(CalculateModel calculateModel){
        return port.divide(calculateModel.getFirstNumber(),  calculateModel.getSecondNumber()) ;
    }
}
