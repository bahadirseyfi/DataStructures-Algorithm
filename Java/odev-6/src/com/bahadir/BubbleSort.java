package com.bahadir;

    public class BubbleSort {
        static void bubbleSort(int[] arr) {
            int n = arr.length;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (arr[j - 1] > arr[j]) {
                        //swap elements
                        temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }

                }
            }
        }
        public static long expected_runtime(int arr_length){
            long n = arr_length;
            return n*n + 5;
        }
    }
