package com.company;

public class Reception implements Reservation {

    public void closeRoom(){
        System.out.println("Oda kapatıldı");
    }

    public void check(Integer roomNumber, String gelen){
        System.out.println("Rezervasyonunuz kontrol ediliyor");
        if (Main.rooms[roomNumber-1].getRezervation() == true){
            if (gelen.equals("checkin")){
                Main.rooms[roomNumber-1].setCheck(gelen);
                Main.rooms[roomNumber-1].setSolidity(true);
                System.out.println("Check In İşlemi Yapılmıştır.");
                Main.updateRoomInfo();
            }else if (gelen.equals("checkout")){
                Main.rooms[roomNumber-1].setCheck(gelen);
                Main.rooms[roomNumber-1].setRezervation(false);
                Main.rooms[roomNumber-1].setSolidity(false);
                System.out.println("Çıkış Yapılmıştır. Rezervasyon ve Doluluk Güncellendi");
                Main.updateRoomInfo();
            } else {
                System.out.println("Geçersiz Giriş Yapılmıştır. !");
            }
        } else {
            System.out.println("Rezervasyonunuz Bulunmamaktadır. Lütfen Rezervasyon Yaptırınız.!");
        }
    }

    @Override
    public void make_reserv(Integer roomNumber) {
        if(Main.rooms[roomNumber-1].getSolidity() == false){
            System.out.println("Rezervasyonunuz Yapılmıştır.");
            Main.rooms[roomNumber-1].setRezervation(true);
        } else {
            System.out.println("Oda Dolu, Rezervasyon Yapılamaz.");
        }
    }

    public void canceled_reserv(Integer roomNumber){
        if(Main.rooms[roomNumber-1].getRezervation() == true){
            Main.rooms[roomNumber-1].setRezervation(false);
            System.out.println("Rezervasyon İptal Edilmiştir.");
        } else {
            System.out.println("Hata! Rezervasyon Bulunmamakta!");
        }
    }
}
