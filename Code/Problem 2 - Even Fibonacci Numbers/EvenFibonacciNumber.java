import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenFibonacciNumber {
    public static long fiboEvenSum(long n) {
        long[] nums = {1,1,2};
        long sum = 0;
        
        while (nums[2] <= n) {
            sum += nums[2];
            nums = new long[]{
                nums[2]+nums[1], 
                nums[2]*2+nums[1], 
                nums[2]*3+nums[1]*2
            };
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(fiboEvenSum(n));
        }
    }
}