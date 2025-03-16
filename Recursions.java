
import java.util.ArrayList;

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
        //int i = fib(2);
        // Fibbonacci(7, 0, 1);
        // ArrayList<Long> list = factorialNumbers(8);
        Reverse(12345);
    }

    private static void Reverse(int n) {
        String str = Integer.toString(n);
        String s = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            s = s + Character.toString(str.charAt(i));
        }

        System.out.println(s);
    }

    private static ArrayList<Long> factorialNumbers(long n) {
        long fact = 1;
        int i = 1;
        ArrayList<Long> list = new ArrayList<>();
        while (fact <= n) {
            fact *= i;
            if (fact <= n) {
                list.add(fact);
            }
            i++;
        }
        return list;
    }

    private static int fib(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        Fibbonacci(3, 0, 1, list);
        int sum1 = 0, sum2 = 0;
        int size = list.size() - 1;
        for (int i = 0; i < size - 1; i++) {
            int item = list.get(i);
            if (i < size - 1) {
                sum2 += item;
            }
            sum1 += item;

        }
        return sum1 + sum2;
    }

    private static void Fibbonacci(int n, int prev, int next, ArrayList<Integer> list) {
        if (n <= 0) {
            return;
        } else {
            list.add(prev);
            Fibbonacci(n - 1, next, prev + next, list);

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
