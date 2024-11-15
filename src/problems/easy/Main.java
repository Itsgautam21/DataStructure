package problems.easy;

public class Main {

    public static int getNumber(char ch) {
        switch (ch) {
            case 'M': return  1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }

    public static int getRomanToNumber(String str) {
        int n = str.length();
        int ans = getNumber(str.charAt(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            if (getNumber(str.charAt(i)) >= getNumber(str.charAt(i + 1)))
                ans += getNumber(str.charAt(i));
            else ans -= getNumber(str.charAt(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getRomanToNumber("MCMXCIV"));

    }
}