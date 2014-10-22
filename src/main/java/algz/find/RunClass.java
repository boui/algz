package algz.find;

/**
 * Created by boui on 10/16/14.
 */
public class RunClass {
    public static void main(String[] args){
        Integer[] array = new Integer[]{1,2, 8, 21, 62, 230, 377};
        int result = new BinarySearch().find(array, 230);
        System.out.println(result);
    }
}
