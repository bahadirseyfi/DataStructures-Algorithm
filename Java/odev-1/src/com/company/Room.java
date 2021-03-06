package com.company;

public class Room {

    private Integer room_number;
    private Boolean solidity;   //DOLULUK
    private Boolean rezervation; //Rezerve mi ?
    private String check;

    Room(Integer room_number, Boolean solidity,Boolean rezervation, String check){
        this.room_number = room_number;
        this.solidity = solidity;
        this.rezervation = rezervation;
        this.check = check;
    }

    Room(){}

    public Boolean getRezervation() {
        return rezervation;
    }
    public Boolean getSolidity() {
        return solidity;
    }
    public String getCheck() {
        return check;
    }
    public Integer getRoom_number() {
        return room_number;
    }

    public void setRezervation(Boolean rezervation) {
        this.rezervation = rezervation;
    }
    public void setCheck(String check) {
        this.check = check;
    }
    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
    }
    public void setSolidity(Boolean solidity) {
        this.solidity = solidity;
    }
}
