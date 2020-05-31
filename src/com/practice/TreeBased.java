package com.practice;

import java.util.*;

// https://www.geeksforgeeks.org/construct-bst-given-level-order-traversal/
// https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
// https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
// https://www.geeksforgeeks.org/construct-a-bst-from-given-postorder-traversal-using-stack/

public class TreeBased {
    public static void main(String[] args) {
        // Create A Binary Tree
//        BinaryTree treeOne = createBinaryTree();

        // Tree Traversal
//        treeTraversal(treeOne);

        // Construct Binary Tree From Given Parent Array Representation
        BinaryTree treeTwo = constructBinaryTreeFromArray();

        // Insert Node In Tree
//        insertNodeIntoTree(treeTwo);

        // Delete A Tree
//        deleteTree(treeTwo);

        // Find Size Of Tree
//        findSizeOfTree(treeTwo);

        // Binary Tree Array Implementation
//        implementBinaryTreeArray();

        // Print Left View of a Binary Tree
//        printLeftViewOfBinaryTree(treeTwo);

        // Print All Nodes Without Sibling
//        printAllNodesWithoutSiblings(treeTwo);

        // Determine If Two Trees Are Identical
//        determineTwoTreesIdentical(treeTwo, treeTwo);

        // Mirror Tree
//        mirrorTree(treeTwo);

        // Height Of A Binary Tree
//        heightOfTree(treeTwo);

        // Vertical Traversal Of A Binary Tree
//        verticalTraversalOfTree(treeTwo);

        // Check If Sum Tree
//        checkIfSumTree(treeTwo);

        // Diameter Of A Binary Tree
//        findDiameterOfTree(treeTwo);

        // Root To Leaf Path With Given Sum
//        rootToLeafPathWithGivenSum(treeTwo);

        // Level Order Traversal In Spiral Form
        levelOrderTraversalInSpiralForm(treeTwo);
    }

    // Create A Binary Tree
    // https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
    // https://www.geeksforgeeks.org/binary-tree-set-3-types-of-binary-tree/
    public static BinaryTree createBinaryTree() {
        BinaryTree tree = new BinaryTree(1);
        tree.root.left = new BinaryNode(2);
        tree.root.left.left = new BinaryNode(4);
        tree.root.left.right = new BinaryNode(5);
        tree.root.right = new BinaryNode(3);
        tree.root.right.left = new BinaryNode(6);
        tree.root.right.right = new BinaryNode(7);

        return tree;
    }

    public static class BinaryNode {
        int key;
        BinaryNode left,  right;

        public BinaryNode(int key) {
            this.key = key;

            left = right = null;
        }
    }

    public static class BinaryTree {
        BinaryNode root;

        public BinaryTree() {
            root = null;
        }

        public BinaryTree(int key) {
            root = new BinaryNode(key);
        }
    }

    // Tree Traversal
    // https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
    // https://www.geeksforgeeks.org/level-order-tree-traversal/
    // https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
    public static void treeTraversal(BinaryTree tree) {
        /**
         * Depth First Traversals:
         * (a) In-order (Left, Root, Right)
         * (b) Pre-order (Root, Left, Right)
         * (c) Post-order (Left, Right, Root)
         *
         * Breadth First Traversal:
         * (a) Level Order
         */
        TreeTraversal traversal = new TreeTraversal();

        System.out.println("IN-ORDER : ");
        traversal.inOrderTraversal(tree.root);

        System.out.println("\nPRE-ORDER : ");
        traversal.preOrderTraversal(tree.root);

        System.out.println("\nPOST-ORDER : ");
        traversal.postOrderTraversal(tree.root);

        System.out.println("\nLEVEL-ORDER : ");
        traversal.levelOrderTraversal(tree.root);

        System.out.println("\nMORRIS IN-ORDER : ");
        traversal.inOrderMorrisTraversal(tree.root);
    }

