package com.bahadir;

public class HeapSort {
    public static void heapSort(int[] a) {
        int count = a.length;
        // maksimum stack sırasına ilk olarak bir koyduk
        heapify(a, count);
        int end = count - 1;
        while (end > 0) {
            // stack kökü (maksimum değer)
            // stackin son elemanı
            int tmp = a[end];
            a[end] = a[0];
            a[0] = tmp;
            // stacki maksimum stackin sırasına geri atadık
            siftDown(a, 0, end - 1);
            // stackin boyutunu küçülttük, böylece önceki
            // maksimum değer uygun yerinde kalacaktır.
            end--;
        }
    }
    public static void heapify(int[] a, int count) {
        // başlangıç, son ana düğümün bir dizinine atanır
        int start = (count - 2) / 2; //binary heap
        while (start >= 0) {
            // dizin başlangıcında düğümü doğru yere ekledim
            // başlangıç dizininin altındaki tüm düğümler stack içinde olacak şekilde
            //çağırıldı
            siftDown(a, start, count - 1);
            start--;
        }
        // kökü eledikten sonra tüm düğümler/öğeler yığın sırasındadır
    }

    public static void siftDown(int[] a, int start, int end) {
        // end, yığının ne kadar aşağıda eleneceğinin limitini yani sınırını temsil ediyor
        int root = start;
        while ((root * 2 + 1) <= end) {      // Kökün en az bir childı varken
            int child = root * 2 + 1;           // root * 2+1
            // childın bir kardeşi varsa ve childın değeri kardeşinin değerinden küçükse ...
            if (child + 1 <= end && a[child] < a[child + 1])
                child = child + 1;          // ... sonra bunun yerine doğrusunu gösteririz
            if (a[root] < a[child]) {     // maksimum stack sırası dışında
                int tmp = a[root];
                a[root] = a[child];
                a[child] = tmp;
                root = child;                // tekrar bağlarız ki sonucumuza ulaşalım
            } else
                return;
        }
    }
    public static long expected_runtime(int arr_length){
        long n = arr_length;
        return n*n + 5;
    }
}