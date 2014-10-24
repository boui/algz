package algz.find;

public class BinarySearch {

    public int search(int[] array, int x){
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

        if(array[l] == x) return l;
        else return -1;
    }

    public int searchRec(int[] array, int x, int l, int u){
        if(l > u){
            return -1;
        } else {
            int mid = (l+u)/2;
            if(array[mid] == x) return mid;
            if(array[mid] > x){
                return searchRec(array, x, l, mid);
            } else {
                return searchRec(array, x, mid, u);
            }
        }
    }
}
