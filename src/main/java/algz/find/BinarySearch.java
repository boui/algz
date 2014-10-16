package algz.find;

public class BinarySearch {

    public int find(Integer[] array, int x){
        int l = 0;
        int u = array.length;
        int half;
        while(l+1 < u){
            half = (l+u)/2;
            if(array[half] > x){
                u = half;
            } else {
                l = half;
            }
        }

        if(array[l].equals(x)) return l;
        else return -1;
    }
}
