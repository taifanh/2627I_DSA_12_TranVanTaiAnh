import java.util.Scanner;

public class bai4 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static Node lca(Node root, int v1, int v2) {
        while (root != null) {
            if (root.data > v1 && root.data > v2) {
                root = root.left;
            } else if (root.data < v1 && root.data < v2) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int n = scan.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();

            Node ans = lca(root, v1, v2);
            if (ans != null) {
                System.out.println(ans.data);
            }
        }
        scan.close();
    }
}