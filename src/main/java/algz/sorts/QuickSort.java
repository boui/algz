package algz.sorts;

import algz.Utils;

import java.io.FileNotFoundException;
import java.util.Random;

public class QuickSort {

    private Random r = new Random();
    public Integer[] sort(Integer[] array){
       partitionLU(array, 0, array.length);
       return array;
    }

    public int comparisonCount1() throws FileNotFoundException {
        Integer[] array = Utils.readArrayFromFile("array_cousera_w2.txt", 10000);
        int r = partition1(array, 0, array.length);
//        Utils.printArray(array);
        return r;
    }

    public int comparisonCount2() throws FileNotFoundException {
        Integer[] array = Utils.readArrayFromFile("array_cousera_w2.txt", 10000);
        int r = partition2(array, 0, array.length);
//        Utils.printArray(array);
        return r;
    }

    public int comparisonCount2v2() throws FileNotFoundException {
        Integer[] array = Utils.readArrayFromFile("array_cousera_w2.txt", 10000);
        int r = partition2v2(array, 0, array.length);
//        Utils.printArray(array);
        return r;
    }

    public int comparisonCount3() throws FileNotFoundException {
        Integer[] array = Utils.readArrayFromFile("array_cousera_w2.txt", 10000);
//        int r = partition3(array, 0, array.length);
//        Utils.printArray(array);
        return 0;
    }

    public int comparisonCount3v3() throws FileNotFoundException {
        Integer[] array = Utils.readArrayFromFile("array_cousera_w2.txt", 10000);
        int r = partition3v3(array, 0, array.length);
//        Utils.printArray(array);
        return r;
    }

    public void partitionLU(Integer[] array, int start, int end){

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

        partitionLU(array, start, l);
        partitionLU(array, l + 1, end);

        return;
    }

    public int partition1(Integer[] array, int start, int end){
        int n = end - start;
        if(n <= 1){
            return 0;
        }

        int pivot = array[start];
        int i = start + 1;
        for(int j = start+1; j < end; j++) {
            if(array[j]<pivot){
                Utils.swap(i, j, array);
                i++;
            }
        }

        Utils.swap(start, i - 1, array);

        int m1 = partition1(array, start, i-1);
        int m2 = partition1(array, i , end);


        return m1 + m2 + n - 1;
    }

    public int partition2(Integer[] array, int start, int end){
        int n = end - start;

        if(n <= 1){
            return 0;
        }


        int pivot = array[end-1];
        int i = start;
        for(int j = start; j < end-1; j++) {
            if(array[j] < pivot){
                Utils.swap(i, j, array);
                i++;
            }
        }

        Utils.swap(end - 1, i, array);

        int m1 = partition2(array, start, i);
        int m2 = partition2(array, i+1, end);

        return m1 + m2 + n - 1;
    }

    public int partition2v2(Integer[] array, int start, int end){
        int n = end - start;

        if(n <= 1){
            return 0;
        }

        Utils.swap(start, end - 1, array);

        int pivot = array[start];
        int i = start+1;
        for(int j = start+1; j < end; j++) {
            if(array[j] < pivot){
                Utils.swap(i, j, array);
                i++;
            }
        }

        Utils.swap(start, i - 1, array);

        int m1 = partition2v2(array, start, i - 1);
        int m2 = partition2v2(array, i, end);

        return m1 + m2 + n - 1;
    }

//    public int partition3(Integer[] array, int start, int end){
//        int n = end - start;
//
//        if(n <= 1){
//            return 0;
//        }
//
//        Utils.Tuple pivotT = getMedianOfThree(array, start, (end-start)/2, end-1);
//        int pivot = pivotT.v2;
//        int pivotPos = pivotT.v1;
//
//        int i = start;
//        if(start == pivotPos) {
//            i = start+1;
//        }
//
//        for(int j = i; j < end; j++) {
//            if(j!= pivotPos && array[j] < pivot){
//                Utils.swap(i, j, array);
//                i++;
//            }
//        }
//
//        if(pivotPos == start){
//            Utils.swap(i-1, pivotPos, array);
//        }else {
//            Utils.swap(i, pivotPos, array);
//        }
//
//        int m1, m2;
//        if(start == pivotPos) {
//            m1 = partition3(array, start, i-1);
//            m2 = partition3(array, i , end);
//        }else {
//            m1 = partition3(array, start, i);
//            m2 = partition3(array, i + 1, end);
//        }
//
//        return m1 + m2 + n - 1;
//    }

    public int partition3v3(Integer[] array, int start, int end){
        int n = end - start;

        if(n <= 1){
            return 0;
        }

        Integer pivotPos = getMedianOfThree(array, start, start + (end - 1 - start)/2, end-1);
        Utils.swap(start, pivotPos, array);

        int pivot = array[start];
        int i = start+1;
        for(int j = start+1; j < end; j++) {
            if(array[j] < pivot){
                Utils.swap(i, j, array);
                i++;
            }
        }

        Utils.swap(start, i - 1, array);

        int m1 = partition3v3(array, start, i - 1);
        int m2 = partition3v3(array, i, end);

        return m1 + m2 + n - 1;
    }



    private Integer getMedianOfThree(Integer[] array, Integer i1, Integer i2, Integer i3){
        Integer v1 = array[i1];
        Integer v2 = array[i2];
        Integer v3 = array[i3];
        Integer median = v1+v2+v3 - min(v1,v2,v3) - max(v1, v2, v3);
        if(median.equals(v1)) return i1;
        if(median.equals(v2)) return i2;
        return i3;
    }

    private Integer min(Integer a, Integer b, Integer c ){
        return Math.min(Math.min(a,b), c);
    }

    private Integer max(Integer a, Integer b, Integer c ){
        return Math.max(Math.max(a, b), c);
    }
}
