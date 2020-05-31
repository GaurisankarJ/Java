package com.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackBased {
    public static void main(String[] args) {
        // Minimum Element From A Stack / Special Stack
//        implementMinElementStack();

        // Stack Using Two Queues
//        implementStackUsingQueue();

        // Implement Stack Using Array
//        implementStackUsingArray();

        // Implement Stack Using LinkedList
//        implementStackUsingLinkedList();

        // Implement Two Stacks In An Array
//        implementTwoStacksUsingArray();

        // Sort A Stack
//        sortStack();

        // Largest Rectangular Area In A Histogram
//        largestRectangularAreaInHistogram();

        // Max Rectangle In Binary Sub-Matrix
//        maxRectangleInBinarySubMatrix();

        // Parenthesis Checker
//        parenthesisChecker();

        // Next Largest Element
//        nextLargestElement();
    }

    // Minimum Element From A Stack / Special Stack
    // https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
    // https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
    public static void implementMinElementStack() {
        MinStack stack = new MinStack();

        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        stack.push(-1);

        while (!stack.isEmpty()) {
            System.out.println("MIN : " + stack.getMinimumElement());;
            stack.printStack();
            stack.pop();
        }

        SpecialStack specialStack = new SpecialStack();

        specialStack.push(3);
        specialStack.push(5);
        specialStack.push(2);
        specialStack.push(1);
        specialStack.push(1);
        specialStack.push(-1);

        while (!specialStack.isEmpty()) {
            System.out.println("MIN : " + specialStack.getMinimumElement());
            specialStack.printStack();
            specialStack.pop();
        }
    }

    public static class MinStack {
        private int minimumElement;
        private Stack<Integer> minStack;

        public MinStack() {
            this.minStack = new Stack<>();
        }

        public void push(int x) {
            if (this.minStack.isEmpty()) {
                this.minimumElement = x;
                this.minStack.push(x);
            } else {
                if (x < minimumElement) {
                    this.minStack.push(2 * x - minimumElement);
                    this.minimumElement = x;
                } else {
                    this.minStack.push(x);
                }
            }
        }

        public int pop() {
            if (this.minStack.isEmpty()) {
                return -1;
            } else {
                int temp = this.minStack.pop();
                if (temp < this.minimumElement) {
                    int minimum = this.minimumElement;
                    this.minimumElement = 2 * this.minimumElement - temp;

                    return minimum;
                } else {
                    return temp;
                }
            }
        }

        public int getMinimumElement() {
            if (this.minStack.isEmpty()) {
                return -1;
            } else {
                return this.minimumElement;
            }
        }

        public void printStack() {
            System.out.println(this.minStack.toString());
        }

        public boolean isEmpty() {
            if (minStack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static class SpecialStack extends Stack {
        private static Stack<Integer> minStack;

        SpecialStack() {
            minStack = new Stack<>();
        }

        void push(int value) {
            if (super.isEmpty()) {
                super.push(value);
                minStack.push(value);
            } else {
                super.push(value);

                int temp = minStack.peek();
                if (temp > value) {
                    minStack.push(value);
                } else {
                    minStack.push(temp);
                }
            }
        }


        public Integer pop() {
            if (super.isEmpty()) {
                return null;
            }

            minStack.pop();
            return (Integer) super.pop();
        }

        Integer getMinimumElement() {
            if (minStack.isEmpty()) {
                return null;
            }

            return minStack.peek();
        }

        void printStack() {
            System.out.println(super.toString());
        }
    }

    // Stack Using Two Queues
    // https://www.geeksforgeeks.org/implement-stack-using-queue/
    public static void implementStackUsingQueue() {
        QueueStack stack = new QueueStack();

        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        stack.push(-1);

        while (!stack.isEmpty()) {
            stack.printStack();
            stack.pop();
        }
    }

    public static class QueueStack {
        private Queue<Integer> queueOne;
        private Queue<Integer> queueTwo;

        QueueStack() {
            this.queueOne = new LinkedList<>();
            this.queueTwo = new LinkedList<>();
        }

        public void push(int x) {
            if (this.queueOne.isEmpty()) {
                this.queueOne.offer(x);
            } else {
                this.queueTwo.offer(x);

                while (!this.queueOne.isEmpty()) {
                    this.queueTwo.offer(this.queueOne.poll());
                }

                Queue<Integer> temp = this.queueOne;
                this.queueOne = this.queueTwo;
                this.queueTwo = temp;
            }
        }

        public int pop() {
            if (this.queueOne.isEmpty()) {
                return -1;
            } else {
                return this.queueOne.poll();
            }
        }

        public boolean isEmpty() {
            if (this.queueOne.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        public void printStack() {
            System.out.println(this.queueOne.toString());
        }
    }

    // Implement Stack Using Array
    // https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
    public static void implementStackUsingArray() {
        ArrayStack stack = new ArrayStack();

        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        stack.push(-1);

        stack.printStack();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static class ArrayStack {
        private int top;
        private int[] arrayStack;

        public ArrayStack() {
            top = -1;
            arrayStack = new int[1000];
        }

        public void push(int x) {
            if (top == 999) {
                System.out.println("Stack Overflow!");
                return;
            }

            arrayStack[++top] = x;
        }

        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow!");
                return -1;
            }

            return arrayStack[top--];
        }

        public boolean isEmpty() {
            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

        public void printStack() {
            System.out.println(Arrays.toString(Arrays.copyOfRange(arrayStack, 0, top + 1)));
        }
    }

    // Implement Stack Using LinkedList
    // https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
    public static void implementStackUsingLinkedList() {
        LinkedListStack stack = new LinkedListStack();

        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        stack.push(-1);

        while (!stack.isEmpty()) {
            stack.printStack();
            stack.pop();
        }
    }

    public static class StackNode {
        int data;
        StackNode next;

        StackNode(int x) {
            data = x;
            next = null;
        }
    }

    public static class LinkedListStack {
        private StackNode top;

        public LinkedListStack() {
            top = null;
        }

        public void push(int x) {
            if (top == null) {
                top = new StackNode(x);
            } else {
                StackNode newNode = new StackNode(x);

                newNode.next = top;
                top = newNode;
            }
        }

        public int pop() {
            if (top == null) {
                return -1;
            }

            int data = top.data;
            top = top.next;

            return data;
        }

        public boolean isEmpty() {
            if (top == null) {
                return true;
            } else {
                return false;
            }
        }

        public void printStack() {
            StackNode temp = top;

            while (temp != null) {
                System.out.print(temp.data + " ");

                temp = temp.next;
            }

            System.out.println();
        }
    }

    // Implement Two Stacks In An Array
    // https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
    public static void implementTwoStacksUsingArray() {
        ArrayStacks stack = new ArrayStacks();

        stack.pushOne(3);
        stack.pushOne(5);
        stack.pushOne(2);
        stack.pushOne(1);
        stack.pushOne(1);
        stack.pushOne(-1);

        stack.pushTwo(3);
        stack.pushTwo(5);
        stack.pushTwo(2);
        stack.pushTwo(1);
        stack.pushTwo(1);
        stack.pushTwo(-1);

        while (!stack.isEmptyOne()) {
            stack.printStackOne();
            stack.popOne();
        }

        while (!stack.isEmptyTwo()) {
            stack.printStackTwo();
            stack.popTwo();
        }
    }

    public static class ArrayStacks {
        private int topOne;
        private int topTwo;
        private int[] arrayStack;

        public ArrayStacks() {
            topOne = -1;
            topTwo = 1000;
            arrayStack = new int[1000];
        }

        public void pushOne(int x) {
            if (topOne + 1 == topTwo) {
                System.out.println("Stack Overflow!");
                return;
            }

            arrayStack[++topOne] = x;
        }

        public void pushTwo(int x) {
            if (topTwo - 1 == topOne) {
                System.out.println("Stack Overflow!");
                return;
            }

            arrayStack[--topTwo] = x;
        }

        public int popOne() {
            if (topOne == -1) {
                System.out.println("Stack Underflow!");
                return -1;
            }

            return arrayStack[topOne--];
        }

        public int popTwo() {
            if (topTwo == 1000) {
                System.out.println("Stack Underflow!");
                return -1;
            }

            return arrayStack[topTwo++];
        }

        public boolean isEmptyOne() {
            if (topOne == -1) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isEmptyTwo() {
            if (topTwo == 1000) {
                return true;
            } else {
                return false;
            }
        }

        public void printStackOne() {
            for (int i = 0; i <= topOne; i++) {
                System.out.print(arrayStack[i] + " ");
            }

            System.out.println();
        }

        public void printStackTwo() {
            for (int i = 999; i >= topTwo; i--) {
                System.out.print(arrayStack[i] + " ");
            }

            System.out.println();
        }
    }

    // Sort A Stack
    // https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
    // https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
    public static void sortStack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(9);
        stack.push(5);
        stack.push(4);
        stack.push(1);
        stack.push(99);
        stack.push(-1);

        System.out.println(stack.toString());

        // Recursive Method
        sortStackRecursive(stack);
        System.out.println(stack.toString());

        // Temporary Stack Method
        stack = sortStackTempStack(stack);
        System.out.println(stack.toString());
    }

    public static void sortStackRecursive(Stack stack) {
        if (!stack.isEmpty()) {
            int temp = (int) stack.pop();
            sortStackRecursive(stack);
            sortStackRecursiveInsertUtil(stack, temp);
        }
    }

    public static void sortStackRecursiveInsertUtil(Stack stack, int i) {
        if (stack.isEmpty() || i > (int) stack.peek()) {
            stack.push(i);
        } else {
            int temp = (int) stack.pop();
            sortStackRecursiveInsertUtil(stack, i);
            stack.push(temp);
        }
    }

    public static Stack<Integer> sortStackTempStack(Stack stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = (int) stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() < temp) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        return tempStack;
    }

    // Largest Rectangular Area In A Histogram
    // https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    public static void largestRectangularAreaInHistogram() {
        int[] histogram = { 6, 2, 5, 4, 5, 1, 6 };
        int n = histogram.length;

        System.out.println(largestRectangularAreaInHistogramUtil(histogram, n));
    }

    public static int largestRectangularAreaInHistogramUtil(int[] histogram, int n) {
        Stack<Integer> stack = new Stack<>();
        int areaWithTop, top, maximumArea = 0, i = 0;

        while (i < n) {
            if (stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
                stack.push(i++);
            } else {
                top = stack.pop();

                areaWithTop = histogram[top] * (stack.isEmpty()? i: i - stack.peek() - 1);
                if (maximumArea < areaWithTop) {
                    maximumArea = areaWithTop;
                }
            }
        }

        while (!stack.isEmpty()) {
            top = stack.pop();

            areaWithTop = histogram[top] * (stack.isEmpty()? i: i - stack.peek() - 1);
            if (maximumArea < areaWithTop) {
                maximumArea = areaWithTop;
            }
        }

        return maximumArea;
    }

    // Max Rectangle In Binary Sub-Matrix
    // https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
    public static void maxRectangleInBinarySubMatrix() {
        int[][] matrix = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };

        int rows = matrix.length;
        int columns = matrix[0].length;

        System.out.println(maxRectangleInBinarySubMatrixUtil(matrix, rows, columns));
    }

    public static int maxRectangleInBinarySubMatrixUtil(int[][] matrix, int m, int n) {
        int maxRectangle = largestRectangularAreaInHistogramUtil(matrix[0], n);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            maxRectangle = Math.max(maxRectangle, largestRectangularAreaInHistogramUtil(matrix[i], n));
        }

        return maxRectangle;
    }

    // Parenthesis Checker
    // https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
    public static void parenthesisChecker() {
        String toCheck = "{([])}";

        System.out.println(parenthesisCheckerUtil(toCheck));
    }

    public static boolean parenthesisCheckerUtil(String string) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(string.charAt(i));
            } else {
                if (string.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (string.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (string.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(string.charAt(i));
                }
            }
        }

        return stack.isEmpty();
    }

    // Next Largest Element
    // https://www.geeksforgeeks.org/next-greater-element/
    public static void nextLargestElement() {
        int[] A = { 11, 13, 21, 3 };
        int n = A.length;

        System.out.println(Arrays.toString(nextLargestElementUtil(A, n)));
    }

    public static int[] nextLargestElementUtil(int[] A, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < A[i]) {
                stack.pop();
            }

            result[i] = (stack.isEmpty()? -1: stack.peek());
            stack.push(A[i]);
        }

        return result;
    }
}
