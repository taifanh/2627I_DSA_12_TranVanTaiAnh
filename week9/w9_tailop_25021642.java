import java.util.HashMap;
import java.util.Map;

public class w9_tailop_25021642 {

    public static class Node {
        int id;
        String info;
        int firstChild;
        int nextSibling;

        public Node(int id, String info, int firstChild, int nextSibling) {
            this.id = id;
            this.info = info;
            this.firstChild = firstChild;
            this.nextSibling = nextSibling;
        }

        @Override
        public String toString() {
            return "Node{id=" + id + ", info='" + info + "', firstChild=" + firstChild + ", nextSibling=" + nextSibling + "}";
        }
    }

    private int rootId;
    private Map<Integer, Node> nodeMap;

    public w9_tailop_25021642() {
        this.rootId = -1;
        this.nodeMap = new HashMap<>();
    }

    public void addNode(int id, String info, int firstChild, int nextSibling) {
        Node newNode = new Node(id, info, firstChild, nextSibling);
        nodeMap.put(id, newNode);

        if (rootId == -1) {
            rootId = id;
        }
    }

    public void setRootId(int rootId) {
        this.rootId = rootId;
    }

    public int findParent(int targetId) {
        if (rootId == -1 || rootId == targetId) {
            return -1;
        }
        return findParentRecursive(rootId, targetId);
    }

    private int findParentRecursive(int currentId, int targetId) {
        if (currentId == -1) return -1;

        Node current = nodeMap.get(currentId);
        if (current == null) return -1;

        int childId = current.firstChild;
        while (childId != -1) {
            if (childId == targetId) {
                return currentId;
            }
            int found = findParentRecursive(childId, targetId);
            if (found != -1) return found;

            childId = nodeMap.get(childId).nextSibling;
        }

        return -1;
    }

    public int findFirstChild(int id) {
        Node node = nodeMap.get(id);
        if (node == null) return -1;
        return node.firstChild;
    }

    public int findNextSibling(int id) {
        Node node = nodeMap.get(id);
        if (node == null) return -1;
        return node.nextSibling;
    }

    public void printTree() {
        if (rootId == -1) return;
        printTreeRecursive(rootId, 0);
    }

    private void printTreeRecursive(int nodeId, int level) {
        if (nodeId == -1) return;

        Node node = nodeMap.get(nodeId);
        if (node == null) return;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("   ");
        }
        sb.append("- [ID: ").append(node.id).append(", Info: ").append(node.info).append("]");
        System.out.println(sb.toString());

        printTreeRecursive(node.firstChild, level + 1);
        printTreeRecursive(node.nextSibling, level);
    }

    public static void main(String[] args) {
        w9_tailop_25021642 tree = new w9_tailop_25021642();

        tree.addNode(1, "A", 2, -1);
        tree.addNode(2, "B", 5, 3);
        tree.addNode(3, "C", -1, 4);
        tree.addNode(4, "D", 7, -1);
        tree.addNode(5, "E", -1, 6);
        tree.addNode(6, "F", -1, -1);
        tree.addNode(7, "G", -1, -1);

        tree.setRootId(1);

        tree.printTree();

        System.out.println(tree.findFirstChild(1));
        System.out.println(tree.findFirstChild(2));
        System.out.println(tree.findNextSibling(2));
        System.out.println(tree.findParent(5));
        System.out.println(tree.findParent(7));
    }
}