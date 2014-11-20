package algz.eulerproject;

/**
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum
 *
 */
public class T6 {
    public long diff(int times){
        long sum = (times*(times+1))/2;
        long squareSum = sum*sum;

        long sumOfSquares = 0;
        for(int i=0; i<times; i++){
            int val = i+1;
            sumOfSquares += val*val;
        }

        return squareSum - sumOfSquares;
    }
}
