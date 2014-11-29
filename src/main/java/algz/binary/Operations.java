package algz.binary;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Operations {

    public String adding(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int carry=0, d1bit, d2bit;
        int n1 = s1.length(), n2 = s2.length();
        for(int i = 0; i < Math.max(n1, n2) ;i++) {
            d1bit = i< n1 ? s1.charAt(n1-i-1) - '0': 0;
            d2bit = i< n2 ? s2.charAt(n2-i-1) - '0': 0;
            result.insert(0, (char)((d1bit ^ d2bit ^ carry) + '0'));
            carry = d1bit & d2bit | d1bit & carry | d2bit & carry;
        }
        return carry == 0 ? result.toString() : result.insert(0, (char)(carry+'0')).toString();
    }

    public static void main(String[] args) {
        Operations op = new Operations();
        System.out.println(op.adding("001", "111"));//1000
        System.out.println(op.adding("000", "1111"));//1111
        System.out.println(op.adding("101", "111"));//1100
    }
}
