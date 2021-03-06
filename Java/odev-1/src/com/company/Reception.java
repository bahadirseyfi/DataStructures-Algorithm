package com.company;

public class Reception implements Reservation {

    public void closeRoom(){
        System.out.println("Oda kapatıldı");
    }

    public void check(String gelen){

    }

    @Override
    public void make_reserv(Integer roomNumber) {
        if(Main.rooms[roomNumber-1].getSolidity() == false){

            Main.rooms[roomNumber-1].setRezervation(true);
        } else {
            System.out.println("Oda Dolu, Rezervasyon Yapılamaz.");
        }
    }

    public void canceled_reserv(Integer roomNumber){
        if(Main.rooms[roomNumber-1].getRezervation() == true){
            Main.rooms[roomNumber-1].setRezervation(false);
        } else {
            System.out.println("Hata! Rezervasyon Bulunmamakta!");
        }
    }
}
