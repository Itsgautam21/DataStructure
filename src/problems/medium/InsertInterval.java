package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Question : 57
 */
public class InsertInterval {

    /**
     * INSERT INTERVALS
     *
     * @param intervals   list of intervals
     * @param newInterval new interval
     * @return merge interval
     */
    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        int i = 0;
        // add all intervals before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        // merge interval with the add interval to the list
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.max(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        // add remaining interval after newInterval ends.
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insertInterval(intervals, newInterval)));
    }
}
