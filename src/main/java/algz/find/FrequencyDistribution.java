package algz.find;

import algz.sorts.MergeSort;

import java.util.HashMap;
import java.util.Map;


//TODO:Resolve int[] vs. Integer[] methods battle
public class FrequencyDistribution {
    //TODO: reimplement more efficient
    public Map<Integer, Integer> build(Integer[] array) {
        //nlogn
        Integer[] sa = new MergeSort().sortRecursively(array);

        BinarySearch bs = new BinarySearch();
        Map<Integer, Integer> distribution = new HashMap<Integer, Integer>();
        for (int i = 0; i < sa.length; i++) {
            distribution.put(sa[i], 0);
        }

        for (Integer key : distribution.keySet()) {
            distribution.put(key, getCount(sa, key, bs.searchRec(sa, key, 0, sa.length)));
        }

        return distribution;
    }

    private int getCount(Integer[] sa, Integer x, int pos) {
        int l = pos;
        int u = pos;

        while(l>0 && sa[l].equals(x)) l--;
        while(u<sa.length && sa[u].equals(x)) u++;

        return u-l;
    }


}
