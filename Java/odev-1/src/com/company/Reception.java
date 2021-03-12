package com.company;

public class Reception implements Reservation {
    // Guest classından miras alabilirdim böylece rezerve fonksiyonlarını tekrar kullanmam gerekmezdi.
    // Ancak interface kavramıyla bunu sağlamak istedim.


    // Check işlemi diğer Guest classından bağımsız olarak daha fazla şart içeren fonksiyondur.
    // Eğer bir müşteri checkin yaptırmak istiyorsa ve gelen parametre checkin olarak geliyorsa,
    // odadaki check durumu set ediliyor ve doluluk durumu güncelleniyor. Aksi durumda ise aynı
    // İşlemler yapılıyor ancak rezervasyon da false duruma getiriliyor çünkü oda ile bir ilişik
    // Kalmamış oluyor. Sistemi çalıştıran bir sonraki kişi böylece o odaya rezervasyon yaptırabiliyor.

    public void check(Integer roomNumber, String gelen){
        System.out.println("Rezervasyonunuz kontrol ediliyor");

            if (gelen.equals("checkin")){
                if (Main.rooms[roomNumber-1].getRezervation() == true) {
                    Main.rooms[roomNumber - 1].setCheck(gelen);
                    Main.rooms[roomNumber - 1].setSolidity(true);
                    System.out.println("Check In İşlemi Yapılmıştır.");
                    Main.updateRoomInfo();
                } else {
                    System.out.println("Rezervasyonunuz Bulunmamaktadır. Lütfen Rezervasyon Yaptırınız.!");
                }
            }else if (gelen.equals("checkout")){
                Main.rooms[roomNumber-1].setCheck(gelen);
                Main.rooms[roomNumber-1].setRezervation(false);
                Main.rooms[roomNumber-1].setSolidity(false);
                System.out.println("Çıkış Yapılmıştır. Rezervasyon ve Doluluk Güncellendi");
                Main.updateRoomInfo();
            } else {
                System.out.println("Geçersiz Giriş Yapılmıştır. !");
            }
    }

    // Bağlı fonkisyonlarımızdan birisi de rezervasyon yaptırmak. Eğer oda dolu ise rezervasyon yaptıramazsınız!
    // Odanın doluluğuna göre rezervasyon yaptırabiliyorsunuz. Böylece dolu oda rezerve edilemiyor ve rezervasyon iptal
    // İptal edilmek istenince önce rezervasyona daha sonra doluluk şartına takılmış oluyor.
    @Override
    public void make_reserv(Integer roomNumber) {
        if(Main.rooms[roomNumber-1].getSolidity() == false){
            if (Main.rooms[roomNumber-1].getRezervation() == false) {
                Main.rooms[roomNumber-1].setRezervation(true);
                Main.updateRoomInfo();
                System.out.println("Rezerve İşlemi Yapıldı, Checkin işlemi için oda hazırdır.");
            } else {
                System.out.println("Odada Rezervasyon Bulunmaktadır. Lütfen Başka Oda Tercih ediniz.");
            }
        } else {
            System.out.println("Oda Dolu, Rezervasyon Yapılamaz.");
        }
    }

    // Interface'den gelen zorunlu fonksiyonumuz aldığı parametre ile öncelikle rezervasyon durumunu kontrol ediyor.
    // Eğer rezervasyon yoksa tekrar iptal işlemine izin vermiyor.
    @Override
    public void canceled_reserv(Integer roomNumber){
        if(Main.rooms[roomNumber-1].getRezervation() == true){
            Main.rooms[roomNumber-1].setRezervation(false);
            System.out.println("Rezervasyon İptal Edilmiştir.");
            Main.updateRoomInfo();
        } else {
            System.out.println("Hata! Rezervasyon Bulunmamakta!");
        }
    }
}
