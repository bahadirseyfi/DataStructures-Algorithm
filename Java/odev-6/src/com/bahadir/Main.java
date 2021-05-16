package com.bahadir;

public class Main {

    public static void main(String[] args) {

        // Soru - 1

        int [] a = new int [] {2, 4, 5, 6, 7, 8, 10, 11, 13, 15, 19, 20};
        int [] b = new int [] {35,32, 31, 20, 16, 14, 11, 8, 5, 4, 3, 1};
        int [] c = new int [] {5, 2, 13, 9, 1, 7, 6, 8, 1, 15, 4, 11};
        char [] d = new char[] {'S','B','I','M','H','Q','C','L','R','E','P','K'};

        MergeSort.mergeSort(b,b.length);
        System.out.println("B DİZİSİ:");
        yazdirmFunc(b);

        System.out.println("C DİZİSİ:");
        HeapSort.heapSort(c);
        yazdirmFunc(c);

        // Soru - 2




    }

    public static void yazdirmFunc(int[] dizi) {
        for (int i = 0; i< dizi.length;i++){
            System.out.println(dizi[i]+" ");
        }
    }
}