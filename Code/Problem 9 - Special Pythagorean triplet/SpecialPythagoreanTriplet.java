import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SpecialPythagoreanTriplet {
    public static long specialTriplet(long n) {
        for (long a = 1 ; a < n/3; a++) {
            long b = (n*n + - 2*a*n) / (2*n - 2*a);
            long c = n - a -b;
            if (a*a + b*b == c*c) return a*b*c;
        }
        return -1; // if don't have any pythagorean triple
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(specialTriplet(n));
        }
    }
}