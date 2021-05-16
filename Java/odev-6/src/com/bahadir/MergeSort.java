package com.bahadir;

public class MergeSort {

    public static void merge(int[] left_arr, int[] right_arr, int[] arr, int left_size, int right_size) {
        int i = 0, l = 0, r = 0;

        // while döngüleri birleştirme koşullarını kontrol eder

        while (l < left_size && r < right_size) {

            if (left_arr[l] < right_arr[r]) {
                arr[i++] = left_arr[l++];
            } else {
                arr[i++] = right_arr[r++];
            }
        }
        while (l < left_size) {
            arr[i++] = left_arr[l++];
        }
        while (r < right_size) {
            arr[i++] = right_arr[r++];
        }
    }
    public static void mergeSort(int[] arr, int len) {
        if (len < 2) {
            return;
        }

        int mid = len / 2;
        int[] left_arr = new int[mid];
        int[] right_arr = new int[len - mid];

        // Diziyi ikiye böleriz ve iki ayrı diziye kopyalarız
        int k = 0;
        for (int i = 0; i < len; ++i) {
            if (i < mid) {
                left_arr[i] = arr[i];
            } else {
                right_arr[k] = arr[i];
                k = k + 1;
            }
        }
        /*
        Tabii, burada bölme ve bireştirme işlemleri özyinelidir. Süreç bitene kadar bölme ve bireştirme işlemleri devam eder.
 İstersek bölme ve bireştirme işlemlerini yapan kodları bir metotta bir araya getirebiliriz.
         */
        // Alt dizileri daha fazla bölmek için fonksiyonu rekürsif olarak çağırırız
        mergeSort(left_arr, mid);
        mergeSort(right_arr, len - mid);
        // Her bölümdeki merge fonksiyonunu çağırırız
        merge(left_arr, right_arr, arr, mid, len - mid);
    }
    public static long expected_runtime(int arr_length){
        long n = arr_length;
        return n*n + 5;
    }
}
