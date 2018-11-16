package com.nathansbud.Misc;

public class SortingSearching {
    static int[] list = {-5, 8, 3, 10, 1, 2, 3, 4, 5, 0};
    public static void main(String[] args) {
        list = selectionSort(list);
        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(binarySearch(list, 0));

    }

    public static int[] bubbleSort(int[] num) {
        for(int i = 0; i < num.length - 1; i++) {
            for(int j = 0; j < num.length - 1; j++) {
                if(num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }

        return num;
    }
    public static int binarySearch(int[] num, int search) {
        int max = num.length - 1;
        int min = 0;
        int mid;

        while(max >= min) {
            mid = (max + min)/2;
            if(num[mid] < search) {
                min = mid + 1;
            } else if(num[mid] > search) {
                max = mid - 1;
            } else return mid;
        }
        return -1;
    }
    public static int[] selectionSort(int[] num) {
        int min;
        int temp;
        for(int i = 0; i < num.length; i++) {
            min = i;
            for(int j = i; j < num.length; j++) {
                if(num[j] < num[min]) {
                    min = j;
                }
            }
            temp = num[i];
            num[i] = num[min];
            num[min] = temp;
        }

        return num;
    }
}
