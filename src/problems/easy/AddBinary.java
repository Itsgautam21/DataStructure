package problems.easy;

import java.util.Stack;

public class AddBinary {
    
    public static String addBinary(String a, String b) {

        String minLengthString = a.length() < b.length() ? a : b;
        int diffLength = Math.abs(a.length() - b.length());
        StringBuilder addZero = new StringBuilder();
        addZero.append("0".repeat(diffLength));
        if (minLengthString.equals(a)) a = addZero + minLengthString;
        else b = addZero + minLengthString;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = b.length() - 1; i >= 0; i--) {
            int digitOFa = Integer.parseInt(String.valueOf(a.charAt(i)));
            int digitOFb = Integer.parseInt(String.valueOf(b.charAt(i)));
            int sum = digitOFa + digitOFb + carry;
            if (sum == 0) {
                stack.push(0);
                carry = 0;
            } else if (sum == 1) {
                stack.push(1);
                carry = 0;
            } else if (sum == 2) {
                stack.push(0);
                carry = 1;
            } else {
                stack.push(1);
                carry = 1;
            }
        }
        if (carry == 1) stack.push(1);
        while (!stack.isEmpty()) ans.append(stack.pop());
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11111", "111"));
    }
}
