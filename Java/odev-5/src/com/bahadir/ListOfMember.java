package com.bahadir;

public class ListOfMember {

    Node head;
    public ListOfMember(){
        head = new Node();
        head.data = null;
        head.next = null;
    }
    public class Node{
        Member data;
        Node next;
    }
    public boolean existingPhone(String phone){
        Node node = head.next;
        boolean present = false;
        while (node != null){
            if (phone.equals(node.data.getPhone())) {
                present = true; }
            else {  present = false; }
            node = node.next; }
        return present;
    }

    public boolean add(Member member){
        Node newNode = new Node();
        newNode.data = member;
        newNode.next = head.next;
        head.next = newNode;
        return true;}

    public void printed() {
        Node node = head.next;
        while (node != null){
            System.out.println("printed: "+ node.data);
            node = node.next;
        }
    }

    public Member dataBinding(String phoneNumber) {
        Member data = null;
        Node node = head.next;
        while (node != null) {
            if (node.data.getPhone() == phoneNumber){
                data = node.data;
                break; }
            node = node.next;
        }
        return data;
    }

    public void delete(String phoneNumber) {
        Node head = this.head;
        Node hnext = this.head.next;
        while (hnext.data.getPhone() != phoneNumber && hnext != null) {
            head = hnext;
            hnext = hnext.next; }
        if (hnext != null) {
            head.next = hnext.next;
        }
    }

}
