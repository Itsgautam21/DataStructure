package problems.easy;

import java.text.ParseException;
import java.util.HashSet;
/**
 * @Question : 222
 */
public class HappyNumber {
    
    public static boolean getNumber(int n, HashSet<Integer> set) {
        if (n == 1) return true;
        int squareSum = 0;
        int length = String.valueOf(n).length();
        for (int i = 0; i < length; i++) {
            int k = n % 10;
            n = n / 10;
            squareSum = squareSum + (k * k);
        }
        if (set.contains(squareSum)) return false;
        set.add(squareSum);
        return getNumber(squareSum, set);
    }
    public static boolean happyNumber(int n) {
        return getNumber(n, new HashSet<>());
    }
    public static void main(String[] args) throws ParseException {
        System.out.println(happyNumber(116));
    }
}