    public static class TreeTraversal extends BinaryTree {
        public void inOrderTraversal (BinaryNode root) {
                if (root == null) {
                    return;
                }

                inOrderTraversal(root.left);

                System.out.print(root.key + " ");

                inOrderTraversal(root.right);
            }

        public void preOrderTraversal (BinaryNode root) {
             if (root == null) {
                 return;
             }

             System.out.print(root.key + " ");

             preOrderTraversal(root.left);

             preOrderTraversal(root.right);
         }

        public void postOrderTraversal (BinaryNode root) {
             if (root == null) {
                 return;
             }

             postOrderTraversal(root.left);

             postOrderTraversal(root.right);

             System.out.print(root.key + " ");
         }

        public void levelOrderTraversal (BinaryNode root) {
             if (root == null) {
                 return;
             }

             Queue<BinaryNode> queue = new LinkedList<>();

             queue.add(root);

             while (!queue.isEmpty()) {
                 BinaryNode node = queue.poll();

                 System.out.print(node.key + " ");

                 if (node.left != null) {
                     queue.add(node.left);
                 }

                 if (node.right != null) {
                     queue.add(node.right);
                 }
             }
         }

        public void inOrderMorrisTraversal (BinaryNode root) {
            BinaryNode current, predecessor;

            if (root == null) {
                return;
            }

            current = root;
            while (current != null) {
                if (current.left == null) {
                    System.out.print(current.key + " ");
                    current = current.right;
                } else {
                    predecessor = current.left;
                    while (predecessor.right != null && predecessor.right != current) {
                        predecessor = predecessor.right;
                    }

                    if (predecessor.right == null) {
                        predecessor.right = current;
                        current = current.left;
                    } else {
                        predecessor.right = null;
                        System.out.print(current.key + " ");
                        current = current.right;
                    }
                }
            }
        }
    }

    // Construct Binary Tree From Given Parent Array Representation
    // https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
    public static BinaryTree constructBinaryTreeFromArray() {
        /**
         *           5
         *         /  \
         *        1    2
         *       /    / \
         *      0    3   4
         *          /
         *         6
         */
        int[] parent = { 1, 5, 5, 2, 2, -1, 3 };
        int n = parent.length;

        BinaryNode[] created = new BinaryNode[n];
        for (int i = 0; i < n; i++) {
            created[i] = null;
        }

        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < n; i++) {
            constructBinaryTreeFromArrayUtil(parent, i, created, tree);
        }

//        TreeTraversal traversal = new TreeTraversal();
//        traversal.levelOrderTraversal(tree.root);

