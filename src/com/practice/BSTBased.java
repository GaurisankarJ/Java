package com.practice;

import java.util.ArrayList;
import java.util.HashSet;

public class BSTBased {
    public static class BinaryNode {
        int key;
        BinaryNode left,  right;

        public BinaryNode(int key) {
            this.key = key;

            left = right = null;
        }
    }

    // Check For BST
    // https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    public static void checkForBST(BinaryNode root) {
        // In-Order Traversal Method
        checkForBSTInOrder(root);

        // MIN/MAX Window
        checkForBSTMinMax(root);

        // null Window
        checkForBSTNull(root);
    }

    public static void checkForBSTInOrder(BinaryNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        checkForBSTInOrderUtil(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }

    public static void checkForBSTInOrderUtil(BinaryNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        checkForBSTInOrderUtil(root.left, list);
        list.add(root.key);
        checkForBSTInOrderUtil(root.right, list);
    }

    public static void checkForBSTMinMax(BinaryNode root) {
        int minimum = Integer.MIN_VALUE, maximum = Integer.MAX_VALUE;

        if (checkForBSTMinMaxUtil(root, minimum, maximum)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean checkForBSTMinMaxUtil(BinaryNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.key > max || root.key < min) {
            return false;
        }

        return checkForBSTMinMaxUtil(root.left, min, root.key - 1) && checkForBSTMinMaxUtil(root.right, root.key + 1, max);
    }

    public static void checkForBSTNull(BinaryNode root) {
        if (checkForBSTNullUtil(root, null, null)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean checkForBSTNullUtil(BinaryNode root, BinaryNode left, BinaryNode right) {
        if (root == null) {
            return true;
        }

        if (left != null && root.key <= left.key) {
            return false;
        }

        if (right != null && root.key >= right.key) {
            return false;
        }

        return checkForBSTNullUtil(root.left, left, root) && checkForBSTNullUtil(root.right, root, right);
    }

    // Lowest Common Ancestor BST
    // https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
    public static void lowestCommonAncestorBST(BinaryNode root, int n, int m) {
        // n < m
        System.out.println(lowestCommonAncestorBSTUtil(root, n, m).key);
    }

    public static BinaryNode lowestCommonAncestorBSTUtil(BinaryNode root, int n, int m) {
        if (root == null) {
            return null;
        }

        if (root.key > n && root.key > m) {
            lowestCommonAncestorBSTUtil(root.left, n, m);
        }

        if (root.key < n && root.key < m) {
            lowestCommonAncestorBSTUtil(root.right, n, m);
        }

        return root;
    }

    // Search And Insert Node BST
    // https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
    public static void searchAndInsertNodeBST(BinaryNode root, int key) {
        // Search
        BinaryNode searchKey = searchNodeBSTUtil(root, key);

        // Insert
        BinaryNode insertKey = insertNodeBSTUtil(root, key);
    }

    public static BinaryNode searchNodeBSTUtil(BinaryNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return searchNodeBSTUtil(root.left, key);
        }

        return searchNodeBSTUtil(root.right, key);
    }

    public static BinaryNode insertNodeBSTUtil(BinaryNode root, int key) {
        if (root == null) {
            root = new BinaryNode(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertNodeBSTUtil(root.left, key);
        } else if (key > root.key) {
            root.right = insertNodeBSTUtil(root.right, key);
        }

        return root;
    }

    // Delete Node BST
    // https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
    public static void deleteNodeBST(BinaryNode root, int key) {
        // Delete
        BinaryNode deleteKey = deleteNodeBSTUtil(root, key);
    }

    public static BinaryNode deleteNodeBSTUtil(BinaryNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = deleteNodeBSTUtil(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNodeBSTUtil(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = inOrderSuccessorBSTUtil(root.right);
            root.right = deleteNodeBSTUtil(root.right, root.key);
        }

        return root;
    }

    public static int inOrderSuccessorBSTUtil(BinaryNode root) {
        if (root.left == null) {
            return root.key;
        }

        return inOrderSuccessorBSTUtil(root.left);
    }

    // Print Kth Largest BST
    // https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
    public static void printKthLargestBST(BinaryNode root, int k) {
        m = 0;
        // Reverse InOrder Traversal
        printKthLargestBSTUtil(root, k);
    }

    public static int m;
    public static void printKthLargestBSTUtil(BinaryNode root, int k) {
        if (root == null) {
            return;
        }

        printKthLargestBSTUtil(root.right, k);

        if (k == ++m) {
            System.out.println(root.key);
            return;
        }

        printKthLargestBSTUtil(root.left, k);
    }

    // Find Kth Smallest BST
    public static void printKthSmallestBST(BinaryNode root, int k) {
        m = 0;
        // Reverse InOrder Traversal (Recursion)
        BinaryNode kthElement = printKthSmallestBSTUtil(root, k);

        System.out.println(kthElement.key);
    }

    public static int n;
    public static BinaryNode printKthSmallestBSTUtil(BinaryNode root, int k) {
        if (root == null) {
            return null;
        }

        BinaryNode left = printKthSmallestBSTUtil(root.left, k);
        if (left != null) {
            return left;
        }

        if (k == ++n) {
            return root;
        }

        return printKthSmallestBSTUtil(root.right, k);
    }

    // Print Elements In Range BST
    // https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
    public static void printElementsInRange(BinaryNode root, int k1, int k2) {
        // InOrder Search
        printElementsInRangeUtil(root, k1, k2);
    }

    public static void printElementsInRangeUtil(BinaryNode root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (k1 < root.key) {
            printElementsInRangeUtil(root.left, k1, k2);
        }

        if (k1 <= root.key && root.key <= k2) {
            System.out.print(root.key + " ");
        }

        if (root.key < k2) {
            printElementsInRangeUtil(root.right, k1, k2);
        }
    }

    // Largest BST In Tree
    // https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
    public static void largestBSTInTree(BinaryNode root) {
        // Recursively Check If BST
        int size = largestBSTInTreeRecursion(root);

        System.out.println(size);
    }

    public static int largestBSTInTreeRecursion(BinaryNode root) {
        if (checkForBSTNullUtil(root, null, null)) {
            return sizeOfBST(root);
        } else {
            return Math.max(largestBSTInTreeRecursion(root.left), largestBSTInTreeRecursion(root.right));
        }
    }

    public static int sizeOfBST(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        return sizeOfBST(root.left) + 1 + sizeOfBST(root.right);
    }

    // Find In-Order Successor BST
    // https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
    public static void findInOrderSuccessorBST(BinaryNode root, BinaryNode node) {
        if (node.right != null) {
            System.out.println(inOrderSuccessorBSTUtil(root.right));
            return;
        }

        BinaryNode successor = null;

        while (root != null) {
            if (node.key < root.key) {
                successor = root;
                root = root.left;
            } else if (node.key > root.key) {
                root = root.right;
            } else {
                break;
            }
        }

        System.out.println(successor.key);
    }

    // Find A Pair With Given Target BST
    // https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
    public static void findPairWithGivenTargetBST(BinaryNode root, int k) {
        // Extra Space [HashSet]
        System.out.println(findPairWithGivenTargetBSTUtil(root, k));
    }

    public static HashSet<Integer> set = new HashSet<>();
    public static boolean findPairWithGivenTargetBSTUtil(BinaryNode root, int k) {
        if (root == null) {
            return false;
        }

        if (set.contains(root.key)) {
            return true;
        }
        set.add(k - root.key);

        return findPairWithGivenTargetBSTUtil(root.left, k) || findPairWithGivenTargetBSTUtil(root.right, k);
    }
}
