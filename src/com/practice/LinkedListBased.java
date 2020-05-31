package com.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListBased {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Detect Loop In LinkedList
    // https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
    public static void detectLoopLinkedList(Node head) {
        // HashSet
        if (detectLoopInLinkedListHashSet(head)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        // Floyd's Algorithm
        if (detectLoopInLinkedListFloyd(head)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean detectLoopInLinkedListHashSet(Node head) {
        Set<Node> hashSet = new HashSet<>();

        while (head != null) {
            if (hashSet.contains(head)) {

                return true;
            }

            hashSet.add(head);

            head = head.next;
        }

        return false;
    }

    public static boolean detectLoopInLinkedListFloyd(Node head) {
        Node turtle = head, hare = head;

        while (turtle != null && hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;

            if (turtle == hare) {
                return true;
            }
        }

        return false;
    }

    // Reverse A LinkedList
    // https://www.geeksforgeeks.org/reverse-a-linked-list/
    public static void reverseLinkedList(Node head) {
        Node newHeadIterative, newHeadRecursive;
        // Iterative
        newHeadIterative = reverseLinkedListIterative(head);

        // Recursive
        newHeadRecursive = reverseLinkedListRecursive(null, head);
    }

    public static Node reverseLinkedListIterative(Node head) {
        Node current = head, previous = null, next;

        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }

    public static Node reverseLinkedListRecursive(Node previous, Node current) {
        if (current.next == null) {
            current.next = previous;

            return current;
        }

        Node next = current.next;
        current.next = previous;

        return reverseLinkedListRecursive(current, next);
    }

    // Middle Element Of A LinkedList
    // https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
    public static void middleElementOfLinkedList(Node head) {
        Node fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);
    }

    // Check For Palindrome In A LinkedList
    // https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
    public static void checkForPalindromeLinkedList(Node head) {
        // Reversing The List
        if (checkForPalindromeLinkedListReversingList(head)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        // Stack
        if (checkForPalindromeLinkedListStack(head)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean checkForPalindromeLinkedListReversingList(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null && fast.next == null) {
            slow = slow.next;
        }

        Node current = slow, previous = null, next;

        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        current = previous;

        while (current != null) {
            if (head.data != current.data) {
                return false;
            }

            current = current.next;
            head = head.next;
        }

        return true;
    }

    public static boolean checkForPalindromeLinkedListStack(Node head) {
        Node slow = head, fast = head;
        Stack<Node> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null && fast.next == null) {
            slow = slow.next;
        }

        while (slow != null) {
            Node temp = stack.pop();
            if (temp.data != slow.data) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }

    // Nth Node From End Of Linked List
    // https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
    public static void nthNodeFromEndLinkedList(Node head, int n) {
        Node fast = head, slow = null;

        int i = 1;
        while (fast != null) {
            if (i == n) {
                slow = head;
            } else if (i > n) {
                slow = slow.next;
            }

            i++;
            fast = fast.next;
        }

        if (slow == null) {
            System.out.println(-1);
            return;
        }

        System.out.println(slow.data);
    }

    // Detect And Remove Loop In A Linked List
    // https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
    public static void detectAndRemoveLoopLinkedList(Node head) {
        // Using Hashing
        detectAndRemoveLoopLinkedListHashing(head);

        // Floyd's Algorithm
        detectAndRemoveLoopLinkedListFloyd(head);
    }

    public static void detectAndRemoveLoopLinkedListHashing(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node current = head, previous = null;

        while (current != null) {
            if (set.contains(current)) {
                previous.next = null;
                System.out.println(true);
                return;
            } else {
                set.add(current);
                previous = current;
                current = current.next;
            }
        }
    }

    public static void detectAndRemoveLoopLinkedListFloyd(Node head) {
        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            fast.next = null;
        }
    }

    // Delete Without Head Pointer LinkedList
    // https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/
    public static void deleteWithoutHeadPointerLinkedList(Node node) {
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
    }

    // Rotate A LinkedList Counter-ClockWise By K Elements
    // https://www.geeksforgeeks.org/rotate-a-linked-list/
    public static Node rotateByKLinkedList(Node head, int k) {
        if (k == 0) {
            return head;
        }

        Node curr = head, kthNode = null;

        int i = 1;
        while (curr != null && i++ < k) {
            curr = curr.next;
        }

        // k == size(linkedList)
        if (curr == null) {
            return head;
        }

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;
        head = kthNode.next;
        kthNode.next = null;

        return head;
    }

    // Rotate A LinkedList In Groups K Elements
    // https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
    // https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/
    public static void rotateInGroupsOfKLinkedList(Node head, int k) {
        // Recursive Method
        Node headA = rotateInGroupsOfKLinkedListRecursive(head, k);

        // Iterative Method With Stack
        Node headB = rotateInGroupsOfKLinkedListStack(head, k);
    }

    public static Node rotateInGroupsOfKLinkedListRecursive(Node head, int k) {
        Node current = head, previous = null, next;
        int i = 0;
        while (current != null && i++ < k) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        if (current != null) {
            head.next = rotateInGroupsOfKLinkedListRecursive(current, k);
        }

        return previous;
    }

    public static Node rotateInGroupsOfKLinkedListStack(Node head, int k) {
        Node current = head, previous = null;
        Stack<Node> stack = new Stack<>();

        while (current != null) {
            int i = 0;
            while (current != null && i++ < k) {
                stack.push(current);

                current = current.next;
            }

            if (previous == null) {
                head = stack.peek();
                previous = stack.pop();
            }

            while (!stack.isEmpty()) {
                previous.next = stack.peek();
                previous = stack.pop();
            }
        }

        previous.next = null;
        return head;
    }

    // Intersection Point In Y Shaped Linked Lists
    // https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
    public static void intersectionPointInYShapedLinkedLists(Node headA, Node headB) {
        // Using Hashing
        Node intersectionA = intersectionPointInYShapedLinkedListsHashSet(headA, headB);

        // Using Counting
        Node intersectionB = intersectionPointInYShapedLinkedListsCounting(headA, headB);
    }

    public static Node intersectionPointInYShapedLinkedListsHashSet(Node headA, Node headB) {
        HashSet<Node> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }

    public static Node intersectionPointInYShapedLinkedListsCounting(Node headA, Node headB) {
        int countA = intersectionPointInYShapedLinkedListsCountingUtilCount(headA)
                , countB = intersectionPointInYShapedLinkedListsCountingUtilCount(headB);
        int difference = Math.abs(countA - countB);

        if (countA > countB) {
            return intersectionPointInYShapedLinkedListsCountingUtilFind(headA, headB, difference);
        } else {
            return intersectionPointInYShapedLinkedListsCountingUtilFind(headB, headA, difference);
        }
    }

    public static int intersectionPointInYShapedLinkedListsCountingUtilCount(Node head) {
        int i = 0;
        while (head != null) {
            ++i;
            head = head.next;
        }

        return i;
    }

    public static Node intersectionPointInYShapedLinkedListsCountingUtilFind(Node headA, Node headB, int difference) {
        int i = 0;
        while (i++ < difference) {
            headA = headA.next;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
