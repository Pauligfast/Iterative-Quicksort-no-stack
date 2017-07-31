package com.company;


import java.util.Scanner;

public class Main {

    static Scanner inScan = new Scanner(System.in);

    public static void main(String[] args) {
        int sets = inScan.nextInt();

        for (int reps = 0; reps < sets; reps++) {
            int numofelements = inScan.nextInt();
            long[] array = new long[numofelements];

            for (int j = 0; j < numofelements; j++) {
                array[j] = inScan.nextLong();
            }
            if (numofelements <= 20) {
                insertionSort(array);
            } else {
                QuickSort(array, 0, array.length - 1);
            }
            for (long anArray : array) {
                System.out.print(Math.abs(anArray) + " ");
            }
            System.out.println();
        }
    }

    static void QuickSort(long[] array, int left, int right) {


        for (int i = 1; i <= array.length; ++i) {
            if (i == array.length)
                return;
            if (array[i] < array[i - 1])
                break;
        }


        int i = 0;

        while (left < right || i > 0) {
            if (left < right) {
                int q = partition(array, left, right);
                array[right] = -array[right];
                right = q - 1;
                i++;
            } else {
                right = left = right + 2;

                while (right < array.length) {
                    if (array[right] < 0) {
                        array[right] = -array[right];
                        break;
                    } else {
                        right++;
                    }
                }
                i--;
            }
        }
    }

    private static int partition(long[] array, int left, int right) {
        int low = left + 1, high = right;

        swap(array, left, (left + right) / 2);
        long pivot = array[left];

        while (low <= high) {
            while (array[high] > pivot)
                high--;
            while (low <= high && array[low] <= pivot)
                low++;
            if (low <= high) {
                swap(array, low, high);
                low++;
                high--;
            }
        }
        swap(array, left, high);
        return high;
    }

    static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void insertionSort(long array[]) {

        for (int j = 0; j < array.length; j++) {
            long key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;

        }
    }

}