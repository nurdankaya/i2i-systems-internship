import java.util.ArrayList;

public class IsPrimeAndExistFibonacci {

    public static boolean isPrime(int numberToCheckIsPrime) {

        if(numberToCheckIsPrime <= 1) {
            return false;
        }else if(numberToCheckIsPrime == 2) {
            return true;
        }
        for(int i = 2; i < numberToCheckIsPrime; i++) {
            if(numberToCheckIsPrime % i == 0)
                return false;
        }
        return true;
    }

    public static boolean existsFibonacci(int numberToCheckFibonacci) {
        ArrayList<Integer> f = new ArrayList<>();
        f.add(1);
        f.add(1);
        int i = 1;
        while(f.get(f.size()-1) <= numberToCheckFibonacci) {
            f.add(f.get(i)+f.get(i-1));
            i++;
            if(f.contains(numberToCheckFibonacci))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            if(isPrime(i) && existsFibonacci(i)) {   // test the functions 1 to 15
                System.out.println(i + " is prime and exist fibonacci");
            }
        }
    }
}
