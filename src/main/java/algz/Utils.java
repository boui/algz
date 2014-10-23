package algz;

public class Utils {
    public static void swap(int from, int to, Integer[] array) {
        Integer tmp = array[to];
        array[to] = array[from];
        array[from] = tmp;
    }

    public static void swap(int from, int to, int[] array) {
        Integer tmp = array[to];
        array[to] = array[from];
        array[from] = tmp;
    }


    public static Integer[] arrayFullCopy(int n, Integer[] array){
        Integer[] r = new Integer[n];
        System.arraycopy(array, 0, r, 0, n);
        return r;
    }

    public static void printList(Integer[] list){
        System.out.print("[");
        for(Integer i:list) System.out.print(i+",");
        System.out.println("]");
    }

    public static void printList(int[] list){
        System.out.print("[");
        for(int i=0; i<list.length; i++) {
            System.out.print(list[i]+",");
        }
        System.out.println("]");
    }
}
