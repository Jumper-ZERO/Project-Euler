import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NthPrime {
    public static List<Integer> sieveOfErotosthenes(int num) {
        boolean[] sieve = new boolean[num+1];
        List<Integer> primes = new ArrayList<>();
        
        Arrays.fill(sieve, true);
        
        for (int i = 2; i*i < sieve.length; i++) {
            if (sieve[i]) {
                for (int j = i; j*i < sieve.length; j++) {
                    sieve[j*i] = false;
                }
            }
        }
        
        for (int p = 2; p < sieve.length; p++) {
            if (sieve[p]) primes.add(p);
        }
        
        return primes;
    }

    public static void main(String[] args) {
        
        List<Integer> primes = sieveOfErotosthenes(104743);
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(primes.get(n-1));
        }
    }
}