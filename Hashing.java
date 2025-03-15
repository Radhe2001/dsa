
import java.util.HashMap;

public class Hashing {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 2, 5, 1, 6, 8, 8};
        // NumberOfFrequency(arr);
        HighestLowestFrequecy(arr);
    }

    private static void HighestLowestFrequecy(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.putIfAbsent(i, 0);
            map.replace(i, map.get(i) + 1);
        }

        int minKey = 0, minValue = 0, maxKey = 0, maxValue = 0;
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (minValue == 0) {
                minKey = key;
                minValue = value;
            }
            if (value > maxValue) {
                maxKey = key;
                maxValue = value;

            }

            if (value < minValue) {
                minValue = value;
                minKey = key;
            }
        }

        System.out.println("minkey  : " + minKey + " , minvalue : " + minValue);
        System.out.println("maxkey  : " + maxKey + " , maxvalue : " + maxValue);
    }

    private static void NumberOfFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.putIfAbsent(i, 0);
            map.replace(i, map.get(i) + 1);
        }
        System.out.println(map);
    }
}
