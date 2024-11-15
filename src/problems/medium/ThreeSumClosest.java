package problems.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    
    public static int threeSumClosest(int[] nums, int target) {
        
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum < target) low++;
                else if (sum > target) high--;
                else return ans;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] array = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(array, 1));
    }
}
