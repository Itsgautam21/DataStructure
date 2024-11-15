package problems.medium;

/**
 * @Question :8
 */
public class StringToInteger {
    
    public static int getNumber(String s, long ans, int negative) {
        for (int i = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                ans = ans * 10;
                ans = ans + Character.getNumericValue(s.charAt(i));
                if (negative * ans < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                if (negative * ans > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            } else break;
        }
        return negative * (int) ans;
    }
    
    public static int stringToInt(String s)  {
        int negative = 1;
        long ans = 0;
        s = s.trim();
        if (s.equals("")) return 0;
        char ch = s.charAt(0);
        
        if (ch == '+') {}
        else if (ch == '-')
            negative = -1;
        else if (Character.isDigit(ch))
            ans = Character.getNumericValue(ch);
        else return 0;
        return getNumber(s, ans, negative);
    }
    public static void main(String[] args) {
        System.out.println(stringToInt("  -4555 888 with number"));
    }
}
