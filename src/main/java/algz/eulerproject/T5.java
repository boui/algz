package algz.eulerproject;

import java.util.List;

/**
 * 2520 is the smallest number that can be divided by each of
 * the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class T5 {
    private int l = 20;

    public int findMinimal(){

        int[] muls = new int[l];
        muls[0] = 1;
        muls[1] = 2;
        for(int i = 2; i<l ; i++){
            int val = i+1;
            for(int j = 0; j < i-1; j++){
                if(val % muls[j] == 0){
                    val /= muls[j];
                }
            }
            muls[i] = val;
        }

        int mul = 1;
        for(int i = 0; i<l; i++){
            mul*=muls[i];
        }

        return mul;
    }
}
