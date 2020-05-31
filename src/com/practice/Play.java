//package com.practice;
//
//import java.io.*;
//import java.util.*;
//
//public class Play {
//    public static void Hello() {
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
//        int n = str.length();
//        System.out.println(str + " " + n);
//        scan.close();
//    }
//
//    // Reverse a String Without Affecting Special Characters
//    public static void arrayReverse(char arr[]) {
//        int end = arr.length - 1, start = 0;
//
//        while (start < end) {
//            if (!Character.isAlphabetic(arr[start])) {
//                start++;
//            } else if (!Character.isAlphabetic(arr[end])) {
//                end--;
//            } else {
//                char temp = arr[start];
//                arr[start] = arr[end];
//                arr[end] = temp;
//
//                start++;
//                end--;
//            }
//        }
//    }
//
//    public static void RSWASC() {
//        String str1 = "a,b$c";
//        String str2 = "Ab,c,de!$";
//
//        char[] arr1 = str1.toCharArray();
//        char[] arr2 = str2.toCharArray();
//
//        System.out.println("Input 1 : " + str1 + "\nInput 2 : " + str2);
//
//        arrayReverse(arr1);
//        arrayReverse(arr2);
//
//        String newStr1 = new String(arr1);
//        String newStr2 = new String(arr2);
//
//        System.out.println("\nOutput 1 : " + newStr1 + "\nOutput 2 : " + newStr2);
//    }
//
//    // Given a String, Print All Possible Palindromic Partitions
//    public static boolean isPalindrome(String str, int start, int end) {
//        while (start < end) {
//            if (str.charAt(start++) != str.charAt(end--))
//                return false;
//        }
//        return true;
//    }
//
//    public static void allPalindromicPartitions(String input) {
//        int end = input.length();
//
//        ArrayList<ArrayList<String>> allPartitions = new ArrayList<>();
//        Deque<String> currentPartition = new LinkedList<>();
//
//        allPalindromicPartitionsUtil(allPartitions, currentPartition, input, 0, end);
//
//        for (int i = 0; i < allPartitions.size(); i++) {
//            for (int j = 0; j < allPartitions.get(i).size(); j++) {
//                System.out.print(allPartitions.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void allPalindromicPartitionsUtil(ArrayList<ArrayList<String>> allPartitions,
//                                                    Deque<String> currentPartition, String input, int start, int end) {
//        if (start >= end) {
//            allPartitions.add(new ArrayList<>(currentPartition));
//            return;
//        }
//
//        for (int i = start; i < end; i++) {
//            if (isPalindrome(input, start, i)) {
//                currentPartition.addLast(input.substring(start, i + 1));
//
//                allPalindromicPartitionsUtil(allPartitions, currentPartition, input, i + 1, end);
//
//                currentPartition.removeLast();
//            }
//        }
//    }
//
//    public static void PAPPP() {
//        String input = "nitin";
//
//        System.out.println("All possible palindromic partitions for given input " + input + " are :");
//
//        allPalindromicPartitions(input);
//    }
//
//    // Practice, HackerEarth
//    public static void DoPrint(int n) {
//        for (int i = 1; i <= n; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println("HotFuzz");
//            } else if (i % 3 == 0) {
//                System.out.println("Hot");
//            } else if (i % 5 == 0) {
//                System.out.println("Fuzz");
//            } else {
//                System.out.println(i);
//            }
//        }
//    }
//
//    public static void HackerEarth() {
//        Scanner scan = new Scanner(System.in);
//
//        String T = "", N = "";
//
//        System.out.println("Enter number of test cases: ");
//        T = scan.nextLine();
//        System.out.println("Enter space separated test cases: ");
//        N = scan.nextLine();
//
//        int t = Integer.parseInt(T);
//        String arrN[] = N.split(" ");
//        int[] n = new int[t];
//        int j = 0;
//        for (String str : arrN)
//            n[j++] = Integer.parseInt(str);
//
//        for (int i = 0; i < t; i++) {
//            DoPrint(n[i]);
//        }
//    }
//
//    // Q1
//    static String[] solve(String[] S, int N) {
//        // write your code here
//        Map<String, Integer> map = new HashMap<String, Integer>();
//
//        for (int i = 0; i < N; i++) {
//            if (map.containsKey(S[i])) {
//                map.put(S[i], map.get(S[i]) + 1);
//            } else {
//                map.put(S[i], 1);
//            }
//        }
//
//        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
//
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            public int compare(Map.Entry<String, Integer> url1, Map.Entry<String, Integer> url2) {
//                return (url2.getValue()).compareTo(url1.getValue());
//            }
//        });
//
//        int length = map.size(), i = 0;
//        String output[] = new String[length];
//
//        for (Map.Entry<String, Integer> item : list) {
//            output[i++] = item.getKey();
//        }
//
//        return output;
//    }
//
//    // Q2
//    static int solve(int N, int[] A) {
//        // Your code goes here
//        int closest = A[0], temp;
//
//        if (A[0] < 0) {
//            temp = 0 - A[0];
//        } else {
//            temp = A[0];
//        }
//
//        for (int i = 1; i < N; i++) {
//            if (A[i] < 0) {
//                if (temp > 0 - A[i]) {
//                    temp = 0 - A[i];
//                    closest = A[i];
//                }
//            }
//
//            if (A[i] >= 0) {
//                if (temp >= A[i]) {
//                    temp = A[i];
//                    closest = A[i];
//                }
//            }
//        }
//
//        return closest;
//    }
//
//    // Q6
//    static String solve(String S) {
//        // Your code goes here
//        StringBuilder str = new StringBuilder();
//
//        str.append(S);
//
//        str = str.reverse();
//
//        return str.toString();
//    }
//
//    // Q4
//    static int solve(int[] A, int N) {
//        // Your code goes here
//        Arrays.sort(A);
//
//        int count = 0;
//
//        for (int i = N - 1; i >= 0; i--) {
//            if (i > 0 && i < N - 1 && A[i - 1] == A[i]) {
//                continue;
//            } else {
//                int j = 0;
//                while (A[j] <= (A[i] / 2)) {
//                    if (A[i] % A[j] == 0) {
//                        count++;
//                        break;
//                    }
//                    j++;
//                }
//            }
//        }
//
//        return count;
//
//        // List<Integer> list = new ArrayList<Integer>();
//
//        // int maxElement = Integer.MIN_VALUE;
//        // for (int i = 0; i < N; i++) {
//        // 	list.add(A[i]);
//        // 	maxElement = Math.max(maxElement,
//        // 					A[i]);
//        // }
//
//        // LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
//        // for (int i = 0; i < N; i++) {
//        // 	if (A[i] != 0)
//        // 		for (int j = A[i] * 2;
//        // 			j <= maxElement;
//        // 			j += A[i]) {
//        //             if (list.contains(j)) {
//        //                 set.add(j);
//        //             }
//        // 		}
//        // }
//
//        // return set.size();
//    }
//
//    // N in M ways
//    public static int NinM(int N, int M, int[] C) {
//        int maxLen = N - M + 1;
//
//        int[] arr = { 1, 2, 3, 4 };
//
//        subArr(arr, 0, 0);
//        return 5;
//    }
//
//    public static int findSum(int[] arr) {
//        int sum = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            sum = arr[i];
//        }
//
//        return sum;
//    }
//
//    public static void subArr(int[] arr, int start, int end) {
//        if (end == arr.length) {
//            return;
//        } else if (start > end) {
//            subArr(arr, 0, end + 1);
//        } else {
//            for (int i = start; i < end; i++) {
//                System.out.print(arr[i]);
//            }
//            System.out.println();
//            subArr(arr, start + 1, end);
//        }
//
//        return;
//    }
//
//    // Kadane's Algorithm (Max Contiguous Sum)
//    public static int maxSubArraySum(int[] a) {
//        int size = a.length, end = 0, start = 0, s = 0;
//
//        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
//
//        for (int i = 0; i < size; i++) {
//            max_ending_here = max_ending_here + a[i];
//
//            if (max_ending_here < 0) {
//                max_ending_here = 0;
//                s = i + 1;
//            } else if (max_so_far < max_ending_here) {
//                max_so_far = max_ending_here;
//                start = s;
//                end = i;
//            }
//        }
//
//        System.out.println("Start : " + start + "\nEnd : " + end);
//
//        return max_so_far;
//    }
//
//    // Sock Merchant
//    static int sockMerchant(int n, int[] ar) {
//        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
//        for (int i = 0; i < ar.length; i++) {
//            if (map.containsKey(ar[i])) {
//                map.replace(ar[i], map.get(ar[i]) + 1);
//            } else {
//                map.put(ar[i], 1);
//            }
//        }
//
//        int count = 0;
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            count += (entry.getValue() / 2);
//            // System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//
//        return count;
//    }
//
//    // Counting Valleys
//    static int countingValleys(int n, String s) {
//        int level = 0, valleys = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i) == 'D') {
//                if (level == 0) {
//                    valleys += 1;
//                }
//
//                level -= 1;
//            } else if (s.charAt(i) == 'U') {
//                level += 1;
//            }
//        }
//
//        return valleys;
//    }
//
//    // Jumping on the Clouds
//    static int jumpingOnClouds(int[] c) {
//        int jumps = 0, i = 0;
//
//        while (i < c.length - 2) {
//            if (c[i + 2] == 1) {
//                i += 1;
//            } else {
//                i += 2;
//            }
//
//            jumps++;
//        }
//
//        if (i == c.length - 2) {
//            return jumps + 1;
//        } else {
//            return jumps;
//        }
//    }
//
//    // Repeated Strings
//    static long repeatedString(String s, long n) {
//        long a_in_string = 0, a_in_remainder = 0, length_string = s.length();
//        long remainder = n % (long) length_string;
//        long quotient = n / (long) length_string;
//        long loop = (length_string < n) ? length_string : n;
//
//        for (long i = 0; i < loop; i++) {
//            if (s.charAt((int) i) == 'a') {
//                a_in_string++;
//
//                if (i < remainder) {
//                    a_in_remainder++;
//                }
//            }
//        }
//
//        System.out.println("\nQuotient : " + quotient + "\nRemainder : " + remainder);
//        System.out.println("\na's in string : " + a_in_string + "\na's in remainder : " + a_in_remainder);
//
//        long count = quotient * a_in_string + a_in_remainder;
//
//        return count;
//    }
//
//    // 2D Array
//    static int hourglassSum(int[][] ar) {
//        int[] sum = new int[16];
//        int m = 0;
//
//        for (int x = 0; x < 4; x++) {
//            for (int y = 0; y < 4; y++) {
//                for (int i = x; i < x + 3; i++) {
//                    for (int j = y; j < y + 3; j++) {
//                        if ((i == x || i == x + 2) && j != (y + 1)) {
//                            sum[m] += ar[i][j];
//                        }
//
//                        if (j == y + 1) {
//                            sum[m] += ar[i][j];
//                        }
//                    }
//                }
//                m++;
//            }
//        }
//
//        int max = sum[0];
//
//        for (int i = 0; i < 16; i++) {
//            if (max < sum[i]) {
//                max = sum[i];
//            }
//        }
//
//        return max;
//    }
//
//    // Arrays: Left Rotation
//    static int[] rotLeft(int[] a, int d) {
//        int[] arr = new int[a.length];
//        int j = 0;
//
//        for (int i = d; i < a.length + d; i++) {
//            arr[j] = a[i % a.length];
//
//            j++;
//        }
//
//        return arr;
//    }
//
//    // New Year Chaos
//    static void minimumBribes(int[] q) {
//        int count = 0;
//
//        for (int i = q.length - 1; i >= 0; i--) {
//            if (q[i] - (i + 1) > 2) {
//                System.out.println("Too chaotic");
//
//                return;
//            }
//
//            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
//                if (q[j] > q[i]) {
//                    count++;
//                }
//            }
//        }
//
//        System.out.println(count);
//
//        return;
//    }
//
//    // Find Number of Sub-arrays with Even Sum
//    static int findEvenSumSubArrays(int[] arr) {
//        int count[] = { 1, 0 };
//
//        int sum = 0, result = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            sum = ((sum + arr[i]) % 2 + 2) % 2;
//
//            count[sum]++;
//        }
//
//        result += (count[0] * (count[0] - 1)) / 2;
//        result += (count[1] * (count[1] - 1)) / 2;
//
//        return result;
//    }
//}
