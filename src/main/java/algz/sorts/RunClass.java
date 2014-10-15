package algz.sorts;

import java.util.ArrayList;
import java.util.List;

public class RunClass {


    public static void main(String[] args){
        Integer[] array = new Integer[]{1,4,2,87, 62,37,377,2,4,9,11};
        Integer[] result = null;

//        result = new BubleSort().sort(array);
//        printList(result);

//        result = new InsertionSort().sort(array);
//        printList(result);

//        result = new MergeSort().sortRecursively(array);
//        Utils.printList(result);

        result = new MergeSort().sortIncrementally(array);
        Utils.printList(result);


    }
}
