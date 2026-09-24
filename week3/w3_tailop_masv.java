import java.util.Scanner;
import java.util.Stack;

public class w3_tailop_masv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;

            if (Character.isLetterOrDigit(ch)) {
                ans += ch;
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while (!st.empty() && st.peek() != '(') {
                    ans += st.pop();
                }
                if (!st.empty()) {
                    st.pop();
                }
            }

            else {
                while (!st.empty() && st.peek() != '(' && score(st.peek()) >= score(ch)) {
                    ans += st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.empty()) {
            ans += st.pop();
        }
        System.out.println(ans);
    }

    public static int score(char op) {
        if (op == '(') return 0;
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 3;
    }
}