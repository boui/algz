package algz.sorts;


import algz.dstruct.Heap;

public class HeapSort {
    
    public int[] sort(int[] array){
        Heap h = new Heap().heapify(array);

        int[] sorted = new int[array.length];
        for(int i = 0; i<array.length; i++){
            sorted[i] = h.extractMin();
        }
        return sorted;
    }
}
