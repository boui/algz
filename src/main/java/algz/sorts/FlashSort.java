package algz.sorts;

import algz.Utils;

import java.util.Arrays;

public class FlashSort {

    int m;
    Integer[] karray;
    double c;

    public Integer[] sort(Integer[] array) {
        int n = array.length;
        Integer[] r = Utils.arrayFullCopy(n, array);
        m = new Double(n * 0.42).intValue();
        karray = new Integer[m];
        Arrays.fill(karray, 0);

        int imin = findMin(r);
        int imax = findMax(r);
        Integer min = r[imin];
        Integer max = r[imax];

         c = ((double) m - 1) / (max - min);

        for(int i=0; i<n; i++){
            int j = updDistribution(r[i], min);
            karray[j]++;
        }

        //TODO: find out why this is working
        for (int i = 1; i < m; i++){
            karray[i] += karray[i - 1];
        }

        Utils.swap(imax, 0, r);

        int nmove = 0;
        int flash;
        int j = 0;
        int k = m-1;

        while (nmove < n - 1) {
            while (j > (karray[k] - 1)) {
                j++;
                k = updDistribution(r[j], min);
            }
            flash = r[j];

            while (!(j == karray[k])) {
                k = updDistribution(flash, min);

                int hold = r[karray[k] - 1];
                r[karray[k] - 1] = flash;
                flash = hold;

                karray[k]--;
                nmove++;
            }
        }

        return new InsertionSort().sort(r);
    }

    private int updDistribution(Integer ai, Integer amin) {
        return 1 +  (int) c * (ai - amin);
    }

    private int findMax(Integer[] array) {
        int max = array[0];
        int maxi = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxi = i;
            }
        }
        return maxi;
    }

    private int findMin(Integer[] array) {
        int min = array[0];
        int mini = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                mini = i;
            }
        }
        return mini;
    }
}
