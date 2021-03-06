package com.company;

public class Guest implements Reservation {

    public void canceled_rezerv(Integer roomNumber){
        System.out.println(roomNumber + " Nolu odaya Rezervasyon İptali");
    }

    @Override
    public void make_reserv(Integer roomNumber) {

        if(Main.rooms[roomNumber-1].getSolidity() == false){

            Main.rooms[roomNumber-1].setRezervation(true);
        } else {
            System.out.println("Oda Dolu, Rezervasyon Yapılamaz.");
        }

    }
}
