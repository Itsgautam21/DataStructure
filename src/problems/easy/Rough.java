package problems.easy;

import java.util.Scanner;

public class Rough {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        String ans = "";
        for (int i = array.length - 1; i >= 0; i--) ans = ans + array[i] + " ";
        System.out.println(ans);
    }
}
