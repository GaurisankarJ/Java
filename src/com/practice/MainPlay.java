//package com.practice;
//
//public class MainPlay {
//    // public class Main {
//    // public static void main(String[] args) throws IOException {
//    //     Play.HackerEarth();
//    // }
//
//    // Q1
//    // public static void main(String[] args) throws IOException {
//    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    //     PrintWriter wr = new PrintWriter(System.out);
//    //     int N = Integer.parseInt(br.readLine().trim());
//    //     String[] S = new String[N];
//    //     for (int i_S = 0; i_S < N; i_S++) {
//    //         S[i_S] = br.readLine().trim();
//    //     }
//
//    //     String[] out_ = Play.solve(S, N);
//    //     wr.println(out_.length);
//    //     for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
//    //         wr.println(out_[i_out_]);
//    //     }
//
//    //     wr.close();
//    //     br.close();
//    // }
//
//    // Q2
//    // public static void main(String[] args) throws IOException {
//    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    //     PrintWriter wr = new PrintWriter(System.out);
//    //     int N = Integer.parseInt(br.readLine().trim());
//    //     int[] A = new int[N];
//    //     String[] inp = br.readLine().split(" ");
//    //     for (int i = 0; i < N; i++) {
//    //         A[i] = Integer.parseInt(inp[i]);
//    //     }
//    //     int out_ = Play.solve(N, A);
//    //     wr.println(out_);
//
//    //     wr.close();
//    //     br.close();
//    // }
//
//    // Q6
//    // public static void main(String[] args) throws IOException {
//    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    //     PrintWriter wr = new PrintWriter(System.out);
//    //     String S = br.readLine().trim();
//    //     String out_ = Play.solve(S);
//    //     wr.println(out_);
//    //     wr.close();
//    //     br.close();
//    // }
//
//    // Q4
//    // public static void main(String[] args) throws IOException {
//    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    //     PrintWriter wr = new PrintWriter(System.out);
//    //     int N = Integer.parseInt(br.readLine().trim());
//    //     int[] A = new int[N];
//    //     String[] inp = br.readLine().split(" ");
//    //     for (int i = 0; i < N; i++) {
//    //         A[i] = Integer.parseInt(inp[i]);
//    //     }
//
//    //     int out_ = Play.solve(A, N);
//    //     System.out.println(out_);
//    //     wr.close();
//    //     br.close();
//    // }
//
//    // N in M ways
//    // public static void main(String[] args) throws IOException {
//    //     Scanner scan = new Scanner(System.in);
//
//    //     String T = scan.nextLine();
//    //     int[] diff = new int[Integer.parseInt(T)];
//
//    //     for (int i = 0; i < Integer.parseInt(T); i++) {
//    //         String[] nm = scan.nextLine().split(" ");
//    //         String[] c = scan.nextLine().split(" ");
//
//    //         int N = Integer.parseInt(nm[0]);
//    //         int M = Integer.parseInt((nm[1]));
//    //         int[] C = new int[N];
//    //         int j = 0;
//    //         for (String str : c) {
//    //             C[j++] = Integer.parseInt(str);
//    //         }
//
//    //         diff[i] = Play.NinM(N, M, C);
//    //     }
//
//    //     for (int i = 0; i < Integer.parseInt(T); i++) {
//    //         System.out.println(diff[i]);
//    //     }
//    // }
//
//    // Kadane's Algorithm (Max Contiguous Sum)
//    // public static void main(String[] args) throws IOException {
//    //     int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
//    //     System.out.println("Maximum Contiguous Sum : " + Play.maxSubArraySum(a));
//    // }
//
//    // HackerRank Interview Preparation
//    // Sock Merchant
//    // public static void main(String[] args) throws IOException {
//    //     Scanner scanner = new Scanner(System.in);
//
//    //     int n = scanner.nextInt();
//    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //     int[] ar = new int[n];
//
//    //     String[] arItems = scanner.nextLine().split(" ");
//    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //     for (int i = 0; i < n; i++) {
//    //         int arItem = Integer.parseInt(arItems[i]);
//    //         ar[i] = arItem;
//    //     }
//
//    //     int result = Play.sockMerchant(n, ar);
//
//    //     System.out.println(String.valueOf(result));
//
//    //     scanner.close();
//    // }
//
//    // Counting Valleys
//    // public static void main(String[] args) throws IOException {
//    //     Scanner scanner = new Scanner(System.in);
//
//    //     int n = scanner.nextInt();
//    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //     String s = scanner.nextLine();
//
//    //     int result = Play.countingValleys(n, s);
//
//    //     System.out.println(String.valueOf(result));
//
//    //     scanner.close();
//    // }
//
//    // Jumping on the Clouds
//    // public static void main(String[] args) throws IOException {
//    //     Scanner scanner = new Scanner(System.in);
//
//    //     int n = scanner.nextInt();
//    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //     int[] c = new int[n];
//
//    //     String[] cItems = scanner.nextLine().split(" ");
//    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //     for (int i = 0; i < n; i++) {
//    //         int cItem = Integer.parseInt(cItems[i]);
//    //         c[i] = cItem;
//    //     }
//
//    //     int result = Play.jumpingOnClouds(c);
//
//    //     System.out.println(String.valueOf(result));
//
//    //     scanner.close();
//    // }
//
//    // Repeated Strings
//    // public static void main(String[] args) throws IOException {
//    //     Scanner scanner = new Scanner(System.in);
//
//    //     String s = scanner.nextLine();
//
//    //     long n = scanner.nextLong();
//    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //     long result = Play.repeatedString(s, n);
//
//    //     System.out.println(String.valueOf(result));
//
//    //     scanner.close();
//    // }
//
//    // 2D Array
//    // public static void main(String[] args) throws IOException {
//    //     Scanner scanner = new Scanner(System.in);
//
//    //     int[][] arr = new int[6][6];
//
//    //     for (int i = 0; i < 6; i++) {
//    //         String[] arrRowItems = scanner.nextLine().split(" ");
//    //         scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //         for (int j = 0; j < 6; j++) {
//    //             int arrItem = Integer.parseInt(arrRowItems[j]);
//    //             arr[i][j] = arrItem;
//    //         }
//    //     }
//
//    //     int result = Play.hourglassSum(arr);
//
//    //     System.out.println(String.valueOf(result));
//
//    //     scanner.close();
//    // }
//
//    // Arrays: Left Rotation
//    // public static void main(String[] args) throws IOException {
//    //     Scanner scanner = new Scanner(System.in);
//
//    //     String[] nd = scanner.nextLine().split(" ");
//
//    //     int n = Integer.parseInt(nd[0]);
//
//    //     int d = Integer.parseInt(nd[1]);
//
//    //     int[] a = new int[n];
//
//    //     String[] aItems = scanner.nextLine().split(" ");
//    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //     for (int i = 0; i < n; i++) {
//    //         int aItem = Integer.parseInt(aItems[i]);
//    //         a[i] = aItem;
//    //     }
//
//    //     int[] result = Play.rotLeft(a, d);
//
//    //     for (int i = 0; i < result.length; i++) {
//    //         System.out.println(String.valueOf(result[i]));
//
//    //         if (i != result.length - 1) {
//    //             System.out.println(" ");
//    //         }
//    //     }
//
//    //     scanner.close();
//    // }
//
//    // New Year Chaos
//    // public static void main(String[] args) throws IOException {
//    //     Scanner scanner = new Scanner(System.in);
//
//    //     int t = scanner.nextInt();
//    //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //     for (int tItr = 0; tItr < t; tItr++) {
//    //         int n = scanner.nextInt();
//    //         scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //         int[] q = new int[n];
//
//    //         String[] qItems = scanner.nextLine().split(" ");
//    //         scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    //         for (int i = 0; i < n; i++) {
//    //             int qItem = Integer.parseInt(qItems[i]);
//    //             q[i] = qItem;
//    //         }
//
//    //         Play.minimumBribes(q);
//    //     }
//
//    //     scanner.close();
//    // }
//
//    // Find Number of Sub-arrays with Even Sum
//    // public static void main(String[] args) {
//    //     int arr[] = { 1, 2, 2, 3, 4, 1 };
//
//    //     System.out.println("The Number of Sub-arrays with Even Sum is: " + Play.findEvenSumSubArrays(arr));
//    // }
//    // }
//}
