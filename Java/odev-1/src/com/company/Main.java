package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Bahadır SEYFİ
 * @implNote : 170419505 (öğrenci numarası)
 * Otel Otomasyonu
 * @version 1.0
 * @since Mar 6, 2021
 *
 *
 * Uygulamayı Çalıştırmadan önce oda dosyasının yolunu doğru verdiğinizden emin olun (125.satır).
 *
 * Bağımsız paketler kullanılmamıştır.
 *
 * Test classının içerisinde bulunan fonksiyonlar model oluşturulması için gereklidir.
 *
 * Oda Text dosyalarındaki satırların anlam sıralaması:
 * 1. Satır: Oda Numarası - Room Number
 * 2. Satır: Doluluk - Solidity (Oda doluluğu false ise oda boş, True ise doludur.)
 * 3. Satır: Rezervasyon - Reservation ( False ise oda rezerve değil, True ise rezervedir.)
 * 4. Satır: Check Durumudur. Müşteri odaya giriş yaptı ise checkin çıkış yaptı ise checkout olur.
 *
 * ----------------------------------------------------------
 *
 * Oda soldity(doluluk) bilgisi ancak ve ancak Check durumunun "In" hale getirilmesi ile True Durumuna gelir.
 * dolu bir oda rezerve edilemez.
 * Rezervasyon işlemi bir kere yapılabilir, aynı oda tekrar rezerve edilemez.
 * Bir odaya check-in yapılabilmesi için o odaya daha öncesinde rezervasyon yapılması gerekiyor.
 * Checkin veya checkout işlemi sonrası odanın tüm bilgileri ilgili fonkiyon tarafından güncellenir.
 *
 */


public class Main {


    public static Room[] rooms = new Room[4];
    //Room Sınıfından her oda için ayrı bir nesne oluşturuluyor.


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        roomInfo();

        // Test Sınıfı İçin Tekrar Etmeyen Menu:
        System.out.println("Otel Uygulamasına Hoş Geldiniz \n1: Resepsiyon Girişi.\n2: Müşteri Girişi.");
        int secim1 = scanner.nextInt();
        if(secim1 == 1){
            Reception resepsiyon = new Reception();
            System.out.println("Yapmak İstediğiniz İşlemi Seçiniz:\n1: Rezervasyon Yaptırmak.\n2: Rezervasyon İptali.\n3: Check İşlemi");
            int secim5 = scanner.nextInt();
            if(secim5 == 1) {
                System.out.println("Boş Odalar Sergileniyor:\n");
                rooms_solidity();
                System.out.println("Oda Seçimini Yapınız:");
                int secim6 = scanner.nextInt();
                resepsiyon.make_reserv(secim6);
            }else if(secim5 == 2) {
                System.out.println("Oda Numaranızı Giriniz: ");
                int secim7 = scanner.nextInt();
                resepsiyon.canceled_reserv(secim7);

            }else if(secim5 == 3) {
                System.out.println("Oda Numaranızı Giriniz: ");
                int checknumber = scanner.nextInt();
                    System.out.println("Check in ve out işlemi için rezervasyon gereklidir!\n Check işlemi seçiniz:\n1: Check-In\n2: Check-Out");
                    int check = scanner.nextInt();
                    if(check == 1){
                        resepsiyon.check(checknumber,"checkin");
                    } else if( check == 2){
                        resepsiyon.check(checknumber,"checkout");
                    } else {
                        System.out.println("Hatalı Giriş Yaptınız.");
                    }
            } else {
                System.out.println("Giriş Hatalı");
            }




        } else if(secim1 == 2){
            Guest musteri = new Guest();
            System.out.println("Yapmak İstediğiniz İşlemi Seçiniz:\n1: Rezervasyon Yaptırmak.\n2: Rezervasyon İptali.");
            int secim2 = scanner.nextInt();
            if(secim2 == 1){
                System.out.println("Boş Odalar Sergileniyor:\n");
                rooms_solidity();
                System.out.println("Oda Seçimini Yapınız:");
                int secim3 = scanner.nextInt();
                musteri.make_reserv(secim3);
            } else if(secim2 == 2){
                System.out.println("Oda Numaranızı Giriniz: ");
                int secim4 = scanner.nextInt();
                musteri.canceled_reserv(secim4);
            } else {
                System.out.println("Hatalı Giriş Yaptınız.");
            }
        } else {
            System.out.println("Hatalı Giriş Yaptınız.");
        }
    }

    //Odaların doluluklarına göre sistemde uygun odaları bizlere sıralıyor bu fonksiyon.
    static void rooms_solidity(){
        System.out.println("Uygun Odalar:");
        for(int i=0;i<4;i++){
            if (!rooms[i].getSolidity()){ // ilgili odanın doluluğu eğer false ise odanın boş ve kullanıma uygun olduğunu sergiler.
                System.out.println("ODA: "+(i+1));
            }
        }
    }

    // Önemli!!
    // Odalardaki her değişikliği kaydeden ve dosyaya yazan fonksiyondur.
    // Tüm odaları dolaşır ve her bilgiyi yazar, yapılan her işlemden sonra çağırılması gereklidir.
    public static void updateRoomInfo(){
        try {
            for (int i=0;i<4;i++) {
                FileWriter fileWriter = new FileWriter("oda"+(i+1)+".txt");

                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(rooms[i].getRoom_number() + "\n");
                printWriter.print(rooms[i].getSolidity() + "\n");
                printWriter.print(rooms[i].getRezervation() + "\n");
                printWriter.print(rooms[i].getCheck());
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // !!!!!!!!!! FILE PATH !!!!!!!!!!!!
    // Oluşturacağımız odaların classını türetir ve böylece index numarası ile istediğimiz odadaki istediğimiz özelliğe erişebiliriz.
    static void roomInfo() throws FileNotFoundException {
        for(int i = 0; i<4;i++){
            rooms[i] = new Room();
            create_classes(rooms[i],"/Users/apple/Desktop/University/DataStructures&Algorithms/DataStructures-Algorithm/Java/odev-1/oda"+(i+1) + ".txt");
        }
    }

    // Odalar txt Dosyalarındaki bilgileri oluşturulan modele girdisini yapan fonksiyondur.
    // Her satırı ayrı ayrı okuyarak nesnelerdeki propertylere set etmekdir.
    static void create_classes(Room room, String path) throws FileNotFoundException {
        File oda = new File(path);
        try (Scanner odaInfo = new Scanner(oda)) {
            Integer odaNo = Integer.parseInt(odaInfo.nextLine());
            Boolean doluluk = Boolean.parseBoolean(odaInfo.nextLine());
            Boolean rezerve = Boolean.parseBoolean(odaInfo.nextLine());
            String check = odaInfo.nextLine();

            room.setRoom_number(odaNo);
            room.setSolidity(doluluk);
            room.setRezervation(rezerve);
            room.setCheck(check);
        }
    }

}
