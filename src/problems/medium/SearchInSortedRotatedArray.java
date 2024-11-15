package problems.medium;

public class SearchInSortedRotatedArray {
    
    public static final int ZERO = 0;
    
    public static int binarySearch(int[] array, int target) {
        
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
    
    public static int findPivot(int[] array, int left, int right) {
        
        if (left > right) return -1;
        if (left == right) return left;
        int mid = (left + right) / 2;
        if (mid < right && array[mid] > array[mid + 1]) return mid;
        if (mid > left && array[mid] < array[mid - 1]) return mid - 1;
        if (array[left] >= array[mid])
            return findPivot(array, left, mid - 1);
        return findPivot(array, mid + 1, right);
    }
    
    public static int search(int[] rotatedSortedArray, int target) {
        
        int pivot = findPivot(rotatedSortedArray, 0, rotatedSortedArray.length - 1);
        int[] leftArray = new int[pivot + 1];
        int[] rightArray = new int[rotatedSortedArray.length - pivot - 1];
        System.arraycopy(rotatedSortedArray, 0, leftArray, 0, pivot + 1);
        System.arraycopy(rotatedSortedArray, pivot + 1, rightArray, 0, rotatedSortedArray.length - pivot - 1);
        int resultFromLeft = binarySearch(leftArray, target);
        int resultFromRight = binarySearch(rightArray, target);
        if (resultFromLeft != -1)
            return resultFromLeft;
        else if (resultFromRight != -1)
            return pivot + resultFromRight + 1;
        else return -1;
    }
    
    public static void main(String[] args) {
        
        int[] rotatedSortedArray = {5, 6, 7, 8, 9, 10, 11, 1, 2, 3, 4};
        int target = 2;
        System.out.println(findPivot(rotatedSortedArray, 0, rotatedSortedArray.length - 1));
        System.out.println(search(rotatedSortedArray, target));
    }
}

