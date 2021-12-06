package Fibonacci;

public class Fib {

    public static void main(String[] args){
        long[] memo = new long[100];
        System.out.println(fib(6));
        System.out.println(fib(60,memo));
    }
    //brute force
    public static int fib(int n){
        if(n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }
    //experience using model
    public static long fib(int n, long[] memo){
        if(n <= 2) return 1;
        if(memo[n - 1] != 0) return memo[n - 1];
        memo[n - 1] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n - 1];
    }
}
