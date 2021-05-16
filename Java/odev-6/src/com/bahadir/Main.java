package com.bahadir;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        // Soru - 1

        int [] a = new int [] {2, 4, 5, 6, 7, 8, 10, 11, 13, 15, 19, 20};
        int [] b = new int [] {35,32, 31, 20, 16, 14, 11, 8, 5, 4, 3, 1};
        int [] c = new int [] {5, 2, 13, 9, 1, 7, 6, 8, 1, 15, 4, 11};
        char [] d = new char[] {'S','B','I','M','H','Q','C','L','R','E','P','K'};

        MergeSort.mergeSort(b,b.length);
        System.out.println("B DİZİSİ:");
      //  yazdirmFunc(b);

        System.out.println("C DİZİSİ:");
        HeapSort.heapSort(c);
      //  yazdirmFunc(c);

        // Soru - 2

        int[] lengths = {10000,40000,100000,150000,180000};
        double start,end;
        int [] array;
        
        for (int i = 0; i< lengths.length; i++){
            for (int j=0;j<20;j++){
                array = filling_array(new int[lengths[i]]);
                System.out.println("SELECTION SORT :");
                start = System.currentTimeMillis();
                SelectionSort.sort(array);
                end = System.currentTimeMillis();
                System.out.println("array - "+j+" = "+ Arrays.toString(array).substring(0,25));
                System.out.println("sıralama = "+Arrays.toString(array).substring(0,25));
                System.out.println("beklenen zaman = "+SelectionSort.expected_runtime(lengths[i]));
                System.out.println("gerçek zaman = "+(end-start));
                values_to_csv("selectionsort",SelectionSort.expected_runtime(lengths[i]),end-start);
            }
        }
        for (int i = 0; i< lengths.length; i++){
            for (int j=0;j<20;j++){
                array = filling_array(new int[lengths[i]]);
                System.out.println("bubblesort :");
                start = System.currentTimeMillis();
                BubbleSort.bubbleSort(array);
                end = System.currentTimeMillis();
                System.out.println("array - "+j+" = "+ Arrays.toString(array).substring(0,25));
                System.out.println("sıralama = "+Arrays.toString(array).substring(0,25));
                System.out.println("beklenen zaman = "+BubbleSort.expected_runtime(lengths[i]));
                System.out.println("gerçek zaman = "+(end-start));
                values_to_csv("bubblesort",BubbleSort.expected_runtime(lengths[i]),end-start);
            }
        }
        for (int i = 0; i< lengths.length; i++){
            for (int j=0;j<20;j++){
                array = filling_array(new int[lengths[i]]);
                System.out.println("Insertion SORT :");
                start = System.currentTimeMillis();
                InsertionSort.sortInsertion(array);
                end = System.currentTimeMillis();
                System.out.println("array - "+j+" = "+ Arrays.toString(array).substring(0,25));
                System.out.println("sıralama = "+Arrays.toString(array).substring(0,25));
                System.out.println("beklenen zaman = "+InsertionSort.expected_runtime(lengths[i]));
                System.out.println("gerçek zaman = "+(end-start));
                values_to_csv("InsertionSort",InsertionSort.expected_runtime(lengths[i]),end-start);
            }
        }
        for (int i = 0; i< lengths.length; i++){
            for (int j=0;j<20;j++){
                array = filling_array(new int[lengths[i]]);
                System.out.println("Merge SORT :");
                start = System.currentTimeMillis();
                MergeSort.mergeSort(array, array.length);
                end = System.currentTimeMillis();
                System.out.println("array - "+j+" = "+ Arrays.toString(array).substring(0,25));
                System.out.println("sıralama = "+Arrays.toString(array).substring(0,25));
                System.out.println("beklenen zaman = "+MergeSort.expected_runtime(lengths[i]));
                System.out.println("gerçek zaman = "+(end-start));
                values_to_csv("mergesort",MergeSort.expected_runtime(lengths[i]),end-start);
            }
        }
        for (int i = 0; i< lengths.length; i++){
            for (int j=0;j<20;j++){
                array = filling_array(new int[lengths[i]]);
                System.out.println("Heap SORT :");
                start = System.currentTimeMillis();
                HeapSort.heapSort(array);
                end = System.currentTimeMillis();
                System.out.println("array - "+j+" = "+ Arrays.toString(array).substring(0,25));
                System.out.println("sıralama = "+Arrays.toString(array).substring(0,25));
                System.out.println("beklenen zaman = "+HeapSort.expected_runtime(lengths[i]));
                System.out.println("gerçek zaman = "+(end-start));
                values_to_csv("heapsort",HeapSort.expected_runtime(lengths[i]),end-start);
            }
        }
        for (int i = 0; i< lengths.length; i++){
            for (int j=0;j<20;j++){
                array = filling_array(new int[lengths[i]]);
                System.out.println("Quick SORT :");
                start = System.currentTimeMillis();
                QuickSort2.sort(array);
                end = System.currentTimeMillis();
                System.out.println("array - "+j+" = "+ Arrays.toString(array).substring(0,25));
                System.out.println("sıralama = "+Arrays.toString(array).substring(0,25));
                System.out.println("beklenen zaman = "+QuickSort2.expected_runtime(lengths[i]));
                System.out.println("gerçek zaman = "+(end-start));
                values_to_csv("quicksort",QuickSort.expected_runtime(lengths[i]),end-start);
            }
        }

    }
    private static int[] charArray_to_IntArray(char[] charArray){
        int[] intArray = new int[charArray.length];
        for (int i = 0; i< charArray.length; i++){
            intArray[i] = charArray[i];
        }
        return intArray;
    }

    private static char[] IntArray_to_CharArray(int[] intArray){
        char[] charArray = new char[intArray.length];
        for (int i = 0; i< charArray.length; i++){
            charArray[i] = (char) intArray[i];
        }
        return charArray;
    }
    static int[] filling_array(int[] arr){
        for (int j = 0; j< arr.length; j++){
            arr[j] = (int) (Math.random()*200000);
        }
        return arr;
    }

    static void values_to_csv(String type, long expected_runtime, double real_time) throws IOException, IOException {
        FileWriter Writer = new FileWriter("results.csv",true);
        Writer.write(type+","+expected_runtime/10000+","+real_time+"\n");
        Writer.close();
    }

    public static void yazdirmFunc(int[] dizi) {
        for (int i = 0; i< dizi.length;i++){
            System.out.println(dizi[i]+" ");
        }
    }
}