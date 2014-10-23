package algz.sorts;

import algz.Utils;

public class BubleSort {
    public Integer[] sort(Integer[] array){
        int n = array.length;
        Integer[] r = Utils.arrayFullCopy(n, array);

        for(int i = n-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(r[i] < r[j]){
                    Utils.swap(i, j, r);
                }
            }
        }

        return r;

    }
}
