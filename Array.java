
public class Array {

    public static void main(String[] args) {
        // int[] arr = {1, 2, 5, 4, 8, 6, 9, 3, 2, 5};
        int[] arr = {1, 2, 3, 3, 4, 5, 6, 7, 7, 8, 9};
        // LargestElement(arr);
        // SecondLargest(arr);
        // CheckSorted(arr);
        // RemoveDuplicateFromSortedArray(arr);
        RotateArray(arr, 3);
        for (int i : arr) {
            System.out.print(i + " , ");
        }
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
