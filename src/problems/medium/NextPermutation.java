package problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @Question :31
 */
public class NextPermutation {
    
    public static boolean isAnagram(String a, String b) {
        
        if (a.length() != b.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            } else map.put(a.charAt(i), 1);
        }
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                map.put(b.charAt(i),
                        map.get(b.charAt(i)) - 1);
            } else return false;
        }
        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void nextPermutation(int[] array) {
        
        if (array.length == 0 || array.length == 1) return;
        boolean lastCase = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                lastCase = false;
                break;
            }
        }
        if (lastCase) {
            int start = 0;
            int last = array.length - 1;
            while (start < last) {
                int temp = array[start];
                array[start] = array[last];
                array[last] = temp;
                start++;
                last--;
            }
        } else {
            int division = 0;
            for (int i = array.length - 1; i > 0; i--) {
                if (array[i] > array[i - 1]) {
                    division = i;
                    break;
                }
            }
            int[] left = new int[division];
            int[] right = new int[array.length - division];
            System.arraycopy(array, division, right, 0, array.length - division);
            System.arraycopy(array, 0, left, 0, division);
            int max = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < right.length; i++) {
                if (left[left.length - 1] < right[i]) {
                    if (max > right[i]) {
                        max = right[i];
                        index = i;
                    }
                }
            }
            int temp = left[left.length - 1];
            left[left.length - 1] = right[index];
            right[index] = temp;
            Arrays.sort(right);
            System.arraycopy(left, 0, array, 0, left.length);
            System.arraycopy(right, 0, array, left.length, right.length);
        }
    }
    
    public static void nextPermutationM2(int[] array) {
        
        if (array.length == 0 || array.length == 1) return;
        boolean lastCase = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                lastCase = false;
                break;
            }
        }
        if (lastCase) {
            int start = 0;
            int last = array.length - 1;
            while (start < last) {
                int temp = array[start];
                array[start] = array[last];
                array[last] = temp;
                start++;
                last--;
            }
        } else {
            int number = 0;
            for (int i = 0; i < array.length; i++) {
                number = number + array[i] * (int) Math.pow(10, array.length - i - 1);
            }
            for (int i = number + 1; i < Integer.MAX_VALUE; i++) {
                if (isAnagram(String.valueOf(number), String.valueOf(i))) {
                    number = i;
                    break;
                }
            }
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = number % 10;
                number = number / 10;
            }
        }
    }
    
    public static void main(String[] args) {
        
        int[] array = {1, 3, 2, 4};
        //nextPermutation(array);
        nextPermutationM2(array);
        System.out.println(Arrays.toString(array));
    }
}
