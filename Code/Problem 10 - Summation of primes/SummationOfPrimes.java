import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SummationOfPrimes {

    static int SIZE = 1000000; // 10**6

    public static long[] sumsOfPrimes(int n) {
        boolean[] sieve = new boolean[n+1]; // n+1 to res <= n
        long[] sumPrimes = new long[sieve.length + 1];
        
        Arrays.fill(sieve, true);
        
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                sumPrimes[i] = sumPrimes[i-1] + i;
                for (long j = (long)i*i; j < sieve.length; j+=i) {
                    sieve[(int) j] = false;
                }
            } else {
                sumPrimes[i] = sumPrimes[i-1];
            }
        }
        
        return sumPrimes;
    }

    public static void main(String[] args) {
        
        long[] sums = sumsOfPrimes(SIZE);
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(sums[n-1]);
        }
    }
}
