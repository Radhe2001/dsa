
import java.util.ArrayList;
import java.util.HashMap;

public class Array {

    public static void main(String[] args) {
        // int[] arr = {1, 2, 5, 4, 8, 6, 9, 3, 2, 5};
        // int[] arr = {1, 2, 3, 3, 4, 5, 6, 7, 7, 8, 9};
        // int[] arr = {0, 1, 0, 3, 12};
        // LargestElement(arr);
        // SecondLargest(arr);
        // CheckSorted(arr);
        // RemoveDuplicateFromSortedArray(arr);
        // RotateArray(arr, 3);
        // moveZeroes(arr);
        // int[] arr1 = {1, 11, 4, 5, 6};
        // int[] arr2 = {12, 11, 41, 105, 6};
        // ArrayList<Integer> arr = findUnion(arr1, arr2);
        // for (int i : arr) {
        //     System.out.println(i);
        // }
        // boolean result = searchInSorted(arr, 5);
        // System.out.println(result);
        // for (int i : arr) {
        //     System.out.print(i + " , ");
        // }

        // int[] arr = {3, 0, 1};
        // int num = missingNumber(arr);
        // System.out.println(num);
        // int[] arr = {1, 0, 1, 1, 0, 1};
        // int num = findMaxConsecutiveOnes(arr);
        // int[] arr = {10, 5, 2, 7, 1, -10};
        // int num = singleNumber(arr);
        // int num = longestSubarray(arr, 15);
        // System.out.println(num);
        int[] arr = {2, 5, 5, 11};
        int[] temp = twoSum(arr, 10);
        for (int i : temp) {
            System.out.println(i);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.putIfAbsent(i, 0);
            map.replace(i, map.get(i) + 1);
        }
        Integer first = null, second = null;
        for (int i : map.keySet()) {
            int rem = target - i;
            if (rem == i && map.get(i) > 1) {
                first = second = i;
                break;
            } else if (map.get(rem) != null) {
                first = i;
                second = rem;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (first != null && nums[i] == first) {
                arr[0] = i;
                first = null;

            } else if (second != null && nums[i] == second) {

                arr[1] = i;
                second = null;
            }
        }

        return arr;
    }

    private static int longestSubarray(int[] arr, int k) {
        int n = arr.length; // size of the array.

        HashMap<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            long rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);

            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);

            }
        }

        return maxLen;
    }

    private static int singleNumberAnother(int[] nums) {
        int x = 0;
        for (int i : nums) {
            if (x == 0) {
                x = i;
            } else {
                x = x ^ i;
            }
        }
        return x;
    }

    private static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.putIfAbsent(i, 0);
            map.replace(i, map.get(i) + 1);
        }
        System.out.println(map);
        int val = 0;
        for (HashMap.Entry e : map.entrySet()) {
            if ((int) e.getValue() == 1) {
                val = (int) e.getKey();
            }
        }

        return val;
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int prev = 0, next = 0, i = 0;
        while (i < nums.length) {
            if (nums[i++] == 1) {
                next++;
            } else {
                if (next > prev) {
                    prev = next;
                }
                next = 0;
            }
        }
        if (next > prev) {
            prev = next;
        }

        return prev;
    }

    private static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int length = nums.length;
        int total = (length * (length + 1)) / 2;
        return total - sum;
    }

    private static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.putIfAbsent(i, 0);
            map.replace(i, map.get(i) + 1);
        }
        for (int i : b) {
            map.putIfAbsent(i, 0);
            map.replace(i, map.get(i) + 1);
        }
        Object[] arr = map.keySet().toArray();
        int[] arr1 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr1[i] = (int) arr[i];
        }
        MergeSort(arr1, 0, arr1.length - 1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }
        return list;
    }

    private static void MergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        MergeSort(arr, si, mid);
        MergeSort(arr, mid + 1, ei);

        Merge(arr, si, mid, ei);

    }

    private static void Merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];

        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, si, temp.length);
    }

    private static boolean searchInSorted(int arr[], int k) {
        int si = 0, ei = arr.length - 1, mid = 0;
        while (si <= ei) {
            mid = si + (ei - si) / 2;
            if (arr[mid] == k) {
                return true;
            } else if (arr[mid] < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return false;
    }

    private static void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            arr[i] = 0;
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);

    }

    private static void RotateArray(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int length = nums.length;
        k = k % length;
        int j = 0;
        for (int i = length - k; i < length; i++) {
            arr[j++] = nums[i];
        }
        for (int i = 0; i < length - k; i++) {
            arr[j++] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);

    }

    private static void RemoveDuplicateFromSortedArray(int[] arr) {
        int min = arr[0] - 1, j = arr.length - 1, index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                arr[i] = min;
            }
        }
        int i = 0;
        while (j > i) {
            if (arr[i] == min) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                index = j;
                j--;
            }
            i++;
        }

        for (int k = 0; k < index; k++) {
            System.out.println(arr[k]);
        }
    }

    private static void CheckSorted(int[] arr) {
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                sorted = false;
                break;
            }
        }
        System.out.println(sorted);
    }

    private static void SecondLargest(int[] arr) {
        int max = arr[0], SecondLgst = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                SecondLgst = max;
                max = arr[i];
            }
        }
        System.out.println(SecondLgst);
    }

    private static void LargestElement(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
