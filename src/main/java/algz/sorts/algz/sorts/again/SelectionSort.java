package algz.sorts.algz.sorts.again;

import algz.sorts.Utils;

public class SelectionSort {
    public Integer[] sort(Integer[] array){
        int n = array.length;
        Integer[] result = Utils.arrayFullCopy(n, array);

        for(int i=0; i<n; i++){
            int minPos = findMinPosition(result, i);
            Utils.swap(minPos, i, result);
        }

        return result;
    }

    private Integer findMinPosition(Integer[] array, int start){
        int min = array[start];
        int minPos = start;
        for(int i = start+1; i<array.length; i++){
            if(min >  array[i]){
                min = array[i];
                minPos = i;
            }
        }

        return minPos;
    }
}
