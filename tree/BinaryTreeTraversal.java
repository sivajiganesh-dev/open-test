import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryTreeTraversal {

    private static int minimumTime = 0;

    public static void main(String[] args) {

        Node targetNode;

        if (args.length > 0 && args[0].equals("1")) {
            Scanner scanner = new Scanner(System.in);

            int count = scanner.nextInt(); //Total no of nodes
            scanner.nextLine();

            targetNode = getLeafFromInput(count, scanner);
        } else {
            targetNode = getLeafFromLocal();
        }

        findMinBurnTime(targetNode);
        System.out.println(minimumTime);
    }

    /**
     * Get Leaf from console input
     *
     * @param count   no of nodes
     * @param scanner input scanner hooked to System.in
     * @return leaf node that caught fire
     */
    public static Node getLeafFromInput(int count, Scanner scanner) {
        //To Simplify building full binary tree, storing node references in map
        Map<Integer, Node> nodeReferences = new HashMap<>();

        for (int i = 1; i < count; i++) {
            String input = scanner.nextLine().trim();
            String[] values = input.split("\\s+");

            //As input is in the format of [parent, child]
            int parent = Integer.parseInt(values[0]);
            int child = Integer.parseInt(values[1]);

            //at initial value of iterator count starts root node
            if (i == 1) {
                Node root = new Node(parent, null);
                nodeReferences.put(parent, root);
            }

            Node node = nodeReferences.get(parent);

            //Binary tree principle, check for parent-child difference
            if (child > parent) {
                node.left = new Node(child, node);
                nodeReferences.put(child, node.left);
            } else {
                node.right = new Node(child, node);
                nodeReferences.put(child, node.right);
            }
        }

        //Return target node specified by the input
        int targetValue = scanner.nextInt();
        return nodeReferences.get(targetValue);
    }

    /**
     * Get leaf node from hard-coded full binary tree
     *
     * @return leaf node that caught fire (assumed)
     */
    public static Node getLeafFromLocal() {
        Node root = new Node(1, null);

        root.left = new Node(2, root);
        root.right = new Node(3, root);

        root.left.left = new Node(4, root.left);
        root.left.right = new Node(5, root.left);

        root.left.right.left = new Node(7, root.left.right);
        root.left.right.right = new Node(8, root.left.right);

        root.right.left = new Node(6, root.right);
        root.right.left.left = new Node(9, root.right.left);
        root.right.left.left.left = new Node(10, root.right.left.left);

        return root.left.right.right;
    }

    public static void findMinBurnTime(Node node) {
        if (node.left != null && !node.left.burned) {
            node.left.setOnFire(node.count);
            findMinBurnTime(node.left);
        }

        if (node.right != null && !node.right.burned) {
            node.right.setOnFire(node.count);
            findMinBurnTime(node.right);
        }

        if (node.parent != null && !node.parent.burned) {
            node.parent.setOnFire(node.count);
            findMinBurnTime(node.parent);
        }

        minimumTime = Math.max(minimumTime, node.count);
    }

    static class Node {
        int value;
        boolean burned = false;
        int count = 0;

        Node right;
        Node left;
        Node parent;

        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.right = null;
            this.left = null;
        }

        void setOnFire(int count) {
            this.burned = true;
            this.count = ++count;
        }
    }
}
