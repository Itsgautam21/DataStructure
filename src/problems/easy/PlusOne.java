package problems.easy;

import java.util.Arrays;
import java.util.Stack;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        
        Stack<Integer> stack = new Stack<>();
        int one = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i] + one;
            if (value == 10) stack.push(0);
            else {
                stack.push(value);
                one = 0;
            }
        }
        if (one == 1) stack.push(1);
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = stack.pop();
        return result;
    }

    public static int[] plusOneM2(int[] digits) {
        boolean add = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if(add) {
                digits[i] = digits[i] + 1;
                add = false;
            }
            if(digits[i] == 10) {
                digits[i] = 0;
                add = true;
            }
        }
        if (add) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            for (int i = 0; i < digits.length; i++)
                arr[i + 1] = digits[1];
            digits = arr;
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] testCase1 = {9,9};
        int[] testCase2 = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        System.out.println(Arrays.toString(plusOne(testCase2)));
        System.out.println(Arrays.toString(plusOneM2(testCase1)));
    }
}
