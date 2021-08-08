import java.util.ArrayList;

public class Fibonacci {
    // Top down approach
    // time complexity - O(n)
    // space complexity - O(n)
    public static int fibMemorization(int n,int cache[]) {

        if (n < 2)
            return n;
        if (cache[n] != 0)
            return cache[n];
        return cache[n] = fibMemorization(n - 1,cache) + fibMemorization(n - 2,cache);
    }

    // Bottom up approach
    // time complexity - O(n)
    // space complexity - O(n)
    public static int fibTabulation(int n) {
        int cache[] = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++)
            cache[i] = cache[i - 1] + cache[i - 2];

        return cache[n];
    }

    // time complexity - O(2^n)
    public static int recursiveFibonacci(int n) {
        if (n < 2)
            return n;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int myFibonacci(int x) {
        if(x <= 2)
            return x;
        ArrayList<Integer> f = new ArrayList<>();
        f.add(1);
        f.add(1);
        for(int i = 1; i < x-1; i++) {
            f.add(f.get(i)+f.get(i-1));
        }
        return f.get(x-1);
    }

    public static void main (String args[]) throws InterruptedException {
        int n = 30;

        long startTime = 0, endTime = 0, executionTime = 0;

        startTime = System.nanoTime();
        System.out.println("recursiveFibonacci result:" + recursiveFibonacci(n));
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("executionTime for recursiveFibonacci :" + executionTime);

        System.out.println("\n");
        Thread.sleep(1000);

        startTime = System.nanoTime();
        System.out.println("fibMemorization result:" + fibMemorization(n, new int[n+1]));
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("executionTime for fibMemorization :" + executionTime);

        System.out.println("\n");
        Thread.sleep(1000);

        startTime = System.nanoTime();
        System.out.println("fibTabulation result:" + fibTabulation(n));
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("executionTime for fibTabulation :" + executionTime);

        System.out.println("\n");
        Thread.sleep(1000);

        startTime = System.nanoTime();
        System.out.println("myFibonacci result:" + myFibonacci(n));
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("executionTime for myFibonacci :" + executionTime);

    }
}
