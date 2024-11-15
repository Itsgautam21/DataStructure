package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Question :16
 */
public class ThreeSum {
    
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = - nums[i];
                while (low < high) {
                    System.out.println(nums[i] + nums[low] + nums[high]);
                    if (nums[low] + nums[high] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] array = {-1, 2, 1, -4};
        System.out.println(threeSum(array));
    }
}
