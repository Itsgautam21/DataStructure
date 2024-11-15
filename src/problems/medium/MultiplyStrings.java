package problems.medium;

/**
 * @Question : 43
 */
public class MultiplyStrings {

    /**
     * Multiplication of two large numbers
     *
     * @param num1 1st number in string
     * @param num2 2nd number in string
     * @return product of two number
     */
    private static String multiplyStrings(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] array = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int outerValue = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int innerValue = num2.charAt(j) - '0';
                int product = outerValue * innerValue;

                product = product + array[i + j + 1];
                array[i + j + 1] = product % 10;
                array[i + j] += product / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i : array) {
            if (i == 0 && builder.length() == 0) continue;
            builder.append(i);
        }
        return builder.toString();
    }

    /**
     * Get factorial of a large number.
     *
     * @param num number
     * @return factorial of a number
     */
    private static String getFactorial(int num) {
        if (num == 1) return "1";
        return multiplyStrings(String.valueOf(num), getFactorial(num - 1));
    }

    public static void main(String[] args) {
        String num1 = "4788";
        String num2 = "1";
        System.out.println(getFactorial(100));
        System.out.println(multiplyStrings(num1, num2));
    }
}
