import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmallestMultiple {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b,a%b);
    }

    public static long lcm(long a,long b) {
        return (a*b) / gcd(a,b);
    }

    public static long smallestMultiple(long n) {
        long mul = (long) n;
        for (long i = mul-1; i > 1; i--) 
            mul = lcm(mul,i);
        return mul;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(smallestMultiple(n));
        }
    }
}