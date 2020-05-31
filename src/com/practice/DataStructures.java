package com.practice;

// Java Basics
// https://www.geeksforgeeks.org/java-programming-basics/?ref=lbp
// Complexity
// https://www.bigocheatsheet.com/

import java.util.*;

public class DataStructures {
    public static void main(String[] args) {
        // Data-types in Java
        dataTypesInJava();

        // Collections in Java
        collectionsInJava();

        // Maps in Java
        mapsInJava();
    }

    interface ExampleInterface {
        char charVar = 'a';
    }

    static class ExampleClass implements ExampleInterface{
        int intVar;
        String stringVar;

        ExampleClass() {
            intVar = 10;
            stringVar = "Name";
        }
    }

    // Data-types in Java
    // https://www.geeksforgeeks.org/data-types-in-java/
    public static void dataTypesInJava() {
        // Primitives
        boolean boolVar;
        byte byteVar;
        short shortVar;
        int intVar;
        long longVar;
        float floatVar;
        double doubleVar;
        char charVar;

        System.out.println("PRIMITIVES");
        System.out.println("Data-type   Size                    Value");
        System.out.println("boolean     VM Dependant            true, false");
        System.out.println("byte        1 byte ( 8 bits )       -128 to 127");
        System.out.println("short       2 byte ( 16 bits )      -32,768 to 32,767 (inclusive)");
        System.out.println("int         4 byte ( 32 bits )      -2,147,483,648 to 2,147,483,647 (inclusive)");
        System.out.println("long        8 byte ( 64 bits )      -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (inclusive)");
        System.out.println("float       4 byte ( 32 bits )      upto 7 decimal digits");
        System.out.println("double      8 byte ( 62 bits )      upto 16 decimal digits");
        System.out.println("char        2 byte ( 16 bits )      '\\u0000' (0) to '\\uffff' (65535)");

        // Non-primitives
        // Strings
        // https://www.geeksforgeeks.org/strings-in-java/
        String stringVar;
        // Class and Object
        // https://www.geeksforgeeks.org/classes-objects-java/
        ExampleClass classVar = new ExampleClass();
        // Interface
        // https://www.geeksforgeeks.org/interfaces-in-java/
        char finalPublicStatic = classVar.charVar;
        // Array
        // https://www.geeksforgeeks.org/arrays-in-java/
        String[] stringArray = new String[10];

        System.out.println("\nNON-PRIMITIVES");
        System.out.println("String");
        System.out.println("Class and Object");
        System.out.println("Interface");
        System.out.println("Array");
    }

    // Collections in Java
    // https://www.geeksforgeeks.org/collections-in-java-2/
    public static void collectionsInJava() {
        // Set
        // https://www.geeksforgeeks.org/set-in-java/
        // HashSet
        Set<Integer> hashSet = new HashSet<>();
        // TreeSet
        Set<Integer> treeSet = new TreeSet<>();
        // LinkedHashSet
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        // List
        // https://www.geeksforgeeks.org/list-interface-java-examples/
        // ArrayList
        List<Integer> arrayList = new ArrayList<>();
        // LinkedList
        List<Integer> linkedList = new LinkedList<>();
        // Vector
        List<Integer> vector = new Vector<>();
        // Stack
        List<Integer> stack = new Stack<>();

        // Queue
        // https://www.geeksforgeeks.org/queue-interface-java/
        // Priority Queue
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        // Queue
        Queue<Integer> queue = new LinkedList<>();

        // Deque
        // https://www.geeksforgeeks.org/deque-interface-java-example/
        Deque<Integer> deque = new LinkedList<>();

        System.out.println("\nCOLLECTIONS");
        System.out.println("Set - HashSet, TreeSet and LinkedHashSet");
        System.out.println("List - ArrayList, LinkedList, Vector and Stack");
        System.out.println("Queue - Queue(LinkedList) and PriorityQueue");
        System.out.println("Deque");
    }

    // Maps in Java
    // https://www.geeksforgeeks.org/map-interface-java-examples/
    public static void mapsInJava() {
        // Map
        // HashMap
        Map<Integer, Integer> hashMap = new HashMap<>();
        // TreeMap
        Map<Integer, Integer> treeMap = new TreeMap<>();
        // LinkedHashMap
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        System.out.println("\nMAPS");
        System.out.println("Map - HashMap, TreeMap and LinkedHashMap");
    }
}
