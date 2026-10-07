import java.io.*;
import java.util.*;

public class bai7 {
    public static List<Integer> countingSort(List<Integer> arr) {
        int[] frequency = new int[100];

        for (int num : arr) {
            frequency[num]++;
        }

        List<Integer> result = new ArrayList<>(100);
        for (int count : frequency) {
            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        scanner.close();

        List<Integer> result = countingSort(arr);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i == result.size() - 1 ? "" : " "));
        }
        System.out.println();
    }
}