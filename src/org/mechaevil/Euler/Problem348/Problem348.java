package org.mechaevil.Euler.Problem348;

import org.mechaevil.util.StopWatch;
import org.mechaevil.util.Math.xMath;

public class Problem348 implements PalindromeCallback {
    
    private StringBuilder sb = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();
    
    private int count = 0;
    private long s = 0;

    public boolean checkNumber(long n) {
        long cubeBound = 1 + (long)Math.cbrt(n - 4);
        int c = 0;
        for(int cube = 0; cube < cubeBound; cube++) {
            long square = n - cube * cube * cube;
            if(xMath.isPerfectSquare(square))
                c++;
        }
        return c == 4;
    }
    
    private void iteratePalidromes(int startDigits, int maxDigits,PalindromeCallback callback) {
        for(int digits = startDigits; digits <= maxDigits; digits++) {
            if(digits % 2 == 0) {
                long end = (long) Math.pow(10, (digits / 2));
                long start = end / 10;
                 
                // loop
                for(long i = start; i < end; i++) {
                    long palindrome = appendReverse(i);
                    try {
                        callback.apply(palindrome);
                    }
                    catch(InterruptedException e) {
                        return;
                    }
                }
            }
            else {
             // this is odd digit based
                int digitGroupLength = digits - 1;
                long end = (long) Math.pow(10, (digitGroupLength / 2));
                long start = end / 10;
                 
                // loop
                for(long i = start; i < end; i++) {
                    // the middle digit comes from the second loop
                    for(int middle = 0; middle < 10; middle++) {
                        long palindrome = appendReverse(i,middle);
                        try {
                            callback.apply(palindrome);
                        }
                        catch(InterruptedException e) {
                            return;
                        }
                    }
                } 
            }
        }
    }

    private long appendReverse(long i, int middle) {
        sb.setLength(0);
        sb2.setLength(0);
        return Long.parseLong(sb.append(i).append(middle).append(sb2.append(i).reverse().toString()).toString());
    }

    private long appendReverse(long i) {
        sb.setLength(0);
        sb2.setLength(0);
        return Long.parseLong(sb.append(i).append(sb2.append(i).reverse().toString()).toString());
    }

    public static void main(String[] args) {
        StopWatch timer = new StopWatch();
        timer.startTimer();
        // Your Code here...
        new Problem348().solve();
        timer.stopTimer();
        System.out.println(timer);
    }

    public void solve() {
        iteratePalidromes(3,10, this);
        System.out.println("P348 : " +s);
    }

    @Override
    public void apply(long n) throws InterruptedException {
        if(checkNumber(n))
        {
            s+=n;
            count++;
        }
        if(count == 5) throw new InterruptedException();
    }

}
