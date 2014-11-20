package algz.eulerproject;

public class T7 {

    public long findPrimeByIndex(int number){
        int i = 1;
        long val = 2;
        while(i != number){
            val++;
            if(isPrime(val)){
                i++;
            }
        }

        return val;
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
}
