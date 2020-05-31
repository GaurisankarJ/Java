//package com.practice;
//
//import java.util.*;
//import java.util.regex.*;
//import java.util.stream.Collectors;
//
//public class Amazon {
//    // Find Unique Elements In Sorted Order [SET] [HASH_SET] [TREE_SET] [LINKED_HASH_SET]
//    public static void findUniqueElementsSorted() {
//        Integer[] array = new Integer[] { 1, 2, 2, 3, 4, 4, 7, 1, 5, 6, 0 };
//
//        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(array));
//
//        System.out.println(treeSet.toString());
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Filter And Map [ARRAY_LIST] [LINKED_LIST]
//    // [LIST] ==> add -- addAll -- remove -- get -- set -- indexOf -- lastIndexOf -- subList
//    public static void filterAndMap() {
//        Integer[] array = new Integer[] { 1, 2, 2, 3, 4, 4, 7, 1, 5, 6, 0 };
//
//        List<Integer> arrayList = new ArrayList<>();
//
//        Collections.addAll(arrayList, array);
//
//        List<Integer> filteredAndMapped = arrayList.stream()
//                .filter(element -> element % 2 == 0)
//                .map(element -> element * element)
//                .collect(Collectors.toList());
//
//        System.out.println(filteredAndMapped.toString());
//
//        LinkedList<Integer> linkedList = new LinkedList<>(filteredAndMapped);
//
//        LinkedList<Integer> newLinkedList = new LinkedList<>();
//
//        while (!linkedList.isEmpty()) {
//            // Object.poll() / Object.pollFirst() ==>
//            // Object.offer() / Object.offerLast() <==
//            newLinkedList.offerLast(linkedList.pollFirst());
//            newLinkedList.offerFirst(linkedList.pollLast());
//        }
//
//        System.out.println(newLinkedList.toString());
//
//        newLinkedList.forEach(linkedList::add);
//
//        Iterator iterator = newLinkedList.iterator();
//
//        while (iterator.hasNext()) {
//            linkedList.offerLast((Integer) iterator.next());
//        }
//
//        System.out.println(linkedList.toString());
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Remove And Replace [VECTOR]
//    public static void removeAndReplace() {
//        Integer[] array = new Integer[] { 1, 2, 2, 3, 4, 4, 7, 1, 5, 6, 0 };
//
//        Vector<Integer> vector = new Vector<>(Arrays.asList(array));
//
//        int firstOccurrence = vector.indexOf(1);
//        int lastOccurrence = vector.lastIndexOf(1);
//
//        // Object.add(int index, Object object)
//        vector.add(firstOccurrence, -1);
//        vector.add(lastOccurrence, -1);
//
//        vector.remove(firstOccurrence + 1);
//        vector.remove(lastOccurrence + 1);
//
//        System.out.println(vector.toString());
//
//        // Object.setElementAt(Object object, int index)
//        vector.setElementAt(1000, firstOccurrence);
//        vector.setElementAt(1000, lastOccurrence);
//
//        System.out.println(vector.toString());
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Check For Balanced Parentheses In Expression [STACK]
//    public static void checkForBalancedParenthesis() {
//        String expression = "[([]())]";
//
//        Stack<String> stack = new Stack<>();
//
//        String[] expressionArray = expression.split("");
//
//        for (String str : expressionArray) {
//            if (stack.isEmpty()) {
//                stack.add(str);
//            } else if (stack.peek().equals("[") && str.equals("]")) {
//                stack.pop();
//            } else if (stack.peek().equals("{") && str.equals("}")) {
//                stack.pop();
//            } else if (stack.peek().equals("(") && str.equals(")")) {
//                stack.pop();
//            } else {
//                stack.push(str);
//            }
//        }
//
//        if (stack.isEmpty()) {
//            System.out.println("Balanced");
//        } else {
//            System.out.println("Not Balanced");
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Priority Queue [QUEUE] [PRIORITY_QUEUE]
//    // [QUEUE] ==> add -- peek -- element - remove - poll - size
//    // [PRIORITY_QUEUE] ==> toArray -- comparator - offer
//    public static void implementPriorityQueue() {
//        Integer[] array = new Integer[] { 1, 2, 2, 3, 4, 4, 7, 1, 5, 6, 0 };
//
//        Queue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(array));
//
//        System.out.println(priorityQueue.toString());
//
//        while (!priorityQueue.isEmpty()) {
//            System.out.println(priorityQueue.peek());
//
//            priorityQueue.poll();
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Dequeue [DEQUE]
//    // [DEQUE] ==> add -- offer -- peek -- element - remove - poll - size -- iterator -- descendingIterator
//    public static void implementDeque() {
//        Integer[] array = new Integer[] { 1, 2, 2, 3, 4, 4, 7, 1, 5, 6, 0 };
//
//        Deque<Integer> deque = new LinkedList<>(Arrays.asList(array));
//
//        System.out.println(deque.toString());
//
//        while (!deque.isEmpty()) {
//            System.out.println(deque.peekFirst());
//
//            deque.pollFirst();
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Map [MAP] [TREE_MAP] [LINKED_HASH_MAP]
//    // [MAP] ==> put -- putAll -- remove - get - containsKey - keySet - entrySet
//    // [TREE_MAP] ==> {containsKey -- get -- put -- remove -- log(n)} -- containsValue -- firstKey - lastKey
//    static class MapComparator implements Comparator<Integer> {
//        public int compare(Integer A, Integer B) {
//            return B - A;
//        }
//    }
//
//    public static void implementMap() {
//        Integer[] array = new Integer[] { 1, 2, 2, 3, 4, 4, 7, 1, 5, 6, 0 };
//
//        Map<Integer, Integer> map = new TreeMap<>(new MapComparator());
//
//        List<Integer> list = new ArrayList<>(Arrays.asList(array));
//
//        list.forEach(element -> map.put(element, element * element));
//
//        Set<Integer> key = map.keySet();
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//
//        entries.forEach((entry) -> {
//            System.out.println(entry.getKey() + entry.getValue());
//        });
//
//        System.out.println(key.toString());
//        System.out.println(entries.toString());
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Frequency Of Number [HASH_MAP] O(size + capacity)
//    // [HASH_MAP] ==>  compute -- computeIfAbsent -- computeIfPresent -- replace -- putIfAbsent
//    public static void frequencyOfNumber() {
//        Integer[] array = new Integer[] { 1, 2, 2, 3, 4, 4, 7, 1, 5, 6, 0 };
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        List<Integer> list = new ArrayList<>(Arrays.asList(array));
//
//        list.forEach((element) -> {
//            if (map.containsKey(element)) {
//                map.replace(element, map.get(element) + 1);
//            } else {
//                map.put(element, 1);
//            }
//        });
//
//        map.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Stream [STREAM]
//    public static void implementStream() {
//        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 7, 1, 5, 6, 0, 31, 6, 0));
//
//        Integer dividend = array.stream()
//                .filter(element -> element % 2 == 0)
//                .map(element -> element + 1)
//                .reduce(0,(answer, element) -> answer + element);
//
//        List<Integer> list = array.stream()
//                .sorted(new MapComparator())
//                .map(element -> dividend % (element + 1))
//                .collect(Collectors.toList());
//
//        System.out.println(list.toString());
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Check For Subsequence / Pattern Searching [REGEX]
//    public static void checkForSubsequence() {
//        String stringOne = "Hello RAD how are you?";
//        String stringTwo = "RAD";
//
//        System.out.println("STRING: " + stringOne);
//        System.out.println("SUB_STRING: " + stringTwo);
//
//        // Regex
//        Pattern pattern = Pattern.compile(stringTwo);
//
//        Matcher matcher = pattern.matcher(stringOne);
//
//        System.out.println("REGEX:");
//        while (matcher.find()) {
//            System.out.println(matcher.start() + " : " + (matcher.end() - 1));
//        }
//
//        // Naive Approach
//        boolean isSubstring = iterativeApproachCheckForSubsequence(stringOne, stringTwo, stringOne.length(), stringTwo.length());
//
//        System.out.println("NAIVE:");
//        if (isSubstring) {
//            System.out.println("SubString");
//        } else {
//            System.out.println("Not SubString");
//        }
//
//        // KMP Pattern Search
//        System.out.println("KMP:");
//        KMPSearching(stringOne, stringTwo);
//    }
//
//    // Naive Approach
//    public static boolean iterativeApproachCheckForSubsequence(String string, String subString, int m, int n) {
//        if (n == 0)
//            return true;
//        if (m == 0)
//            return false;
//
//        if (string.charAt(m - 1) == subString.charAt(n - 1)) {
//            return iterativeApproachCheckForSubsequence(string, subString, m - 1, n - 1);
//        }
//
//        return iterativeApproachCheckForSubsequence(string, subString, m - 1, n);
//    }
//
//    // KMP Pattern Search Algorithm
//    public static void KMPSearching(String string, String subString) {
//        int stringLength = string.length();
//        int subStringLength = subString.length();
//
//        int[] longestProperSuffix = new int[subStringLength];
//
//        // Longest Proper Suffix Preprocessor
//        computeLongestProperSuffix(subString, longestProperSuffix);
//
//        int i = 0, j = 0;
//
//        while (i < stringLength) {
//            if (string.charAt(i) == subString.charAt(j)) {
//                i++;
//                j++;
//            }
//
//            if (j == subStringLength) {
//                System.out.println("Found at " + (i - j));
//                j = longestProperSuffix[j - 1];
//            } else if (i < stringLength && string.charAt(i) != subString.charAt(j)) {
//                if (j != 0) {
//                    j = longestProperSuffix[j - 1];
//                } else {
//                    i++;
//                }
//            }
//        }
//    }
//
//    public static void computeLongestProperSuffix(String pattern, int[] longestProperSuffix) {
//        int lengthOfLPS = 0;
//        longestProperSuffix[lengthOfLPS] = 0;
//
//        int i = 1;
//
//        while (i < pattern.length()) {
//            if (pattern.charAt(i) == pattern.charAt(lengthOfLPS)) {
//                lengthOfLPS++;
//                longestProperSuffix[i] = lengthOfLPS;
//                i++;
//            } else {
//                if (lengthOfLPS != 0) {
//                    lengthOfLPS = longestProperSuffix[lengthOfLPS - 1];
//                } else {
//                    longestProperSuffix[i] = lengthOfLPS;
//                    i++;
//                }
//            }
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Count Possible Triangles [HASH_MAP<USER_DEFINED>]
//    public final static class ObjectIJ {
//        final int i;
//        final int j;
//
//        ObjectIJ(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//
//        @Override
//        public int hashCode() {
//            int i = this.i;
//            int j = this.j;
//
//            return (i + j) * j;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) {
//                return true;
//            }
//            if (obj == null) {
//                return false;
//            }
//            if (this.getClass() != obj.getClass()) {
//                return false;
//            }
//
//            ObjectIJ newObj = (ObjectIJ) obj;
//            if (this.i != newObj.i) {
//                return false;
//            }
//            if (this.j != newObj.j) {
//                return false;
//            }
//            return true;
//        }
//
//        @Override
//        public String toString() {
//            return "{i : " + this.i + ", j : " + this.j + "}";
//        }
//    }
//
//    public final static class ObjectSumDIff {
//        int sum;
//        int difference;
//
//        ObjectSumDIff(int sum, int difference) {
//            this.sum = sum;
//            this.difference = difference;
//        }
//
//        @Override
//        public String toString() {
//            return "{SUM : " + this.sum + ", DIFF : " + this.difference + "}";
//        }
//    }
//
//    public static void countPossibleTriangles() {
//        int[] array = new int[] { 6, 4, 9, 7, 8, 1, 2, 3 };
//        int arrayLength = array.length;
//
//        // A + B > C
//        // A - B < C
//        HashMap<ObjectIJ, ObjectSumDIff> map = new HashMap<ObjectIJ, ObjectSumDIff>();
//
//        for (int i = 0; i < arrayLength; i++) {
//            for (int j = 0; j < arrayLength; j++) {
//                if (i != j) {
//                    ObjectIJ key = new ObjectIJ(i, j);
//                    ObjectSumDIff value = new ObjectSumDIff(array[i] + array[j], (array[i] > array[j]) ? array[i] - array[j] : array[j] - array[i]);
//
//                    map.put(key, value);
//                }
//            }
//        }
//
//        int count = 0;
//
//        for (int k = 0; k < arrayLength; k++) {
//            for (Map.Entry<ObjectIJ, ObjectSumDIff> entry : map.entrySet()) {
//                ObjectIJ key = entry.getKey();
//                ObjectSumDIff value = entry.getValue();
//
//                if (key.i != k && key.j != k) {
//                    if (array[k] < value.sum && array[k] > value.difference) {
//                        count++;
//                    }
//                }
//            }
//        }
//
//        System.out.println(count / 6);
//
//        Arrays.sort(array);
//
//        count = 0;
//
//        for (int i = arrayLength - 1; i > 1; i--) {
//            int j = 0, k = i - 1;
//            while (j < k) {
//                if (array[j] + array[k] > array[i]) {
//                    count += k - j;
//                    k--;
//                } else {
//                    j++;
//                }
//            }
//        }
//
//        System.out.println(count);
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Find Triplets With Zero Sum
//    public static void findTripletsWithZeroSum() {
//        int[] array = new int[] { 0, -1, 2, -3, 1 };
//        int arrayLength = array.length;
//
//        Arrays.sort(array);
//
//        boolean result = findTripletsWithZeroSumUtil(array, arrayLength);
//
//        if (result) {
//            System.out.println("Triplets Found!");
//        } else {
//            System.out.println("No Triplets Found!");
//        }
//    }
//
//    public static boolean findTripletsWithZeroSumUtil(int[] array, int arrayLength) {
//        for (int i = 0; i < arrayLength - 1; i++) {
//            int j = i + 1, k = arrayLength - 1;
//            while (j < k) {
//                int sum = array[i] + array[j] + array[k];
//
//                if (sum == 0) {
//                    return true;
//                } else if (sum < 0) {
//                    j++;
//                } else {
//                    k--;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Largest SubArray With Zero Sum [HASH_MAP]
//    public static void largestSubArrayWithSumZero() {
//        int[] array = new int[] { 15, -2, 2, -8, 1, 7, 10, 23 };
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int sum = 0, maximumLength = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            sum += array[i];
//
//            if (sum == 0) {
//                maximumLength = i + 1;
//            }
//
//            if (map.containsKey(sum)) {
//                int beginning = map.get(sum);
//                if (maximumLength < i - beginning) {
//                    maximumLength = i - beginning;
//                }
//            } else {
//                map.put(sum, i);
//            }
//        }
//
//        System.out.println(maximumLength);
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Count SubArrays With Equal Number Of Ones And Zeros
//    public static void countSubArraysWithEqualOneZero() {
//        int[] arr = { 1, 0, 0, 1, 0, 1, 1 };
//        int n = arr.length;
//
//        int sum = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            sum += (arr[i] == 0)? -1: 1;
//
//            if (map.containsKey(sum)) {
//                map.replace(sum, map.get(sum) + 1);
//            } else {
//                map.put(sum, 1);
//            }
//        }
//
//        int count = 0;
//
//        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//            if (entry.getValue() > 1) {
//                int freq  = entry.getValue();
//                count += (freq * (freq - 1)) / 2;
//            }
//        }
//
//        if (map.containsKey(0)) {
//            count += map.get(0);
//        }
//
//        System.out.println(count);
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Max Sum In Configuration [SUM = SUM(i*ARRAY[i])]
//    // Preprocessor Algorithm
//    // R0 = 0*ARRAY[0] + 1*ARRAY[1] .... (n-1)*ARRAY[n-1]
//    // R1 = 0*ARRAY[n-1] + 1*ARRAY[0] .... (n-1)*ARRAY[n-2]
//    // R1 - R0 = ARRAY[0] + ARRAY[1] .... + ARRAY[n-2] - (n-1)*ARRAY[n-1]
//    // R1 - R0 = ARRAY[0] + ARRAY[1] .... + ARRAY[n-2] + ARRAY[n-1] - n*ARRAY[n-1]
//    // R1 = R0 + SUM[ARRAY[i]] - n*ARRAY[n-1]
//    // Rj = Rj-1 + SUM[ARRAY[j]] - n*ARRAY[n-j]
//
//    // ################################################################################
//    // ################################################################################
//
//    // Find Duplicates In Array [ARRAY=0->(n-1)]
//    public static void findDuplicatesInSubArray() {
//        int[] array = new int[] { 2, 3, 1, 2, 3 };
//        int arrayLength = array.length, flag = 0;
//
//        for (int i = 0; i < arrayLength; i++) {
//            array[array[i] % arrayLength] = array[array[i] % arrayLength] + arrayLength;
//        }
//
//        for (int i = 0; i < arrayLength; i++) {
//            if ((array[i] / arrayLength) > 1) {
//                System.out.print(i + " ");
//                flag = 1;
//            }
//        }
//
//        if (flag == 0) {
//            System.out.print("-1");
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Merge Sort
//    public static void implementMergeSort() {
//        int arr[] = { 12, 11, 13, 5, 6, 7 };
//
//        System.out.println(Arrays.toString(arr));
//
//        mergeSort(arr, 0 , arr.length - 1);
//
//        System.out.println(Arrays.toString(arr));
//    }
//
//    public static void mergeSort(int[] arr, int start, int end) {
//        if (start < end) {
//            int mid = (start + end) / 2;
//
//            mergeSort(arr, start, mid);
//            mergeSort(arr, mid + 1, end);
//
//            merge(arr, start, mid, end);
//        }
//    }
//
//    public static void merge(int[] arr, int start, int mid, int end) {
//        int[] leftArr = Arrays.copyOfRange(arr, start, mid + 1);
//        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, end + 1);
//
//        int i = 0, j = 0, k = start;
//        while(i < leftArr.length && j < rightArr.length) {
//            if(leftArr[i] <= rightArr[j]) {
//                arr[k++] = leftArr[i++];
//            } else {
//                arr[k++] = rightArr[j++];
//            }
//        }
//
//        while(i < leftArr.length) {
//            arr[k++] = leftArr[i++];
//        }
//
//        while(j < rightArr.length) {
//            arr[k++] = rightArr[j++];
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Count Inversions In Array [MERGE_SORT]
//    public static void countInversionsInArray() {
//        int[] array = { 1, 20, 6, 4, 5 };
//
//        int inversionCount = mergeSortCountInversion(array, 0, array.length - 1);
//
//        System.out.println(inversionCount);
//    }
//
//    public static int mergeSortCountInversion(int[] array, int start, int end) {
//        int inversionCount = 0;
//
//        if (start < end) {
//            int mid = (start + end) / 2;
//
//            inversionCount += mergeSortCountInversion(array, start, mid);
//            inversionCount += mergeSortCountInversion(array, mid + 1, end);
//            inversionCount += mergeCountInversion(array, start, mid, end);
//        }
//
//        return inversionCount;
//    }
//
//    public static int mergeCountInversion(int[] array, int start, int mid, int end) {
//        int i = 0, j = 0, k = start, inversionCount = 0;
//
//        int[] leftSubArray = Arrays.copyOfRange(array, start, mid + 1);
//        int[] rightSubArray = Arrays.copyOfRange(array, mid + 1, end + 1);
//
//        while (i < leftSubArray.length && j < rightSubArray.length) {
//            if (leftSubArray[i] <= rightSubArray[j]) {
//                array[k++] = leftSubArray[i++];
//            } else {
//                array[k++] = rightSubArray[j++];
//                inversionCount += (mid + 1) - (start + i);
//            }
//        }
//
//        while (i < leftSubArray.length) {
//            array[k++] = leftSubArray[i++];
//        }
//
//        while (j < rightSubArray.length) {
//            array[k++] = rightSubArray[j++];
//        }
//
//        return  inversionCount;
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Max Sum With No Adjacent Elements
//    public static void maxSumWithNoAdjacentElements() {
//        int[] arr = { 5, 5, 10, 100, 10, 5 };
//
//        int previousExclusive = 0;
//        int previousInclusive = arr[0];
//
//        for (int i = 1; i < arr.length; i++) {
//            int temp = Math.max(previousExclusive, previousInclusive);
//            previousInclusive = previousExclusive + arr[i];
//            previousExclusive = temp;
//        }
//
//        System.out.println(Math.max(previousExclusive, previousInclusive));
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Bubble Sort
//    public static void implementBubbleSort() {
//        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
//        int n = arr.length;
//
//        System.out.println(Arrays.toString(arr));
//
//        boolean swapped;
//        for (int i = 0; i < n - 1; i++)
//        {
//            swapped = false;
//            for (int j = 0; j < n - i - 1; j++)
//            {
//                if (arr[j] > arr[j + 1])
//                {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//
//                    swapped = true;
//                }
//            }
//
//            if (swapped == false) {
//                break;
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));
//    }
//
//
//    // ################################################################################
//    // ################################################################################
//
//    // Rotation Count In Rotated Sorted Array [BINARY_SEARCH]
//    public static void findRotationCountInSortedArray() {
//        int[] arr = { 1, 2, 3, 4 }; //{ 15, 18, 2, 3, 6, 12 };
//        int n = arr.length;
//
//        int k = binarySearchForK(arr, 0, n-1);
//
//        System.out.println(k);
//    }
//
//    public static int binarySearchForK(int[] arr, int start, int end) {
//        if (start > end) {
//            return 0;
//        }
//
//        if (start == end) {
//            return end;
//        }
//
//        int mid = (start + end) / 2;
//
//        if (mid < end && arr[mid+1] < arr[mid]) {
//            return mid + 1;
//        }
//
//        if (mid > start && arr[mid-1] > arr[mid]) {
//            return mid;
//        }
//
//        if (arr[end] > arr[mid]) {
//            return binarySearchForK(arr, start, mid - 1);
//        } else {
//            return binarySearchForK(arr, mid + 1, end);
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Peak Element [BINARY_SEARCH]
//    public static void findPeakElement() {
//        int[] arr = {1, 3, 20, 4, 1, 0};
//        int n = arr.length;
//
//        System.out.println(binarySearchForPeakElement(arr, 0, n-1, n));
//    }
//
//    public static int binarySearchForPeakElement(int[] arr, int start, int end, int size) {
//        int mid = (start + end) / 2;
//
//        if ((mid == 0 || arr[mid-1] < arr[mid]) && (mid == size || arr[mid] > arr[mid+1])) {
//            return mid;
//        } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
//            return binarySearchForPeakElement(arr, start, mid, size);
//        } else {
//            return binarySearchForPeakElement(arr, mid + 1, end, size);
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Counting Elements In Two Arrays [BINARY_SEARCH]
//    public static void countElementsInTwoArrays() {
//        int[] arrayOne = { 1, 2, 3, 4 ,7 , 9 };
//        int[] arrayTwo = { 0, 1, 2, 1, 1, 4 };
//
//        Arrays.sort(arrayTwo);
//
//        for (int i = 0; i < arrayOne.length; i++) {
//            System.out.print(i);
//            arrayOne[i] = binarySearchForCountingElements(arrayOne[i], arrayTwo, 0, arrayTwo.length - 1);
//        }
//
//        System.out.print(Arrays.toString(arrayOne));
//    }
//
//    public static int binarySearchForCountingElements(int i, int[] array, int start, int end) {
//        if (end == 0) {
//            return 0;
//        }
//
//        if (start == end) {
//            return end + 1;
//        }
//
//        int mid = (start + end) / 2;
//
//        if (array[mid] == i || (mid < array.length - 1 && array[mid] < i && array[mid + 1] > i)) {
//            int j = mid;
//            while (j < array.length - 1 && array[j + 1] == i) {
//                j++;
//            }
//
//            return j + 1;
//        } else if (array[mid] < i ) {
//            return binarySearchForCountingElements(i, array, mid+1, end);
//        } else {
//            return binarySearchForCountingElements(i, array, start, mid);
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // SubArray With Given Sum
//    public static void subArrayWithGivenSum() {
//        int[] array = { 5, 7, 1, 2 };
//        int sum = 15;
//
//        subArrayWithGivenSumUtil(array, array.length, sum);
//    }
//
//    public static void subArrayWithGivenSumUtil(int[] m, int n, int s) {
//        if (m[0] > s) {
//            System.out.print(-1);
//        }
//
//        int i = 0, j = 1, sum = m[0], flag = 0;
//
//        while (i < j) {
//            if (sum < s && j != n) {
//                sum += m[j];
//                j++;
//            } else if (sum > s) {
//                sum -= m[i++];
//            }
//
//            if (sum == s) {
//                System.out.print((i + 1) + " " + j);
//                flag = 1;
//                break;
//            }
//        }
//
//        if (flag == 0) {
//            System.out.print(-1);
//        }
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Quick Sort
//    public static void implementQuickSort() {
//        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
//        int n = arr.length;
//
//        System.out.println(Arrays.toString(arr));
//
//        quickSort(arr, 0 , n - 1);
//
//        System.out.println(Arrays.toString(arr));
//    }
//
//    public static void quickSort(int[] arr, int start, int end) {
//        if (start < end) {
//            int partitionIndex = getPartitionQuickSort(arr, start, end);
//
//            quickSort(arr, start, partitionIndex - 1);
//            quickSort(arr, partitionIndex + 1, end);
//        }
//    }
//
//    public static int getPartitionQuickSort(int[] arr, int start, int end) {
//        int pivot = arr[end];
//
//        int i = start - 1;
//
//        for (int j = start; j < end; j++) {
//            if (arr[j] < pivot) {
//                i++;
//                swapQuickSort(arr, i, j);
//            }
//        }
//
//        swapQuickSort(arr, i + 1, end);
//
//        return i + 1;
//    }
//
//    public static void swapQuickSort(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Heap Sort [MIN_HEAP]
//    public static void implementHeapSort() {
//        int[] array = { 12, 11, 13, 5, 6, 7 };
//
//        System.out.println(Arrays.toString(array));
//
//        heapSort(array);
//
//        System.out.println(Arrays.toString(array));
//
//    }
//
//    public static void heapSort(int[] array) {
//        int arrayLength = array.length;
//
//        for (int i = (arrayLength / 2) - 1; i >= 0; i--) {
//            heapify(array, arrayLength, i);
//        }
//
//        for (int i = arrayLength - 1; i > 0; i--) {
//            swapHeapSort(array, i, 0);
//
//            heapify(array, arrayLength, 0);
//        }
//    }
//
//    public static void heapify(int[] array, int size, int i) {
//        int largest = i;
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//
//        if (left < size && array[left] < array[largest]) {
//            largest = left;
//        }
//
//        if (right < size && array[right] < array[largest]) {
//            largest = right;
//        }
//
//        if (largest != i) {
//            swapHeapSort(array, largest, i);
//
//            heapify(array, size, largest);
//        }
//    }
//
//    public static void swapHeapSort(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Interleaved Strings [RECURSION]
//    public static void checkForInterleavedStrings() {
//        String A = "XY", B = "X", C = "XXY";
//
//        if (A.length() + B.length() != C.length()) {
//            System.out.println("NOT INTERLEAVED");
//        }
//
//        boolean result = checkForInterleavedStringsUtil(A, B, C, 0, 0, 0);
//
//        if (result) {
//            System.out.println("INTERLEAVED");
//        } else {
//            System.out.println("NOT INTERLEAVED");
//        }
//    }
//
//    public static boolean checkForInterleavedStringsUtil(String A, String B, String C, int i, int j, int k) {
//        if (k == C.length()) {
//            return true;
//        }
//
//        boolean x = false, y = false;
//
//        if (i < A.length() && A.charAt(i) == C.charAt(k)) {
//            x = checkForInterleavedStringsUtil(A, B, C, i + 1, j, k + 1);
//        }
//
//        if (j < B.length() && B.charAt(j) == C.charAt(k)) {
//            y = checkForInterleavedStringsUtil(A, B, C, i, j + 1, k + 1);
//        }
//
//        return x || y;
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Length Encoding
//    public static void runLengthEncoding() {
//        String string = "aaaabbbccc";
//
//        int i = 0, j = 1, count = 1;
//
//        String encoded = "";
//
//        while (i < j) {
//            if (i == string.length() || j == string.length()) {
//                encoded += string.charAt(i);
//                encoded += count;
//                break;
//            }
//
//            if (string.charAt(i) == string.charAt(j)) {
//                count++;
//                j++;
//            } else {
//                encoded += string.charAt(i);
//                encoded += count;
//                count = 1;
//                i = j;
//                j = i + 1;
//            }
//        }
//
//        System.out.println(encoded);
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Power Set
//    public static void powerSetBitWise() {
//        char[] set = { 'a', 'b', 'c' };
//
//        long powerSetSize = (long)Math.pow(2, set.length);
//
//        String superSet = "";
//
//        for (long i = 0; i < powerSetSize; i++) {
//            for (int j = 0; j < set.length; j++) {
//                if ((i & (1 << j)) > 0) {
//                    superSet += set[j];
//                }
//            }
//            superSet += " ";
//        }
//
//        System.out.println(superSet);
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//    // Power Set [RECURSION]
//    public static void powerSetRecursion() {
//        String string = "abc";
//
//        String superSet = "";
//
//        superSet = powerSetRecursionUtil(string, "", -1, superSet);
//
//        System.out.println(superSet);
//    }
//
//    public static String powerSetRecursionUtil(String string, String current, int index, String superSet) {
//        if (index == string.length()) {
//            return superSet;
//        }
//
//        superSet += current + " ";
//
//        for (int j = index + 1; j < string.length(); j++) {
//            current += string.charAt(j);
//
//            superSet = powerSetRecursionUtil(string, current, j, superSet);
//
//            current = current.substring(0, current.length() - 1);
//        }
//
//        return superSet;
//    }
//
//    // ################################################################################
//    // ################################################################################
//
//
//    // ################################################################################
//    // ################################################################################
//
//    // Find Missing Number
//    public static void findMissingNumber() {
//        int[] a = { 1, 2, 3, 4, 5, 6, 7, 9 };
//
//        int sumOfAllNumbers = (a.length + 1) * (a.length + 2) / 2;
//
//        for (int i = 0; i < a.length; i++) {
//            sumOfAllNumbers -= a[i];
//        }
//
//        System.out.println("Missing Number is : " + sumOfAllNumbers);
//    }
//}
