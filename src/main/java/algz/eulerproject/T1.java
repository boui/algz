package algz.eulerproject;

public class T1 {

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
     * The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    public long count(int a, int b, int n) {
        int na = n/a;
        int sumA = a*na*(na+1)/2;

        int nb = n/b;
        int sumB = b*nb*(nb+1)/2;

        int abboth = n/(a*b);
        int sumBoth= a*b*abboth*(abboth+1)/2;

        return sumA+sumB-sumBoth;
    }
}
