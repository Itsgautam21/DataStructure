package problems.medium;

/**
 * @Question : 55
 */
public class JumpGame {

    private static boolean jump(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > ans)
                return false;
            ans = Math.max(ans, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {

        int[] array = {3, 2, 1, 1, 4};
        System.out.println(jump(array));
    }
}
