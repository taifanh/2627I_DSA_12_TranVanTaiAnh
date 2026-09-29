import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class QueueusingTwoStacks {
    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int q = sc.nextInt();

        Stack<Integer> stackIn = new Stack<>();
        Stack<Integer> stackOut = new Stack<>();
        StringBuilder out = new StringBuilder();

        while(q-->0) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                stackIn.push(x);
            } else if (type == 2) {
                transfer(stackIn, stackOut);
                if (!stackOut.isEmpty()) {
                    stackOut.pop();
                }
            } else if (type == 3) {
                transfer(stackIn, stackOut);
                if (!stackOut.isEmpty()) {
                    out.append(stackOut.peek()).append("\n");
                }
            }
        }

        System.out.print(out);
    }

    private static void transfer(Stack<Integer> stackIn, Stack<Integer> stackOut) {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}

class FastIO {
    BufferedReader br;
    StringTokenizer st;

    FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            if (line != null) {
                st = new StringTokenizer(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        String token = next();
        if (token == null) return 0;
        return Integer.parseInt(token);
    }
}
