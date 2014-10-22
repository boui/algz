package algz.sorts;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InversionsWithMergeSort {

    private class MergeResult{
        public int[] array;
        public long counter;
        private MergeResult(int[] array, long counter) {
            this.array = array;
            this.counter = counter;
        }
    }
    public Integer count(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));

        int[] array = new int[100000];
        int k = 0;
        while(scanner.hasNext()){
            array[k] = scanner.nextInt();
            k++;
        }

        MergeResult result = divideAndCounquer(new MergeResult(array, 0));
        System.out.println(result.counter);

        scanner.close();
        return 0;
    }

    private MergeResult divideAndCounquer(MergeResult arrayAndCount){
        int n = arrayAndCount.array.length;
        if(n <=1) return arrayAndCount;

        int half =n/2;

        int[] left = new int[half];
        int[] right = new int[n - half];

        System.arraycopy(arrayAndCount.array, 0, left, 0, half);
        System.arraycopy(arrayAndCount.array, half, right, 0, n - half);

        MergeResult leftRes = new MergeResult(left, arrayAndCount.counter);
        MergeResult rightRes = new MergeResult(right, arrayAndCount.counter);
        leftRes = divideAndCounquer(leftRes);
        rightRes = divideAndCounquer(rightRes);

        return mergeAndCount(leftRes, rightRes);
    }

    private MergeResult mergeAndCount(MergeResult leftRes, MergeResult rightRes){
        int[] left = leftRes.array;
        int[] right = rightRes.array;
        int i = 0;
        int j = 0;
        int k = 0;
        long count = leftRes.counter+rightRes.counter;
        int[] tmp = new int[left.length+right.length];
        while(i<left.length && j<right.length){
            if(left[i] <= right[j]){
                tmp[k] = left[i];
                i++; k++;
            } else {
                tmp[k] = right[j];
                j++; k++; count += left.length - i;
            }
        }

        while (i<left.length){
            tmp[k] = left[i]; k++; i++;
        }

        while (j<right.length){
            tmp[k]= right[j]; k++; j++;
        }

        return new MergeResult(tmp, count);
    }
}
