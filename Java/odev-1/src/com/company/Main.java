package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static Room[] rooms = new Room[4];

    public static void main(String[] args) throws FileNotFoundException {
        roomInfo();
        rooms_solidity();

        Guest misafir = new Guest();
        misafir.make_reserv(1);


    }

    static void rooms_solidity(){
        System.out.println("Uygun Odalar:");
        for(int i=0;i<4;i++){
            if (rooms[i].getSolidity() == false){
                System.out.println("ODA: "+(i+1));
            }
        }
    }

    static void roomInfo() throws FileNotFoundException {
        for(int i = 0; i<4;i++){
            rooms[i] = new Room();
            create_classes(rooms[i],"/Users/apple/Desktop/University/DataStructures&Algorithms/DataStructures-Algorithm/Java/odev-1/oda"+(i+1) + ".txt");

        }
/*
        for (int i = 1; i < 5; i++) {
            File room = new File("/Users/apple/Desktop/odev-1/oda" + i + ".txt");
            if (room.exists()) {

            } else {
                System.out.println("Oda" + i + " Kapalı");
            }
        }

 */
      //  System.out.println("Açık odalar : "+ roomList);
    }

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
