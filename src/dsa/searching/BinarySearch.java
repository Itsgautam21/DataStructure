package dsa.searching;

public class BinarySearch {

    private static boolean binarySearch(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        // stop when start is greater than end.
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) return true; // Check if x is present at mid.
            else if (x < arr[mid]) end = mid - 1; // if x is smaller, ignore right.
            else start = mid + 1; // if x is greater, Ignore left.
        }
        return false;
    }
    private static boolean reverseSearch(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        //stop when start is greater than end.
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) return true; // Check if x is present at mid.
            else if (x < arr[mid]) start = mid + 1; // if x is smaller, ignore left.
            else end = mid - 1; // if x is greater, Ignore right.
        }
        return false;
    }
    private static boolean orderNotKnownSearch(int[] array, int element) {
        if (array.length == 1) return array[0] == element;
        if (array[0] < array[1]) return binarySearch(array, element);
        else return reverseSearch(array, element);
    }
    private static int firstOccurrence(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element) {
                result = mid;
                end = mid - 1;
            }
            else if (element < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return result;
    }
    private static int lastOccurrence(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element) {
                result = mid;
                start = mid + 1;
            }
            else if (element < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return result;
    }
    private static int countRepeatedElement(int[] arr, int element) {
        int firstIndex = firstOccurrence(arr, element);
        int lastIndex = lastOccurrence(arr, element);
        return lastIndex - firstIndex + 1;
    }
    private static int countRepeatedElement2(int[] arr, int element) {
        int N = arr.length;
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = (mid + N - 1) % N;
            int next = (mid + 1) % N;
            System.out.println(arr[mid]);
            if (arr[mid] == element) {
                count++;
                if (arr[mid] == arr[prev]) end = mid - 1;
                else if (arr[mid] == arr[next]) start = mid + 1;
                else break;
            }
            else if (element < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return count;
    }
    private static int minElement(int[] arr) {
        int N = arr.length;
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] < arr[end]) return arr[start];
        //if (arr[start] > arr[end]) return arr[end];
        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = (mid + N - 1) % N;
            int next = (mid + 1) % N;
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) return arr[mid];
            if (arr[start] <= arr[mid]) start = mid + 1;
            else if (arr[end] >= arr[mid]) end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int[] reverse = {99, 88, 77, 66, 55, 44, 33, 22, 11};
        int[] rotated = {5, 6, 7, 8, 9, 1, 2 ,3, 4};
        int[] a = {3, 3, 3 , 1};
        int[] repeated = {11 , 22, 33, 99, 99, 99, 111, 121, 131};
        int search = 99;
        System.out.println("Ascending Search --> " + binarySearch(array, search));
        System.out.println("descending Search --> " + reverseSearch(reverse, search));
        System.out.println("Order Not Known Search --> " + orderNotKnownSearch(array, search));
        System.out.println("First Occurrence --> " + firstOccurrence(repeated, search));
        System.out.println("Last Occurrence ---> " + lastOccurrence(repeated, search));
        System.out.println("Count repeated elements --> " + countRepeatedElement(repeated, search));
        //System.out.println(countRepeatedElement2(repeated, search));
        System.out.println("Minimum Element --> " + minElement(a));

    }

}
