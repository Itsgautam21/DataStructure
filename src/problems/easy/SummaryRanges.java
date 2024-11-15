package problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SummaryRanges {
    /**
     * @Question :228
     */
    public static String getRangeString(List<Integer> s) {
        if (s.size() == 1) return String.valueOf(s.get(0));
        else return s.get(s.size() - 1) + "->" + s.get(0);
    }
    
    public static List<String> summaryRanges(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        for (int num : nums) {
            if (!stack.isEmpty() && stack.peek() != num - 1) {
                while (!stack.isEmpty())
                    ans.add(stack.pop());
                list.add(getRangeString(ans));
                ans = new ArrayList<>();
            }
            stack.push(num);
        }
        while (!stack.isEmpty())
            ans.add(stack.pop());
        list.add(getRangeString(ans));
        return list;
    }
    
    public static List<String> summaryRangesM2(int[] nums) {
        List<String> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1)
                ans.add(nums[i]);
            else {
                list.add(getRangeString(ans));
                ans = new ArrayList<>();
                ans.add(nums[i]);
            }
        }
        System.out.println(ans);
        return list;
    }
    
    public static void main(String[] args) {
        int[] testCase1 = {};
        int[] testCase2 = {-1};
        int[] testCase3 = {1, 2, 4, 5, 7, 8, 9, 11};
        int[] testCase4 = {1, 2, 4, 5, 7, 8, 9, 11, 12};
        System.out.println(summaryRanges(testCase1));
        System.out.println(summaryRanges(testCase2));
        System.out.println(summaryRanges(testCase3));
        System.out.println(summaryRanges(testCase4));
        
        //System.out.println(summaryRangesM2(testCase3));
    }
}
