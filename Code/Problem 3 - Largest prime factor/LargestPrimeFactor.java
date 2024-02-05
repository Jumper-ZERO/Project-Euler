import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestPrimeFactor {
    public static long largestPrimeNumber(long n) {
        long largest = -1;
        
        while (n % 2 == 0) {
            n /= 2;
            largest = 2;
        }
        
        for (long i = 3; i <= Math.sqrt(n); i+=2) {
            while (n % i == 0) {
                n /= i;
                largest = i;
            }
        }
        if (n > 2) 
            largest = n;
        
        return largest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(largestPrimeNumber(n));
        }
    }
}
