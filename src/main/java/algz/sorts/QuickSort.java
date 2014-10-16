package algz.sorts;

import java.util.Random;

public class QuickSort {

    private Random r = new Random();
    public Integer[] sort(Integer[] array){
       partition(array, 0, array.length);
       return array;
    }

    public void partition(Integer[] array, int start, int end){

        if(end - start < 2){
            return ;
        }

        int ppos = r.nextInt(end - start);
        int pivot = array[start+ppos];

        int l = start;
        int u = end-1;

        while(l<u){
            while(array[l]<pivot){
                l++;
            }

            while(array[u]>pivot){
                u--;
            }

            if(l<u){
                if(array[l].equals(pivot)&& array[u].equals(pivot)) {
                    l++;
                } else {
                    Utils.swap(l, u, array);
                }
            }
        }

        partition(array, start, l);
        partition(array, l+1, end);

        return;
    }
}
