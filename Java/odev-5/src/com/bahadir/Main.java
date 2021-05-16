package com.bahadir;

public class Main {

    static Hash hash = new Hash(10);
    static int lock;


    public static void main(String[] args) {


        create_person();
        testing();
    }
    public static void testing(){
        Member bahadir = new Member("bahadir","050710422223");
        lock = hash.hashing(bahadir.getPhone());
        hash.added(lock,bahadir);
        hash.printed();

        Member member = hash.fetchPerson("050710422223");
        System.out.println(member.toString());

        hash.deleteMember("050710422223");
        hash.printed();
    }

    public static void create_person(){


        Member a1 = new Member("ali","05047741213");
        Member a2 = new Member("ayse","05047741223");
        Member a3 = new Member("mustafa","053777412133435");
        Member a4 = new Member("mehmet","03046741213");
        Member a5 = new Member("selami","05047741213");
        Member a6 = new Member("hakki","0504774123123");
        Member a7 = new Member("selami","05047444444");
        lock = hash.hashing(a1.getPhone());
        hash.added(lock, a1);
        lock = hash.hashing(a2.getPhone());
        hash.added(lock, a2);
        lock = hash.hashing(a3.getPhone());
        hash.added(lock, a3);
        lock = hash.hashing(a4.getPhone());
        hash.added(lock, a4);
        lock = hash.hashing(a5.getPhone());
        hash.added(lock, a5);
        lock = hash.hashing(a6.getPhone());
        hash.added(lock, a6);
        lock = hash.hashing(a7.getPhone());
        hash.added(lock, a7);

        hash.printed();
    }
}
