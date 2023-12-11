package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        for (int count: new int[]{10, 1_000, 10_000, 1_000_000}) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            fill(arrayList, count);
            System.out.println("\n\nCount: " + count);
            System.out.print("Input array > ");
            printArray(arrayList);

            for (SortingType type: new SortingType[]{SortingType.BubbleSorter, SortingType.MergeSorter, SortingType.QuickSorter, SortingType.ShellSorter}) {
                Sorter sorter = choiceSorter(type);

                ArrayList<Integer> input = new ArrayList<>(arrayList);

                long startTime = System.currentTimeMillis();
                ArrayList<Integer> sortedList = sorter.sort(input);
                long endTime = System.currentTimeMillis();

                System.out.printf("%5dms | %s > ", endTime - startTime, type);
                printArray(sortedList);

            }
        }
    }

    public static Sorter choiceSorter(SortingType type) {
        return switch (type) {
            case BubbleSorter -> new BubbleSorter();
            case MergeSorter -> new MergeSorter();
            case QuickSorter -> new QuickSorter();
            case ShellSorter ->  new ShellSorter();
        };
    }

    private static void fill(ArrayList<Integer> arrayList, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            arrayList.add(random.nextInt(count));
        }
    }

    private static void printArray(ArrayList<Integer> arrayList) {
        int limit = Math.min(arrayList.size(), 50);
        System.out.println(arrayList.subList(0, limit));
    }
}