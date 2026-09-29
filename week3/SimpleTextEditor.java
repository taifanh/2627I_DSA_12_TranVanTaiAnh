import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
    int type;
    String data;

    Pair(int type, String data) {
        this.type = type;
        this.data = data;
    }
}

public class SimpleTextEditor {
    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int q = sc.nextInt();

        StringBuilder S = new StringBuilder();
        Stack<Pair> history = new Stack<>();
        StringBuilder out = new StringBuilder();

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                String W = sc.next();
                history.push(new Pair(1, String.valueOf(W.length())));
                S.append(W);
            } else if (type == 2) {
                int k = sc.nextInt();

                String deletedStr = S.substring(S.length() - k);
                history.push(new Pair(2, deletedStr));
                S.delete(S.length() - k, S.length());
            } else if (type == 3) {
                int k = sc.nextInt();
                out.append(S.charAt(k - 1)).append("\n");
            } else if (type == 4) {
                if (!history.isEmpty()) {
                    Pair lastOp = history.pop();

                    if (lastOp.type == 1) {
                        int len = Integer.parseInt(lastOp.data);
                        S.delete(S.length() - len, S.length());
                    } else if (lastOp.type == 2) {
                        S.append(lastOp.data);
                    }
                }
            }
        }

        System.out.print(out);
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
