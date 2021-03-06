package algz.sorts;

import algz.Utils;

import java.util.LinkedList;
import java.util.List;

public class MergeSort {
    public Integer[] sortRecursively(Integer[] array) {
        int n = array.length;

        if (n <= 1) return array;
        int half = array.length / 2;

        Integer[] left = new Integer[half];
        System.arraycopy(array, 0, left, 0, half);
        Integer[] right = new Integer[n - half];
        System.arraycopy(array, half, right, 0, n - half);

        left = sortRecursively(left);
        right = sortRecursively(right);

        return merge(left, right);
    }

    public Integer[] sortIncrementally(Integer[] array){
        Integer[] r = Utils.arrayFullCopy(array.length, array);

        for(int i=1; i<r.length; i = 2*i){
            for(int j=0; j< r.length - i; j += 2*i){
                mergeInPlace(r, j, Math.min(r.length, j + i), Math.min(r.length, j + 2*i));
            }
        }
        return r;
    }

    private void mergeInPlace(Integer[] array, int start, int end1, int end2){
        int i=start; int j = end1;
        List<Integer> result = new LinkedList<Integer>();
        while (i<end1 && j<end2){
            if(array[i]<array[j]){
                result.add(array[i]);
                i++;
            } else {
                result.add(array[j]);
                j++;
            }

        }
        while(i<end1){
            result.add(array[i]);
            i++;
        }

        while(j<end2){
            result.add(array[j]);
            j++;
        }

        for(int k = 0; k<result.size(); k++){
            array[start+k] = result.get(k);
        }
    }

    private Integer[] merge(Integer[] left, Integer[] right) {
        int i = 0;
        int j = 0;

        List<Integer> result = new LinkedList<Integer>();
        while (i<left.length && j<right.length) {
            if (left[i] < right[j]) {
                result.add(left[i]);
                i++;
            } else {
                result.add(right[j]);
                j++;
            }
        }

        while(i<left.length) {
            result.add(left[i]);
            i++;
        }

        while(j<right.length){
            result.add(right[j]);
            j++;
        }

        return result.toArray(new Integer[result.size()]);
    }
}
