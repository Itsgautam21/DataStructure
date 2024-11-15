package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    /**
     * @Question :119
     */
    public static List<Integer> func(int n) {
        List<List<Integer>> listOfList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) list.add(1);
            else if (i == 1) {
                list.add(1);
                list.add(1);
            } else {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) list.add(1);
                    else {
                        List<Integer> prevList = listOfList.get(i - 1);
                        list.add(prevList.get(j - 1) + prevList.get(j));
                    }
                }
            }
            listOfList.add(list);
        }
        return listOfList.get(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(func(6));
    }
}
