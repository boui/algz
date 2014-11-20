package algz.eulerproject;

/**
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Not crazy effective))
 */
public class T4 {
    private int largest3DProduct = 999*999;
    private int smallest3DProduct = 100*100;

    public int findLargestPalidrome(){
        for(int digit = largest3DProduct; digit > smallest3DProduct; digit--){

            if(isPalindrome(digit)){
                if(isDividable(digit)) return digit;
            }
        }
        return -1;
    }

    private boolean isPalindrome(int digit){
        String digitS = Integer.toString(digit);
        String part1 = digitS.substring(0, digitS.length() / 2);
        String part2 = digitS.substring(digitS.length()/2, digitS.length());
        return part1.equals(new StringBuilder(part2).reverse().toString());
    }

    private boolean isDividable(int digit){
        for(int i=999; i>=100; i--){

            if(digit%i == 0) {
                int div = digit/i;
                return Integer.toString(div).length() == 3;
            }
        }
        return false;
    }
}
