import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MultiplesOf3Or5 {
    private static int numMul;
    
    public static long max(long mul) {
        return (numMul-1)/mul;
    }
    
    public static long sum(long max, long mul) {
        return (max * (max+1) / 2) * mul;
    }
    
    public static long muls(long mul) {
        return sum(max(mul), mul);
    }
    
    public static long multiples3and5(int n) {
        numMul = n;
        return muls(3) + muls(5) - muls(15);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(multiples3and5(n));
        }
    }
}
