package com.bahadir;

public class InsertionSort {
        public static void sortInsertion(int [] sort_arr){
            for(int i=0;i<sort_arr.length;++i){
                int j = i;
                while(j > 0 && sort_arr[j-1]>sort_arr[j]){
                    int key = sort_arr[j];
                    sort_arr[j] = sort_arr[j-1];
                    sort_arr[j-1] = key;
                    j = j-1;
                }
            }
        }
    }
