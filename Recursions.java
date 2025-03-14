
public class Recursions {

    public static void main(String[] args) {
        // Print1TON(5);
        // PrintName(5);
        // PrintNto1(5);
        // int sum = SumOfNNumbers(10);
        // System.out.println(sum);
        // int fact = FactorialOfNNumbers(5);
        // System.out.println(fact);
        int[] arr = {1, 2, 3, 4, 5};
        ReverseArray(arr);
    }

    private static void ReverseArray(int[] arr) {

    }

    private static int FactorialOfNNumbers(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * FactorialOfNNumbers(n - 1);

        }
    }

    private static int SumOfNNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + SumOfNNumbers(n - 1);
    }

    private static void PrintNto1(int n) {
        if (n > 0) {
            System.out.println(n);
            PrintNto1(n - 1);
        } else {
            return;
        }
    }

    private static void Print1TON(int n) {
        if (n > 0) {
            Print1TON(n - 1);
            System.out.println(n);
        } else {
            return;
        }
    }

    private static void PrintName(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Radheshyam");
        PrintName(n - 1);
    }

}
