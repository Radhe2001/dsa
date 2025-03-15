
public class Sorting {

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 8, 90, 4, 84, 52, 27, 3};
        SelectionSort(arr);
    }

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
