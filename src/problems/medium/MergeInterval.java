package problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Question : 56
 */
public class MergeInterval {

    /**
     * MERGE INTERVAL
     *
     * @param intervals interval list
     * @return merged intervals
     */
    private static int[][] mergeInterval(int[][] intervals) {

        // sort intervals based on the start index of interval.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            // add first interval to the list.
            // if interval will not merge then add to the list.
            if (list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            }
            // for merging the intervals replace the end of prev interval
            // with the max of (end of prev, end of curr).
            else list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
        }
        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(mergeInterval(array)));
    }
}
