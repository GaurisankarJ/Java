package com.practice;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class StringBased {
    public static void main(String[] args) {
        // Implement AtoI
//        implementAToI();

        // Multiply Two Strings
//        multiplyTwoStrings();

        // KMP Algorithm For Pattern Searching
//        KMPPatternSearch();

        // Rabin-Karp Algorithm For Pattern Searching
//        RabinKarpPatternSearching();

        // Validate An IP Address
//        validateAnIPAddress();

        // Interleaved Strings
//        checkInterLeavedStrings();
    }

    // Implement AtoI
    // https://www.geeksforgeeks.org/write-your-own-atoi/
    // I/P : S = "-5789" (String)
    // O/P : -5789 (int)
    public static void implementAToI() {
        String S = "-5789";

        int number = 0, multiplier = 1;

        if (S.charAt(0) == '-') {
            S = S.substring(1);
            multiplier *= -1;
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            int temp = S.charAt(i) - '0';

            if (temp < 0 || temp > 9) {
                System.out.println(-1);
                return;
            }

            number += temp * multiplier;
            multiplier *= 10;
        }

        System.out.println(number);
    }

    // Multiply Two Strings
    // https://www.geeksforgeeks.org/multiply-large-numbers-represented-as-strings/
    // I/P : A = "654154154151454545415415454", B = "63516561563156316545145146514654"
    // O/P : 41549622603955309777243716069997997007620439937711509062916
    public static void multiplyTwoStrings() {
        String A = "654154154151454545415415454";
        String B = "63516561563156316545145146514654";

        BigInteger C = new BigInteger(A).multiply(new BigInteger(B));
        System.out.println(C);
    }

    // KMP Algorithm For Pattern Searching
    // https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
    // I/P : STRING = "ABABDABACDABABCABAB", PATTERN = "ABABCABAB"
    // O/P : 10
    public static void KMPPatternSearch() {
        String STRING = "ABABDABACDABABCABAB";
        String PATTERN = "ABABCABAB";

        int[] longestProperSuffix = new int[PATTERN.length()];

        longestProperSuffix[0] = 0;

        int i = 1;
        int longestProperSuffixLength = 0;
        while (i < PATTERN.length()) {
            if (PATTERN.charAt(i) == PATTERN.charAt(longestProperSuffixLength)) {
                longestProperSuffixLength++;
                longestProperSuffix[i] = longestProperSuffixLength;
                i++;
            } else {
                if (longestProperSuffixLength != 0) {
                    longestProperSuffixLength = longestProperSuffix[longestProperSuffixLength - 1];
                } else {
                    longestProperSuffix[i] = 0;
                    i++;
                }
            }
        }

        // k [S]
        // j [PATTERN]
        int k = 0, j = 0;

        while (k < STRING.length()) {
            if (STRING.charAt(k) == PATTERN.charAt(j)) {
                k++;
                j++;
            }

            if (j == PATTERN.length()) {
                System.out.println(k - j);
                return;
            } else if (k < STRING.length() && STRING.charAt(k) != PATTERN.charAt(j)){
                if (j != 0) {
                    j = longestProperSuffix[j - 1];
                } else {
                    k++;
                }
            }
        }

        System.out.println(-1);
    }

    // Rabin-Karp Algorithm For Pattern Searching
    // https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/
    // I/P : STRING = "ABABDABACDABABCABAB", PATTERN = "ABABCABAB"
    // O/P : 10
    public static void RabinKarpPatternSearching() {
        String STRING = "ABABDABACDABABCABAB";
        String PATTERN = "ABABCABAB";

        /**
         * hash(txt[(s + 1) ... (s + m)]) = (d * (hash(txt[(s) ... (s + m - 1)]) – txt[s] * h) + txt[s + m]) mod q
         * hash(txt[(s) ... (s + m - 1)]) : Hash value at shift s
         * hash(txt[(s + 1) ... (s + m)]) : Hash value at next shift (or shift s + 1)
         * d : Number of characters in the alphabet
         * q : A prime number
         * h : d ^ (m-1) mod q
         * m : Length of txt
         **/

        // q = Prime Number
        // d = 256 [Characters]
        final int q = 101, d = 256;

        int stringLength = STRING.length(), patternLength = PATTERN.length();
        int stringHash = 0, patternHash = 0;
        int h = 1;

        // h = pow(d, m-1) % q
        for (int i = 0; i < patternLength - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < patternLength; i++) {
            stringHash = (d * stringHash + STRING.charAt(i)) % q;
            patternHash = (d * patternHash + PATTERN.charAt(i)) % q;
        }

        for (int i = 0; i <= stringLength - patternLength; i++) {
            if (stringHash == patternHash) {
                int j = 0;
                while (j < patternLength) {
                    if (STRING.charAt(i + j) != PATTERN.charAt(j)) {
                        break;
                    }
                    j++;
                }

                if (j == patternLength) {
                    System.out.println(i);
                    return;
                }
            }

            if (i < stringLength - patternLength) {
                stringHash = (d * (stringHash - STRING.charAt(i) * h) + STRING.charAt(i + patternLength)) % q;

                if (stringHash < 0) {
                    stringHash += q;
                }
            }
        }

        System.out.println(-1);
    }

    // Validate An IP Address
    // https://www.geeksforgeeks.org/program-to-validate-an-ip-address/
    // I/P : IP = "12.33.56.2"
    // O/P : VALID
    public static void validateAnIPAddress() {
        String IP = "12.33.56.2";

        Set<String> ipSet = new HashSet<>();

        for (int i = 0; i < 256; i++) {
            ipSet.add(String.valueOf(i));
        }

        int countDots = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') {
                countDots++;
            }
        }

        if (countDots != 3) {
            System.out.println("INVALID");
            return;
        }

        // [.]+
        // \\.
        String[] ipArray = IP.split("\\.");
        if (ipArray.length != 4) {
            System.out.println("INVALID");
            return;
        }

        for (String ip: ipArray) {
            if (!ipSet.contains(ip)) {
                System.out.println("INVALID");
                return;
            }
        }

        System.out.println("VALID");
    }

    // Interleaved Strings
    // https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/
    // I/P : A = "XXY", B = "XXZ", C = "XXYXXZ"
    // O/P : true
    public static void checkInterLeavedStrings() {
        String A = "XXY", B = "XXZ", C = "XXYXXZ";

        int a = A.length();
        int b = B.length();
        int c = C.length();

        if (a + b != c) {
            System.out.print(false);
            return;
        }

        if (checkInterLeavedStringsUtil(A, B, C, 0, 0, 0)) {
            System.out.print(true);
        } else {
            System.out.print(false);
        }
    }

    public static boolean checkInterLeavedStringsUtil(String A, String B, String C, int i, int j, int k) {
        if (k == C.length()) {
            return true;
        }

        boolean resultA = false, resultB = false;

        if (i != A.length() && A.charAt(i) == C.charAt(k)) {
            resultA = checkInterLeavedStringsUtil(A, B, C, i + 1, j, k + 1);
        }

        if (j != B.length() && B.charAt(j) == C.charAt(k)) {
            resultB = checkInterLeavedStringsUtil(A, B, C, i, j + 1, k + 1);
        }

        return resultA || resultB;
    }

}

