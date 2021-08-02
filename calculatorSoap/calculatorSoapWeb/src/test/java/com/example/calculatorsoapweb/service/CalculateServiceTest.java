package com.example.calculatorsoapweb.service;

import com.example.calculatorsoapweb.model.CalculateModel;
import com.example.calculatorsoapweb.soap.Calculator;
import com.example.calculatorsoapweb.soap.CalculatorSoap;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @InjectMocks
    CalculateModel calculateModel;


    private String endpoint = "http://www.dneonline.com/calculator.asmx";
    private URL url = URI.create(endpoint).toURL();
    private Calculator service = new Calculator(url);
    @Mock
    private CalculatorSoap port = service.getPort(CalculatorSoap.class);

    CalculateServiceTest() throws MalformedURLException {
    }



    @Test
    public void addTest(){
        CalculateModel calculateModel= new CalculateModel();
        calculateModel.setOperation("add");
        calculateModel.setFirstNumber(7);
        calculateModel.setSecondNumber(5);
        calculateService.add(calculateModel);
        assertEquals(calculateModel.getFirstNumber()+calculateModel.getSecondNumber(),calculateService.add(calculateModel));
    }


    @Test
    void subtractTest() {
        CalculateModel calculateModel= new CalculateModel();
        calculateModel.setOperation("subtract");
        calculateModel.setFirstNumber(7);
        calculateModel.setSecondNumber(5);
        calculateService.add(calculateModel);
        assertEquals(calculateModel.getFirstNumber()-calculateModel.getSecondNumber(),calculateService.subtract(calculateModel));
    }

    @Test
    void multiplyTest() {
        CalculateModel calculateModel= new CalculateModel();
        calculateModel.setOperation("multiply");
        calculateModel.setFirstNumber(7);
        calculateModel.setSecondNumber(5);
        calculateService.add(calculateModel);
        assertEquals(calculateModel.getFirstNumber()*calculateModel.getSecondNumber(),calculateService.multiply(calculateModel));
    }

    @Test
    void divideTest() {
        CalculateModel calculateModel= new CalculateModel();
        calculateModel.setOperation("divide");
        calculateModel.setFirstNumber(10);
        calculateModel.setSecondNumber(5);
        calculateService.add(calculateModel);
        assertEquals(calculateModel.getFirstNumber()/calculateModel.getSecondNumber(),calculateService.divide(calculateModel));
    }
}