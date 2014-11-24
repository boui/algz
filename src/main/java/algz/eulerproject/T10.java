package algz.eulerproject;

public class T10 {
    public long getSumOfPrimes(int n){
        long sum = 2;
        for(int i=3; i<n; i++){
            if(isPrime(i)){
                sum+=i;
                System.out.println(i);
            }
        }

        return sum;
    }

    private boolean isPrime(int value){
        if(value % 2 == 0){
            return false;
        }

        for(int i = 3; i*i<=value; i+=2){
            if(value % i == 0) return false;
        }

        return true;
    }
}
