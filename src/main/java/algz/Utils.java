package algz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

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

    public static void printArray(Integer[] list){
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

    public static void printDistribution(Map<Integer, Integer> distribution){
        for(Integer key:distribution.keySet()){
            System.out.print("key=" + key + "[");
            for(int i=0; i<distribution.get(key); i++){
                System.out.print("|");
            }
            System.out.println("]");
        }
    }

    public static Integer[] readArrayFromFile(String filename, int size) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));

        Integer[] array = new Integer[size];
        int k = 0;
        while(scanner.hasNext()){
            array[k] = scanner.nextInt();
            k++;
        }
        scanner.close();
        return array;
    }

    public static class Tuple{
        public int v1;
        public int v2;

        public Tuple(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}
