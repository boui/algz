package algz.sorts;

import java.io.IOException;

public class RunClass {


    public static void main(String[] args) {
//        Integer[] array = new Integer[]{1, 4, 2, 87, 15, 8 , 18, 11, 26, 0, 0};
//        Integer[] array = new Integer[]{1, 4, 2, 87, 62, 37, 377, 2, 4, 9, 11};
//        Integer[] result = null;
//
//        result = new BubleSort().sort(array);
//        Utils.printList(result);
//
//        result = new InsertionSort().sort(array);
//        Utils.printList(result);
//
//        result = new SelectionSort().sort(array);
//        Utils.printList(result);
//
//        result = new MergeSort().sortRecursively(array);
//        Utils.printList(result);
//
//        result = new MergeSort().sortIncrementally(array);
//        Utils.printList(result);
//
//        result = new QuickSort().sort(array);
//        Utils.printList(result);

        try{
            new InversionsWithMergeSort().count("IntegerArray.txt");
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
