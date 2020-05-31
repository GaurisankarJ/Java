package com.practice;

import java.util.*;

public class SortingBased {
    public static void main(String[] args) {
        // Merge Sort
//        implementMergeSort();

        // Quick Sort
//        implementQuickSort();

        // Heap Sort
//        implementHeapSort();

        // Find Triplets With Zero Sum
//        findTripletsWithZeroSum();

        // Merge K Sorted Arrays
//        mergeKSortedArrays();

        // Floor In A Sorted Array
//        floorInASortedArray();

        // Inversion Count
//        inversionCountInArray();

        // Count Possible Triangles
//        countPossibleTrianglesInArray();

        // Triplets With Given Sum
//        findTripletsWithGivenSum();

        // Sort An Array Of 0's, 1's and 2's
//        sortArrayOfZerosOnesTwos();

        // Minimum Number Of Platforms Required For A Station
//        findMinimumNumberOfPlatforms();
    }

    // Merge Sort
    // https://www.geeksforgeeks.org/merge-sort/
    // I/P : A = { 12, 11, 13, 5, 6, 7 }
    // O/P : [5, 6, 7, 11, 12, 13]
    public static void implementMergeSort() {
        int[] A = { 12, 11, 13, 5, 6, 7 };
        int n = A.length;

        mergeSort(A, 0, n - 1);

        System.out.println(Arrays.toString(A));
    }

    public static void mergeSort(int[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            mergeSortUtil(A, start, mid, end);
        }
    }

    public static void mergeSortUtil(int[] A, int start, int mid, int end) {
        int[] leftArray = Arrays.copyOfRange(A, start, mid + 1);
        int[] rightArray = Arrays.copyOfRange(A, mid + 1, end + 1);

        int i = 0, j = 0, k = start;
        int m = leftArray.length, n = rightArray.length;

        while (i < m && j < n) {
            if (leftArray[i] < rightArray[j]) {
                A[k++] = leftArray[i++];
            } else {
                A[k++] = rightArray[j++];
            }
        }

        while (i < m) {
            A[k++] = leftArray[i++];
        }

        while (j < n) {
            A[k++] = rightArray[j++];
        }
    }

    // Quick Sort
    // https://www.geeksforgeeks.org/quick-sort/
    // I/P : A = { 12, 11, 13, 5, 6, 7 }
    // O/P : [5, 6, 7, 11, 12, 13]
    public static void implementQuickSort() {
        int[] A = { 12, 11, 13, 5, 6, 7 };
        int n = A.length;

        quickSort(A, 0, n - 1);

        System.out.println(Arrays.toString(A));
    }

    public static void quickSort(int[] A, int start, int end) {
        if (start < end) {
            int partitioningIndex = quickSortUtil(A, start, end);

            quickSort(A, start, partitioningIndex);
            quickSort(A, partitioningIndex + 1, end);
        }
    }

    public static int quickSortUtil(int[] A, int start, int end) {
        int pivot = A[end];

        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (A[i] < pivot) {
                j++;

                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }

        int temp = A[j + 1];
        A[j + 1] = A[end];
        A[end] = temp;

        return j;
    }

    // Heap Sort
    // https://www.geeksforgeeks.org/heap-sort/
    // I/P : A = { 12, 11, 13, 5, 6, 7 }
    // O/P : [5, 6, 7, 11, 12, 13]
    public static void implementHeapSort() {
        int[] A = { 12, 11, 13, 5, 6, 7 };
        int n = A.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }

        // Extract Elements One By One
        for (int i = n - 1; i >= 0; i--) {
            heapSwapUtil(A, 0, i);

            heapify(A, i, 0);
        }

