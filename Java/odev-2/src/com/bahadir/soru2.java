package com.bahadir;

// GitHub :  https://github.com/bahadirseyfi/DataStructures-Algorithm/tree/main/Java/odev-2/src/com/bahadir

// Yazılan KODUN NEYE HİZMET ETTİĞİNİ ANLAYAMADIM, N DEĞİŞKENİ NEDİR TARGET DENEN HEDEF NEDİR,
// PYTHON KODU ANCAK BAZI DEĞİŞKENLERİN AMACINI ANLAYAMADIĞIM İÇİN DERSTE GÖRDÜĞÜM KADARIYLA HESAPLAMA
// YAPMAYA ÇALIŞACAĞIM

public class soru2 {
    public static void main(String[] args) {

        int n = 1;                  // 1
        int target = n;               // 1

        for(int i = 1 ; i < 2*n ; i += 4*i){   // 1 + n+2 + n+1 = 2n + 4   = a
            for(int j=n;j>0;j--){               // 2 + n+1 + n = 2n + 3    = b
                if(i*j == target) {             // 1 + 1 + n  = 2 + n
                    target = checkFunc(n);      // 1
                } else {
                    System.out.println();       // a * b + 2 + n + 1 = MAIN
                }                               // (n^2 gelecek, katsayılar ve sabitler gideceği için.)
            }
        }


    }
    public static int checkFunc(int n){
        foo(n); // 1
        if (n == 1) { // n
            return 1;  // 1
        } else {
            return checkFunc(n/2); // n / 2
        }

    }
    public static void foo(int n){
        for (int i =0; i<n;++i){  // 2n+2
            System.out.println();
        }
    }
}                       // ALGORİTMA HER TÜRLÜ TÜM DEĞERLEMELERE BAKACAĞINDAN DOLAYI EŞİT ELEMANLARI DİKKATE ALMAZ BUNDAN DOLAYI
                        // HER DURUMDA BU ALGORİTMA O(N^2) KARMAŞIKLIĞINI BİZE SUNAR !!!!!!!!!!!!!!!!!!!
