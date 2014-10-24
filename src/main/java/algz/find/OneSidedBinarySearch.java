package algz.find;

public class OneSidedBinarySearch {

    public int search(int[] array) {
        int current = 0;
        int next = 1;
        while (next < array.length && array[next] != 1) {
            current = next;
            next *= 2;
        }

        int last = Math.min(array.length, next);

        return new BinarySearch().searchRec(array, 1, current, last);
    }
}
