import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestPalindromeProduct {
    public static boolean isPalindrome(long n) {
        long original = n;
        long reversed = 0;
        while (n > 0) {
            reversed = (reversed * 10) + (n%10);
            n /= 10;
        }
        return original == reversed;
    }
    public static long largestPalindromeProduct(int n) {
        long largest = 0;
        long max = (long) Math.pow(10,n)-1;
        long min = (long) Math.pow(10,n-1);

        for (long i = max; i > min; i--) {
            for (long j = i; j > min; j--) {
                long prod = i*j;
                if (prod < largest) break;
                else if (isPalindrome(prod)) {
                    largest = prod;
                    break;
                }
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(largestPalindromeProduct(n));
        }
    }
}