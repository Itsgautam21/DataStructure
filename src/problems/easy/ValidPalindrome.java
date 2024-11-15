package problems.easy;

public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                str.append(ch);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(validPalindrome(s));
    }
}
