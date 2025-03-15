
public class Recursions {

    public static void main(String[] args) {
        // Print1TON(5);
        // PrintName(5);
        // PrintNto1(5);
        // int sum = SumOfNNumbers(10);
        // System.out.println(sum);
        // int fact = FactorialOfNNumbers(5);
        // System.out.println(fact);
        // int[] arr = {1, 2, 3, 4, 5};
        // int[] newArr = ReverseArray(arr, 0);
        // for (int i = 0; i < newArr.length; i++) {
        //     System.out.println(newArr[i]);
        // }

        // String pal = "raadbcdaar";
        // boolean res = CheckPalindrome(pal, 0);
        // System.out.println(res);
        Fibbonacci(7, 0, 1);
    }

    private static void Fibbonacci(int n, int prev, int next) {
        if (n == 0) {
            return;
        } else {
            System.err.println(prev);
            Fibbonacci(n - 1, next, prev + next);

        }
    }

    private static boolean CheckPalindrome(String pal, int i) {
        int start = i, end = pal.length() - i - 1;
        if (start > end) {
            return true;
        } else {
            if (pal.charAt(start) == pal.charAt(end)) {
                return CheckPalindrome(pal, i + 1);
            } else {
                return false;
            }
        }
    }

    private static int[] ReverseArray(int[] arr, int i) {

        int start = i, end = arr.length - i - 1;
        if (start > end) {
            return arr;
        }
        int c = arr[start];
        arr[start] = arr[end];
        arr[end] = c;
        return ReverseArray(arr, i + 1);
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
