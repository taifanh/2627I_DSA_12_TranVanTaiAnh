import java.util.Scanner;

public class w10_tailop_25021642 {
    public static class Pair {
        public int min;
        public int max;
    }

    public static Pair findMinMax(int[] arr, int low, int high) {
        Pair result = new Pair();
        Pair left;
        Pair right;

        if (low == high) {
            result.max = arr[low];
            result.min = arr[low];
            return result;
        }

        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                result.max = arr[low];
                result.min = arr[high];
            } else {
                result.max = arr[high];
                result.min = arr[low];
            }
            return result;
        }

        int mid = low + (high - low) / 2;
        left = findMinMax(arr, low, mid);
        right = findMinMax(arr, mid + 1, high);

        result.min = Math.min(left.min, right.min);
        result.max = Math.max(left.max, right.max);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Pair result = findMinMax(arr, 0, arr.length - 1);

        System.out.println("Giá trị nhỏ nhất: " + result.min);
        System.out.println("Giá trị lớn nhất: " + result.max);

        scanner.close();
    }
}
