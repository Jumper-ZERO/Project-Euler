import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumSquareDifference {

    public static long resolve(int n) {
        long num = (long) n;
        long sum1 = num * (num+1) * (2*n+1) / 6;
        long sum2 = (long)Math.pow(num * (num+1) / 2, 2);

        return sum2 - sum1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(resolve(n));
        }
    }
}