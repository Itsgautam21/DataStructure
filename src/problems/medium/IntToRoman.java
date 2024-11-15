package problems.medium;

import java.util.TreeMap;

/**
 * @Question :12
 */
public class IntToRoman {
    
    /**
     * Get roman digit in String
     *
     * @param ch digit
     * @return roman digit
     */
    public static String getRomanDigit(int ch) {

        switch (ch) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "";
        }
    }
    
    /**
     * Get Roman number from the decimal number
     *
     * @param num number in decimal
     * @return roman string
     */
    public static String getRomanDigits(int num) {
        
        String str = String.valueOf(num);
        StringBuilder ans = new StringBuilder();
        int length = str.length();
        char FirstChar = str.charAt(0);
        if (FirstChar == '4') {
            ans = new StringBuilder(getRomanDigit((int) Math.pow(10, length - 1)) + getRomanDigit(5 * (int) Math.pow(10, length - 1)));
        } else if (FirstChar == '9') {
            ans = new StringBuilder(getRomanDigit((int) Math.pow(10, length - 1)) + getRomanDigit((int) Math.pow(10, length)));
        } else if (FirstChar == '5') {
            ans.append(getRomanDigit(num));
        } else {
            int firstInt = Integer.parseInt(String.valueOf(FirstChar));
            if (firstInt > 5) {
                firstInt = firstInt - 5;
                ans.append(getRomanDigit(5 * (int) Math.pow(10, length - 1)));
            }
            ans.append(String.valueOf(getRomanDigit((int) Math.pow(10, length - 1))).repeat(Math.max(0, firstInt)));
        }
        return ans.toString();
    }
    
    /**
     * Method 2 to convert number to roman digits.
     *
     * @param num number in decimal
     * @return roman number in String
     */
    public static String intToRoman(int num) {
        
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int digit = num % 10;
            int digits = digit * (int) Math.pow(10, i);
            ans.insert(0, getRomanDigits(digits));
            num = num / 10;
            i++;
        }
        return ans.toString();
    }
    
    /**
     * Method 2
     */
    public static String intToRomanM2(int num) {
        
        TreeMap<Integer, String> intRomanMap = new TreeMap<>();
        intRomanMap.put(1, "I");
        intRomanMap.put(4, "IV");
        intRomanMap.put(5, "V");
        intRomanMap.put(9, "IX");
        intRomanMap.put(10, "X");
        intRomanMap.put(40, "XL");
        intRomanMap.put(50, "L");
        intRomanMap.put(90, "XC");
        intRomanMap.put(100, "C");
        intRomanMap.put(400, "CD");
        intRomanMap.put(500, "D");
        intRomanMap.put(900, "CM");
        intRomanMap.put(1000, "M");
        StringBuilder string = new StringBuilder();
        while (num > 0) {
            int highestLowValue = intRomanMap.floorKey(num);
            string.append(intRomanMap.get(highestLowValue));
            num -= highestLowValue;
        }
        return string.toString();
    }
    
    public static void main(String[] args) {
        
        System.out.println(intToRoman(549));
        System.out.println(intToRomanM2(549));
    }
}
