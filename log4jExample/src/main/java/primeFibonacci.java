import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

//AIM: log into files and console - compress log files depending on file size

public class primeFibonacci {
    public static boolean isPrime(int x) {

        if(x <= 1) {                           // not prime if the number is less than or equal 1
            return false;
        }else if(x == 2) {                     //  prime if the number is 2
            return true;
        }
        for(int i = 2; i < x; i++) {           // not prime if the number is divisible without remaining by 2 to x
            if(x % i == 0)
                return false;
        }
        return true;
    }

    public static boolean existFibonacci(int x) {

        ArrayList<Integer> f = new ArrayList<>();
        f.add(1);                              // add first and second element of the fibonacci series
        f.add(1);

        int i = 1;                             // last index of 'f' array
        while(f.get(f.size()-1) <= x) {        //  continue the series until reach the given number
            f.add(f.get(i)+f.get(i-1));
            i++;
            if(f.contains(x))                  // if the 'f' series include the given number, return true
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Logger logger = LogManager.getLogger();

        for (int i = 1; i <= 500; i++) {
            //if(isPrime(i) && existFibonacci(i)) {   // test the functions 1 to 15
                 logger.debug(i+" debug log is entered");
                logger.info(i+" info log is entered");
                logger.warn(i+" warn log is entered");
                //System.out.println(i + " is prime and exist fibonacci");
           // }
        }
    }
}