        return tree;
    }

    public static void constructBinaryTreeFromArrayUtil(int[] parent, int i, BinaryNode[] created, BinaryTree tree) {
        if (created[i] != null) {
            return;
        }

        created[i] = new BinaryNode(i);

        if (parent[i] == -1) {
            tree.root = created[i];
            return;
        }

        if (created[parent[i]] == null) {
            constructBinaryTreeFromArrayUtil(parent, parent[i], created, tree);
        }

        BinaryNode parentNode = created[parent[i]];

        if (parentNode.left == null) {
            parentNode.left = created[i];
        } else {
            parentNode.right = created[i];
        }
    }

    // Insert Node Into Tree [Level-Order]
    // https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
    public static void insertNodeIntoTree(BinaryTree tree) {
        int key = 12;

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(tree.root);

        while (!queue.isEmpty()) {
            BinaryNode node = queue.poll();

            if (node.left == null) {
                node.left = new BinaryNode(key);
                return;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new BinaryNode(key);
                return;
            } else {
                queue.add(node.right);
            }
        }
    }

    // Delete A Tree
    // https://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/
    public static void deleteTree(BinaryTree tree) {
        // Post-order Traversal
        // Java Has Automatic Garbage Collection
        tree.root = null;
    }

    // Find Size Of Tree
    // https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
    public static void findSizeOfTree(BinaryTree tree) {
        // Recursive Function
        System.out.println(findSizeOfTreeUtil(tree.root));
    }

    public static int findSizeOfTreeUtil(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        return findSizeOfTreeUtil(root.left) + 1 + findSizeOfTreeUtil(root.right);
    }

    // Binary Tree Array Implementation
    // https://www.geeksforgeeks.org/binary-tree-array-implementation/
    public static void implementBinaryTreeArray() {
        /**
         *  root = i
         *  left = (2 * i) + 1
         *  right = (2 * i) + 2
         */
        BinaryTreeArray tree = new BinaryTreeArray();

        tree.setRoot("A");
        tree.setLeft("B", 0);
        tree.setRight("C", 0);
        tree.setLeft("D", 1);
        tree.setRight("E", 2);
        tree.setRight("F", 6);
        tree.printTree();
    }

    public static class BinaryTreeArray {
        private String[] tree;
        private int root, size;

        public BinaryTreeArray() {
            tree = new String[1000];
            root = 0;
            size = 0;
        }

        public void setRoot(String key) {
            tree[root] = key;
            size = 1;
        }

        public void setLeft(String key, int root) {
            if (tree[root] == null) {
                System.out.println("No Parent Found!");
                return;
            }

            int index = (root * 2) + 1;

            if (index + 1 > size) {
                size = index + 1;
            }

            tree[index] = key;
        }

        public void setRight(String key, int root) {
            if (tree[root] == null) {
                System.out.println("No Parent Found!");
                return;
            }

            int index = (root * 2) + 2;

            if (index + 1 > size) {
                size = index + 1;
            }

            tree[index] = key;
        }

        public void printTree() {
            for (int i = 0; i < size; i++) {
                if (tree[i] == null) {
                    System.out.print(" - ");
                } else {
                    System.out.print(tree[i] + " ");
                }
            }
        }
    }

    // Print Left View of a Binary Tree
    // https://www.geeksforgeeks.org/print-left-view-binary-tree/
    public static void printLeftViewOfBinaryTree(BinaryTree tree) {
        max = -1;
        printLeftViewOfBinaryTreeUtil(tree.root, 0);
    }

    public static int max;
    public static void printLeftViewOfBinaryTreeUtil(BinaryNode root, int level) {
        if (root == null) {
            return;
        }

        if (max < level) {
            System.out.print(root.key + " ");
            max = level;
        }

        printLeftViewOfBinaryTreeUtil(root.left, level + 1);
        printLeftViewOfBinaryTreeUtil(root.right, level + 1);
    }

    // Print All Nodes Without Sibling
    // https://www.geeksforgeeks.org/print-nodes-dont-sibling-binary-tree/
    public static void printAllNodesWithoutSiblings(BinaryTree tree) {
        flag = false;
        printAllNodesWithoutSiblingsUtil(tree.root);

        if (flag == false) {
            System.out.print(-1);
        }
    }

    public static boolean flag;
    public static void printAllNodesWithoutSiblingsUtil(BinaryNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            printAllNodesWithoutSiblingsUtil(node.left);
            printAllNodesWithoutSiblingsUtil(node.right);
        } else if (node.right != null) {
            System.out.print(node.right.key + " ");
            flag = true;
            printAllNodesWithoutSiblingsUtil(node.right);
        } else if (node.left != null) {
            System.out.print(node.left.key + " ");
            flag = true;
            printAllNodesWithoutSiblingsUtil(node.left);
        }
    }

    // Determine If Two Trees Are Identical
    // https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
    public static void determineTwoTreesIdentical(BinaryTree treeOne, BinaryTree treeTwo) {
        if (determineTwoTreesIdenticalUtil(treeOne.root, treeTwo.root)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean determineTwoTreesIdenticalUtil(BinaryNode nodeOne, BinaryNode nodeTwo) {
        if (nodeOne == null && nodeTwo == null) {
            return true;
        }

        if (nodeOne != null && nodeTwo != null) {
            return (nodeOne.key == nodeTwo.key)
                    && determineTwoTreesIdenticalUtil(nodeOne.left, nodeTwo.left)
                    && determineTwoTreesIdenticalUtil(nodeOne.right, nodeTwo.right);
        }

        return false;
    }

    // Mirror Of A Tree
    // https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
    public static void mirrorTree(BinaryTree tree) {
        TreeTraversal tr = new TreeTraversal();

        tr.levelOrderTraversal(tree.root);

        mirrorTreeUtil(tree.root);

        System.out.println();
        tr.levelOrderTraversal(tree.root);
    }

    public static void mirrorTreeUtil(BinaryNode node) {
        if (node == null) {
            return;
        }

        mirrorTreeUtil(node.left);
        mirrorTreeUtil(node.right);

        BinaryNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    // Height Of A Binary Tree
    // https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
    public static void heightOfTree(BinaryTree tree) {
        // Recursive
        System.out.println(heightOfTreeUtil(tree.root));
    }

    public static int heightOfTreeUtil(BinaryNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = heightOfTreeUtil(node.left);
        int rightHeight = heightOfTreeUtil(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Vertical Traversal Of A Binary Tree
    // https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
    // https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
    // https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
    public static void verticalTraversalOfTree(BinaryTree tree) {
        VerticalTraversal traversal = new VerticalTraversal();
        // Min Max Method
        traversal.verticalTraversalMinMax(tree.root);

        System.out.println();
        // TreeMap Method
        traversal.verticalTraversalTreeMap(tree.root);
        /**
         *  INPUT -
         *                 1
         *              /    \
         *            2       3
         *           / \    /  \
         *         4    5  6    7
         *                  \  / \
         *                  8 10  9
         *                      \
         *                      11
         *                        \
         *                         12
         *  OUTPUT -
         *  -2 : 2
         *  -1 : 1 5 6
         *   0 : 3 8 10
         *   1 : 7 11
         *   2 : 12 9
         */

        System.out.println();
        // Level Order Method
        traversal.verticalTraversalLevelOrder(tree.root);
    }

    public static class VerticalTraversal extends TreeTraversal {
        public static void verticalTraversalMinMax(BinaryNode root) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            verticalTraversalMinMaxUtil(root, 0);

            for (int i = min; i <= max; i++) {
                printVerticalMinMax(root, i, 0);
            }
        }

        private static int min, max;
        private static void verticalTraversalMinMaxUtil(BinaryNode root, int i) {
            if (root == null) {
                return;
            }

            if (min > i) {
                min = i;
            } else if (max < i){
                max = i;
            }

            verticalTraversalMinMaxUtil(root.left, i - 1);
            verticalTraversalMinMaxUtil(root.right, i + 1);
        }

        private static void printVerticalMinMax(BinaryNode root, int level, int i) {
            if (root == null) {
                return;
            }

            if (level == i) {
                System.out.print(root.key + " ");
            }

            printVerticalMinMax(root.left, level, i - 1);
            printVerticalMinMax(root.right, level, i + 1);
        }

        public static void verticalTraversalTreeMap(BinaryNode root) {
            map = new TreeMap<>();

            verticalTraversalTreeMapUtil(root, 0);

            map.forEach((key, value) -> value.forEach(item -> System.out.print(item + " ")));
        }

        private static TreeMap<Integer, ArrayList<Integer>> map;
        public static void verticalTraversalTreeMapUtil(BinaryNode root, int i) {
            if (root == null) {
                return;
            }

            if (map.containsKey(i)) {
                ArrayList<Integer> list = map.get(i);
                list.add(root.key);
                map.replace(i, list);
            } else {
                map.put(i, new ArrayList<>(Arrays.asList(root.key)));
            }

            verticalTraversalTreeMapUtil(root.left, i - 1);
            verticalTraversalTreeMapUtil(root.right, i + 1);
        }

        public static void verticalTraversalLevelOrder(BinaryNode root) {
            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
            Queue<QueueNode> queue = new LinkedList<>();

            queue.add(new QueueNode(root, 0));

            while (!queue.isEmpty()) {
                QueueNode qNode = queue.poll();

                BinaryNode node = qNode.node;
                int level = qNode.level;

                if (map.containsKey(level)) {
                    ArrayList<Integer> list = map.get(level);
                    list.add(node.key);
                    map.replace(level, list);
                } else {
                    map.put(level, new ArrayList<>(Arrays.asList(node.key)));
                }

                if (node.left != null) {
                    queue.add(new QueueNode(node.left, level - 1));
                }

                if (node.right != null) {
                    queue.add(new QueueNode(node.right, level + 1));
                }
            }

            map.forEach((key, value) -> value.forEach(item -> System.out.print(item + " ")));
        }

        public static class QueueNode {
            BinaryNode node;
            int level;

            QueueNode(BinaryNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
    }

    // Check If Sum Tree
    // https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
    public static void checkIfSumTree(BinaryTree tree) {
        // O(n^2)
        System.out.println(checkIfSumTreeMethodOne(tree.root));

        // O(n)
        System.out.println(checkIfSumTreeMethodTwo(tree.root));
    }

    public static boolean checkIfSumTreeMethodOne(BinaryNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftSubTreeSum = checkIfSumTreeFindSumUtil(root.left);
        int rightSubTreeSum = checkIfSumTreeFindSumUtil(root.right);

        return (leftSubTreeSum + rightSubTreeSum == root.key)
                && checkIfSumTreeMethodOne(root.left)
                && checkIfSumTreeMethodOne(root.right);
    }

    public static int checkIfSumTreeFindSumUtil(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        return checkIfSumTreeFindSumUtil(root.left) + root.key + checkIfSumTreeFindSumUtil(root.right);
    }

    public static boolean checkIfSumTreeMethodTwo(BinaryNode root) {
        if (root == null || checkIfSumTreeCheckLeafUtil(root)) {
            return true;
        }

        int leftSubTreeSum = -1, rightSubTreeSum = -1;
        if (root.left == null) {
            leftSubTreeSum = 0;
        } else if (checkIfSumTreeCheckLeafUtil(root.left)) {
            leftSubTreeSum = root.left.key;
        } else {
            leftSubTreeSum = 2 * root.left.key;
        }

        if (root.right == null) {
            rightSubTreeSum = 0;
        } else if (checkIfSumTreeCheckLeafUtil(root.right)) {
            rightSubTreeSum = root.right.key;
        } else {
            rightSubTreeSum = 2 * root.right.key;
        }

        return (leftSubTreeSum + rightSubTreeSum == root.key)
                && checkIfSumTreeMethodTwo(root.left)
                && checkIfSumTreeMethodTwo(root.right);
    }

    public static boolean checkIfSumTreeCheckLeafUtil(BinaryNode root) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return true;
        }

        return false;
    }

    // Diameter Of A Binary Tree
    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    // https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
    // https://www.geeksforgeeks.org/diameter-tree-using-dfs/
    public static void findDiameterOfTree(BinaryTree tree) {
        // Tracking Height Method A
        System.out.println(findDiameterOfTreeMethodA(tree.root));

        // Tracking Height Method B
        System.out.println(findDiameterOfTreeMethodB(tree.root, new Height()));

        // Tracking Height Method C
        maxDiameter = Integer.MIN_VALUE;
        findDiameterOfTreeMethodC(tree.root);
        System.out.println(maxDiameter);
    }

    public static int findDiameterOfTreeMethodA(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findDiameterOfTreeMethodAHeightUtil(root.left);
        int rightHeight = findDiameterOfTreeMethodAHeightUtil(root.right);

        int leftDiameter = findDiameterOfTreeMethodA(root.left);
        int rightDiameter = findDiameterOfTreeMethodA(root.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static int findDiameterOfTreeMethodAHeightUtil(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(findDiameterOfTreeMethodAHeightUtil(root.left), findDiameterOfTreeMethodAHeightUtil(root.right)) + 1;
    }

    public static class Height {
        int height;
    }
    public static int findDiameterOfTreeMethodB(BinaryNode root, Height h) {
        if (root == null) {
            h.height = 0;
            return 0;
        }

        Height leftHeight = new Height(), rightHeight = new Height();

        int leftDiameter = findDiameterOfTreeMethodB(root.left, leftHeight);
        int rightDiameter = findDiameterOfTreeMethodB(root.right, rightHeight);

        h.height = Math.max(leftHeight.height, rightHeight.height) + 1;

        return Math.max(leftHeight.height + rightHeight.height + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static int maxDiameter;
    public static int findDiameterOfTreeMethodC(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findDiameterOfTreeMethodC(root.left);
        int rightHeight = findDiameterOfTreeMethodC(root.right);

        if (maxDiameter < leftHeight + rightHeight + 1) {
            maxDiameter =  leftHeight + rightHeight + 1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Root To Leaf Path With Given Sum
    // https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
    public static void rootToLeafPathWithGivenSum(BinaryTree tree) {
        int sum = 6;

        System.out.println(rootToLeafPathWithGivenSumUtil(tree.root, sum));
    }

    public static boolean rootToLeafPathWithGivenSumUtil(BinaryNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }

        return rootToLeafPathWithGivenSumUtil(root.left, sum - root.key)
                || rootToLeafPathWithGivenSumUtil(root.right, sum - root.key);
    }

    // Level Order Traversal In Spiral Form
    // https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
    public static void levelOrderTraversalInSpiralForm(BinaryTree tree) {
        // Recursive [Worst Case O(n^2)]
        levelOrderTraversalInSpiralFormRecursive(tree.root);

        System.out.println();
        // Iterative [2 Stacks]
        levelOrderTraversalInSpiralFormIterative(tree.root);
    }

    public static void levelOrderTraversalInSpiralFormRecursive(BinaryNode root) {
        int h = heightOfTreeUtil(root);

        boolean flag = true;
        for (int i = 1; i <= h; i++) {
            levelOrderTraversalInSpiralFormRecursiveUtil(root, 1, i, flag);

            flag = !flag;
        }
    }

    public static void levelOrderTraversalInSpiralFormRecursiveUtil(BinaryNode node, int i, int level, boolean flag) {
        if (node == null) {
            return;
        }

        if (i == level) {
            System.out.print(node.key + " ");
            return;
        } else {
            if (flag) {
                levelOrderTraversalInSpiralFormRecursiveUtil(node.left, i + 1, level, flag);
                levelOrderTraversalInSpiralFormRecursiveUtil(node.right, i + 1, level, flag);
            } else {
                levelOrderTraversalInSpiralFormRecursiveUtil(node.right, i + 1, level, flag);
                levelOrderTraversalInSpiralFormRecursiveUtil(node.left, i + 1, level, flag);
            }
        }
    }

    public static void levelOrderTraversalInSpiralFormIterative(BinaryNode root) {
        Stack<BinaryNode> leftStack = new Stack<>(), rightStack = new Stack<>();

        leftStack.push(root);

        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                BinaryNode node = leftStack.pop();
                System.out.print(node.key + " ");

                if (node.left != null) {
                    rightStack.push(node.left);
                }

                if (node.right != null) {
                    rightStack.push(node.right);
                }
            }

            while (!rightStack.isEmpty()) {
                BinaryNode node = rightStack.pop();
                System.out.print(node.key + " ");

                if (node.right != null) {
                    leftStack.push(node.right);
                }

                if (node.left != null) {
                    leftStack.push(node.left);
                }
            }
        }
    }
}