        System.out.println(Arrays.toString(A));
    }

    public static void heapify(int[] A, int n, int i) {
        int largestNode = i;
        int leftNode = 2 * i + 1;
        int rightNode = 2 * i + 2;

        if (leftNode < n && A[leftNode] > A[largestNode]) {
            largestNode = leftNode;
        }

        if (rightNode < n && A[rightNode] > A[largestNode]) {
            largestNode = rightNode;
        }

        if (largestNode != i) {
            heapSwapUtil(A, i , largestNode);

            heapify(A, n, largestNode);
        }
    }

    public static void heapSwapUtil(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Find Triplets With Zero Sum
    // https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
    // I/P : A = { 0, -1, 2, -3, 1 }
    // O/P : true
    public static void findTripletsWithZeroSum() {
        int[] A = { 0, -1, 2, -3, 1 };
        int n = A.length;

        System.out.println(findTripletsWithZeroSumUtil(A, n));
    }

    public static boolean findTripletsWithZeroSumUtil(int[] A, int n) {
        Arrays.sort(A);

        for(int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while(j < k){
                int sum = A[i] + A[j] + A[k];

                if (sum == 0) {

                    return true;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return false;
    }

    // Merge K Sorted Arrays
    // https://www.geeksforgeeks.org/merge-k-sorted-arrays/
    // I/P : M = { {2, 6, 12, 34}, {1, 9, 20, 1000}, {23, 34, 90, 2000} }
    // O/P : [1, 2, 6, 9, 12, 20, 23, 34, 34, 90, 1000, 2000]
    public static void mergeKSortedArrays() {
        int[][] M = {
                { 2, 6, 12, 34 },
                { 1, 9, 20, 1000 },
                { 23, 34, 90, 2000 }
        };

        System.out.println(mergeKSortedArraysUtil(M).toString());
    }

    public static class HeapItem implements Comparable<HeapItem> {
        int[] array;
        int index;

        public HeapItem(int[] array, int index) {
            this.array = array;
            this.index = index;
        }

        @Override
        public int compareTo(HeapItem heapItem) {
            if (this.array[this.index] < heapItem.array[heapItem.index]) {
                return -1;
            } else if (this.array[this.index] > heapItem.array[heapItem.index]) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static ArrayList<Integer> mergeKSortedArraysUtil(int[][] M) {
        // Priority Queue Is A Heap
        Queue<HeapItem> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < M.length; i++) {
            priorityQueue.add(new HeapItem(M[i], 0));
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!priorityQueue.isEmpty()) {
            // poll() / remove()
            HeapItem root = priorityQueue.poll();

            list.add(root.array[root.index]);

            if (root.index < root.array.length - 1) {
                root.index++;

                priorityQueue.add(root);
            }
        }

        return list;
    }

    // Floor In A Sorted Array
    // https://www.geeksforgeeks.org/floor-in-a-sorted-array/
    // I/P : A = { 1, 2, 4, 6, 10, 12, 14 }, x = 7
    // O/P : 6
    public static void floorInASortedArray() {
        int[] A = { 1, 2, 4, 6, 10, 12, 14 };
        int x = 7, n = A.length;

        System.out.println(floorInASortedArrayUtil(A, 0, n - 1, x));
    }

    public static int floorInASortedArrayUtil(int[] A, int low, int high, int x) {
        if (high == 1) {
            return -1;
        }

        int n = A.length - 1;
        if (low == n) {
            return A[n];
        }

        int mid = (high + low) / 2;

        if (A[mid] == x || (A[mid] < x && A[mid + 1] > x)) {
            return A[mid];
        } else if (A[mid - 1] < x && A[mid] > x) {
            return A[mid - 1];
        } else if (A[mid] < x) {
            return floorInASortedArrayUtil(A, mid + 1, high, x);
        } else {
            return floorInASortedArrayUtil(A, low, mid, x);
        }
    }

    // Inversion Count
    // https://www.geeksforgeeks.org/counting-inversions/
    // I/P : A = { 1, 20, 6, 4, 5 }
    // O/P : 5
    public static void inversionCountInArray() {
        int[] A = { 1, 20, 6, 4, 5 };
        int n = A.length;

        System.out.println(inversionCountInArrayUtil(A, 0, n - 1));
    }

    public static int inversionCountInArrayUtil(int[] A, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;

            count += inversionCountInArrayUtil(A, start, mid);
            count += inversionCountInArrayUtil(A, mid + 1, end);

            count += inversionCountInArrayMergeUtil(A, start, mid, end);
        }

        return count;
    }

    public static int inversionCountInArrayMergeUtil(int[] A, int start, int mid, int end) {
        int[] leftArray = Arrays.copyOfRange(A, start, mid + 1);
        int[] rightArray = Arrays.copyOfRange(A, mid + 1, end + 1);

        int n = leftArray.length, m = rightArray.length;
        int i = 0, j = 0, k = start, count = 0;
        while (i < n && j < m) {
            if (leftArray[i] <= rightArray[j]) {
                A[k++] = leftArray[i++];
            } else {
                count += (mid + 1) - (start + i);
                A[k++] = rightArray[j++];
            }
        }

        while (i < n) {
            A[k++] = leftArray[i++];
        }

        while (j < m) {
            A[k++] = rightArray[j++];
        }

        return count;
    }

    // Count Possible Triangles
    // https://www.geeksforgeeks.org/find-number-of-triangles-possible/
    // I/P : A = { 4, 3, 5, 7, 6 }
    // O/P : 9
    public static void countPossibleTrianglesInArray() {
        int[] A = { 4, 3, 5, 7, 6 };
        int n = A.length;

        System.out.println(countPossibleTrianglesInArrayUtil(A, n));
    }

    public static int countPossibleTrianglesInArrayUtil(int[] A, int n) {
        int count = 0;

        Arrays.sort(A);

        for (int i = n - 1; i > 1; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (A[j] + A[k] > A[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }

        return count;
    }

    // Triplets With Given Sum
    // https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
    // I/P : A = { 1, 4, 45, 6, 10, 8 }
    // O/P : true
    public static void findTripletsWithGivenSum() {
        int[] A = { 1, 4, 45, 6, 10, 8 };
        int n = A.length;
        int sum = 22;

        // Two Pointer Method
        System.out.println(findTripletsWithGivenSumTwoPointerUtil(A, n, sum));

        // Hashing Method
        System.out.println(findTripletsWithGivenSumHashingUtil(A, n, sum));
    }

    public static boolean findTripletsWithGivenSumTwoPointerUtil(int[] A, int n, int sum) {
        Arrays.sort(A);

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int tempSum = A[i] + A[j] + A[k];

                if (tempSum == sum) {
                    return true;
                } else if (tempSum < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return false;
    }

    public static boolean findTripletsWithGivenSumHashingUtil(int[] A, int n, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
            for (int j = i + 1; j < n; j++) {
                if (set.contains(sum - A[i] - A[j])) {
                    return true;
                }
            }
        }

        return false;
    }

    // Sort An Array Of 0's, 1's and 2's
    // https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    // I/P : A = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 }
    // O/P : [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
    public static void sortArrayOfZerosOnesTwos() {
        int[] A = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int n = A.length;

        System.out.println(Arrays.toString(sortArrayOfZerosOnesTwosUtil(A, n)));
    }

    public static int[] sortArrayOfZerosOnesTwosUtil(int A[], int n) {
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (A[mid] == 0) {
                sortArrayOfZerosOnesTwosSwapUtil(A, low++, mid++);
            } else if (A[mid] == 2) {
                sortArrayOfZerosOnesTwosSwapUtil(A, mid, high--);
            } else {
                mid++;
            }
        }

        return A;
    }

    public static void sortArrayOfZerosOnesTwosSwapUtil(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Minimum Number Of Platforms Required For A Station
    // https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    // I/P : arrival[] = { 900, 940, 950, 1100, 1500, 1800 }, departure[] = { 910, 1200, 1120, 1130, 1900, 2000 }
    // O/P : 3
    public static void findMinimumNumberOfPlatforms() {
        int arrival[] = { 900, 940, 950, 1100, 1500, 1800 };
        int departure[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arrival.length;

        // O(nLog(n)) Time - O(1) Space
        System.out.println(findMinimumNumberOfPlatformsUtil(arrival, departure, n));
    }

    public static int findMinimumNumberOfPlatformsUtil(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0, j = 0, count = 0, max = Integer.MIN_VALUE;
        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                i++;
                count++;

                max = Math.max(count, max);
            } else {
                j++;
                count--;
            }
        }

        return max;
    }
}
