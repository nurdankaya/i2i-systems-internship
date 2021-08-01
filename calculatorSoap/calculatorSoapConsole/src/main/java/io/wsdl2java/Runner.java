package io.wsdl2java;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;


public class Runner {
	
	public static void main(String[] args) throws MalformedURLException {
		String endpoint= "http://www.dneonline.com/calculator.asmx" ;

		URL url = URI.create(endpoint).toURL();
		
		Calculator  service = new Calculator(url);
	
		CalculatorSoap port = service.getPort(CalculatorSoap.class);
		
		System.out.println("CHOOSE THE OPERATION");
		System.out.println("1-add ");
		System.out.println("2-substruct ");
		System.out.println("3-multiply ");
		System.out.println("4-divide ");
		
		Scanner temp = new Scanner(System.in); 
		int operation= temp.nextInt();  
		
		System.out.print("Enter first number: "); 
		int firstNumber= temp.nextInt();  
		System.out.print("Enter second number: ");  
		int secondNumber= temp.nextInt();  
		if(operation == 1)
		{
			System.out.println(port.add(firstNumber, secondNumber));
		}else if(operation == 2)
		{
			System.out.println(port.subtract(firstNumber, secondNumber));
		}else if(operation == 3)
		{
			System.out.println(port.multiply(firstNumber, secondNumber));
		}else if(operation == 4)
		{
			System.out.println(port.divide(firstNumber, secondNumber));
		}else {
			System.out.println("Try Again ..");
		}
	
	}
}

