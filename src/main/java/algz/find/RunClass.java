package algz.find;

/**
 * Created by boui on 10/16/14.
 */
public class RunClass {
    public static void main(String[] args){
        int[] array = new int[]{1,2, 8, 21, 62, 230, 377};
        int result;

        int[] signalArray = new int[]{0,0,0,0,0,1,1,1,1,1,1,1};

//        result= new BinarySearch().search(array, 230);
//        System.out.println(result);

//        result = new BinarySearch().searchRec(array, 230, 0, array.length);
//        System.out.println(result);

        result = new OneSidedBinarySearch().search(signalArray);
        System.out.println(result);


    }
}
