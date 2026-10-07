import java.util.Arrays;
import java.util.Scanner;

public class w4_25021642 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] citations = new int[n];
        for (int i = 0; i < n; i++) {
            citations[i] = sc.nextInt();
        }

        Arrays.sort(citations);

        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            int count = n - i;
            if (citations[i] >= count) {
                hIndex = count;
                break;
            }
        }

        System.out.println(hIndex);
    }
}