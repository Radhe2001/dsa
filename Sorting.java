
public class Sorting {

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 8, 90, 4, 84, 52, 27, 3};
        // SelectionSort(arr);
        // BubbleSort(arr);
        // InsertionSort(arr);
        // MergeSort(arr, 0, arr.length - 1);
        QuickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    private static void QuickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = Partition(arr, low, high);
        QuickSort(arr, low, index - 1);
        QuickSort(arr, index + 1, high);
    }

    private static int Partition(int[] arr, int low, int high) {

        int i = low + 1, j = high, pivot = low;
        while (i <= j) {
            while (i <= j && arr[i] <= arr[pivot]) {
                i++;
            }
            while (i <= j && arr[j] >= arr[pivot]) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }

        }
        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        return j;

    }

    // TODO: Merge Sort
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

    // TODO: Insertion Sort
    private static void InsertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    //TODO: Bubble Sort
    private static void BubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    // TODO: Selection Sort
    private static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
