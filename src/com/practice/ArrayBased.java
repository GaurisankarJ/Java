package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayBased {
    public static void main(String[] args) {
        // Count Distinct Elements In Every Window
//        countDistinctElementsInEveryWindow();

        // Celebrity Problem
//        celebrityProblem();

        // Find Duplicates In An Array [0 to n-1]
//        findDuplicatesInAnArray();

        // Minimum Distance Between Two Numbers
//        minimumDistanceBetweenTwoNumbers();

        // Largest SubArray With Zero Sum
//        largestSubArrayWithZeroSum();
    }

    // Count Distinct Elements In Every Window
    // https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
    // I/P : A = { 1, 2, 1, 3, 4, 2, 3 }, k = 4
    // O/P : 3 4 4 3
    public static void countDistinctElementsInEveryWindow() {
        int[] A = { 1, 2, 1, 3, 4, 2, 3 };
        int n = A.length;
        int k = 4;

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;

        while (j < n) {
            if (!map.containsKey(A[j])) {
                map.put(A[j], 1);
            } else {
                map.replace(A[j], map.get(A[j]) + 1);
            }

            if (j - i == k - 1) {
                System.out.print(map.size() + " ");

                if (map.get(A[i]) == 1) {
                    map.remove(A[i]);
                } else {
                    map.replace(A[i], map.get(A[i]) - 1);
                }

                i++;
            }

            j++;
        }
    }

    // Celebrity Problem
    // https://www.geeksforgeeks.org/the-celebrity-problem/
    // I/P : M = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }
    // O/P : 2
    public static void celebrityProblem() {
        int[][] M = {
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 }
        };

        int n = M[0].length;

        int a = 0, b = n - 1;

        while (a < b) {
            if (M[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != a && (M[a][i] == 1 || M[i][a] == 0)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(a);
    }

    // Find Duplicates In An Array [0 to n-1]
    // https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/
    // I/P : A = { 1, 6, 3, 1, 3, 6, 6 }
    // O/P : 1 3 6
    public static void findDuplicatesInAnArray() {
        int[] A = { 1, 6, 3, 1, 3, 6, 6 };
        int n = A.length;

        for (int i = 0; i < n; i++) {
            A[A[i] % n] += n;
        }

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (A[i] / n > 1) {
                System.out.print(i + " ");
                flag = true;
            }
        }

        if (!flag) {
            System.out.print(-1);
        }
    }

    // Minimum Distance Between Two Numbers
    // https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
    // I/P : A = { 3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3 }, x = 3, y = 6
    // O/P : 1
    public static void minimumDistanceBetweenTwoNumbers() {
        int[] A = { 3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3 };
        int n = A.length;
        int x = 3;
        int y = 6;

        // With Extra Space
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A[i] == x) {
                X.add(i);
            } else if (A[i] == y) {
                Y.add(i);
            }
        }

        if (X.size() == 0 || Y.size() == 0) {
            System.out.println(-1);
            return;
        }

        long minDistance = Long.MAX_VALUE;

        int i = 0, j = 0;

        while (i < X.size() && j < Y.size()) {
            long dist = Math.abs(X.get(i) - Y.get(j));

            if (X.get(i) < Y.get(j)) {
                i++;
            } else {
                j++;
            }

            if (minDistance > dist) {
                minDistance = dist;
            }
        }

        System.out.println(minDistance);

        // Without Extra Space
        minDistance = n;

        // flag = 0  -> search(x || y)
        // flag = 1  -> search(y)
        // flag = -1 -> search(x)
        long flag = 0, count = 1;

        for (int k = 0; k < n; k++) {
            if (flag == 0) {
                if (A[k] == x) {
                    flag = 1;
                } else if (A[k] == y) {
                    flag = -1;
                }
            } else if (flag == 1) {
                if (A[k] == y) {
                    if (minDistance > count) {
                        minDistance = count;
                    }

                    count = 1;
                    flag = -1;
                } else if (A[k] == x) {
                    count = 1;
                } else {
                    count++;
                }
            } else if (flag == -1) {
                if (A[k] == x) {
                    if (minDistance > count) {
                        minDistance = count;
                    }

                    count = 1;
                    flag = 1;
                } else if (A[k] == y) {
                    count = 1;
                } else {
                    count++;
                }
            }
        }

        if (minDistance == n) {
            minDistance = -1;
        }

        System.out.println(minDistance);
    }

    // Largest SubArray With Zero Sum
    // https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
    // I/P : A = { 15, -2, 2, -8, 1, 7, 10, 23 }
    // O/P : 5
    public static void largestSubArrayWithZeroSum() {
        int[] A = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int n = A.length;

        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum)) {
                int len = i - map.get(sum);

                if (maxLen < len) {
                    maxLen = len;
                }
            } else {
                map.put(sum, i);
            }
        }

        System.out.println(maxLen);
    }
}
