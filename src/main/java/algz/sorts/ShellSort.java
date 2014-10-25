package algz.sorts;

import algz.Utils;
import java.util.LinkedList;

public class ShellSort {
    Integer[] darray;

    public Integer[] sort(Integer[] array) {
        int n = array.length;

        //creating list of d = n/2, n/4, .., 1;
        LinkedList<Integer> dlist = new LinkedList<Integer>();
        for (int i = n / 2; i > 1; i /= 2) {
            dlist.add(i);
        }
        dlist.add(1);
        darray = dlist.toArray(new Integer[dlist.size()]);

        Integer[] r = Utils.arrayFullCopy(n, array);
        int dl;
        int i;
        for (int k = 0; k < darray.length; k++) {
            dl = darray[k];
            i = dl;
            while (i < n) {
                int j = i;
                while (j - dl >= 0 && r[j - dl] > r[j]) {
                    Utils.swap(j, j - dl, r);
                    j-=dl;
                }
                i++;
            }
        }

        return r;
    }
}
