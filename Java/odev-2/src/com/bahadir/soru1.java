package com.bahadir;

// GitHub :  https://github.com/bahadirseyfi/DataStructures-Algorithm/tree/main/Java/odev-2/src/com/bahadir

/*
    SORU1: Sözde kod yazarak INSERTION SORT algoritmanızın
    en kötü durum, en iyi durum ve ortalama durum analizini uygun
    asimptotik gösterimler kullanarak açıklayın.
 */


/*
    N elemanlı bir dizide ikinci eleman için en fazla 1
    karşılaştırma ve 1 yer değiştirme yapar, üçüncü eleman
    için 2 karşılaştırma ve 2 yer değiştirme
 */

/*
    Eklemeli sıralama algoritması en kötü durumda
    (örneğin dizi tersten sıralıysa) O(N2) karmaşıklığıyla çalışır.

    EN KÖTÜ DURUM:
    Örnek olarak : [5,4,3,2,1] tamamen tersten sıralanmış dizi.

    Dizi sıralıysa sadece N-1 kez karşılaştırma yapar ve
    O(N) karmaşıklığıyla çalışır, en iyi performansı O(N)‘dir.

    EN İYİ DURUM:
    [1,2,3,4,5]

    Diğer durumlar ise ortalama durum olur örn:
    [1,3,4,5,2]
 */

// Eklemeli sıralama algoritmasının ortalama performansı ise yine O(N2) değeridir. !!!!!!!!!!!!!!!!!!

public class soru1 {

    public static void main(String[] args) {

        int[] intArray = new int[]{ 12,22,3,4,5,6,7,8,9,10 };
      intArray = insertionSort(intArray);
      for (int i = 0; i < intArray.length; i++){
          System.out.println(intArray[i]);
      }
    }
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {

            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        return array;
    }
}
