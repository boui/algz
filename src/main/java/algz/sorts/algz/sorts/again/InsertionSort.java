package algz.sorts.algz.sorts.again;

import algz.sorts.Utils;

/**
 * User: boui
 * Date: 10/16/14
 */
public class InsertionSort {
    public Integer[] sort(Integer[] array){
        int n = array.length;
        Integer[] result = Utils.arrayFullCopy(n, array);

        for(int i=1; i<n; i++){
            int j = i;
            while(j>0 && result[j]<result[j-1]){
                Utils.swap(j, j-1, result);
                j--;
            }
        }

        return result;
    }
}
