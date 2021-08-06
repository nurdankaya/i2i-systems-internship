package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PrimeAndFibonacci {

    public static boolean isPrime(int x) {

        if(x <= 1) {
            return false;
        }else if(x == 2) {
            return true;
        }
        for(int i = 2; i < x; i++) {
            if(x % i == 0)
                return false;
        }
        return true;
    }

    public static boolean existFibonacci(int x) {

        ArrayList<Integer> f = new ArrayList<>();
        f.add(1);
        f.add(1);

        int i = 1;
        while(f.get(f.size()-1) <= x) {
            f.add(f.get(i)+f.get(i-1));
            i++;
            if(f.contains(x))
                return true;
        }
        return false;
    }

    public void primeAndFibonacci(Data data) {

        System.out.println(data.getOperationName().equals("primeFibonacci") );
            if (data.getOperationName().equals("primeFibonacci") ){
                if(isPrime(data.getNumberToCheck()) && existFibonacci(data.getNumberToCheck())) {
                    System.out.println(data.getNumberToCheck() + " is prime and exist fibonacci");
                }
            }
    }

}
