package algz.find;

import algz.Utils;

public class RunClass {
    public static void main(String[] args){
        int[] array = new int[]{1,2, 8, 21, 62, 230, 377};
        int result;

        int[] signalArray = new int[]{0,0,0,0,0,1,1,1,1,1,1,1};
        Integer[] freqArray = new Integer[]{0,5,5,9,9,2,5,3,5,3,7,6,7,7,7,2,2,9,0,0,0,0,6,6,7,8,6};

//        result= new BinarySearch().search(array, 230);
//        System.out.println(result);

//        result = new BinarySearch().searchRec(array, 230, 0, array.length);
//        System.out.println(result);

//        result = new OneSidedBinarySearch().search(signalArray);
//        System.out.println(result);

          Utils.printDistribution(new FrequencyDistribution().build(freqArray));

    }
}
