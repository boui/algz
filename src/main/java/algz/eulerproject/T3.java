package algz.eulerproject;

import java.util.ArrayList;
import java.util.List;

/**
 * What is the largest prime factor of the number 600851475143
 */
public class T3 {

    private List<Long> factors = new ArrayList<Long>();
    public long largestPrimeFactor(long value) {

        long p = 2;
        boolean isPrime = false;
        while(value> 2 && !isPrime){
            p =  nextPrime(p);
            if(value % p == 0){
                value /= p;
                factors.add(p);
            }
        }
        return findMax();
    }

    private boolean isPrime(long num) {
        //check if n is a multiple of 2
        if (num%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=num;i+=2) {
            if(num%i==0)
                return false;
        }
        return true;
    }

    private long nextPrime(long num) {
        long i = num + 1;
        while (!isPrime(i)) {
            i++;
        }
        System.out.println("prime="+i);
        return i;
    }

    private long findMax(){
        Long max = factors.get(0);
        for(Long f : factors ){
            if (max<f){
                max = f;
            }
        }
        return max;
    }
}
