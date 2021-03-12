package com.company;

public class Guest implements Reservation {

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
    // Eğer rezervasyon yoksa tekrar iptal işlemine izin vermiyor.
    @Override
    public void canceled_reserv(Integer roomNumber){
        if(Main.rooms[roomNumber-1].getRezervation() == true){
            Main.rooms[roomNumber-1].setRezervation(false);
            System.out.println("Rezervasyon İptal Edilmiştir.");
        } else {
            System.out.println("Hata! Rezervasyon Bulunmamakta!");
        }
    }
}
