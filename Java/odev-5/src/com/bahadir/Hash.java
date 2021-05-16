package com.bahadir;

public class Hash {
    private int size = 500;
    private ListOfMember[] memberList;
    private int totalPerson;
    private boolean control;
    private int totalPerson2;

    public Hash() { memberList = new ListOfMember[this.size]; }
    public Hash(int size) {
        this.size = size;
        memberList = new ListOfMember[this.size];
    }
    public boolean added(int lock, Member data)
    {
        if (memberList[lock] == null){
            memberList[lock] = new ListOfMember(); }
            memberList[lock].add(data);
            totalPerson += 1;
        return true;
    }
    // help !!
    public int hashing(String phone){
        int codevalue = 0;
        int addAsciis = (int) phone.charAt(0);

        //  adding for the futures
        codevalue = addAsciis % memberList.length;
        return codevalue;
    }



    public int getTotal()
    {
        return totalPerson;
    }

    public Member fetchPerson(String phoneNumber)
    {
        int key = hashing(phoneNumber);
        if (memberList[key] == null)
            return null;
        else
        {
            Member q = memberList[key].dataBinding(phoneNumber);
            if (q != null)
                return q;
            else
                return null;
        }
    }

    public boolean deleteMember(String phoneNumber)
    {
        boolean have = memberList[hashing(phoneNumber)].existingPhone(phoneNumber);
        if (have)
        {
            int key = hashing(phoneNumber);
            memberList[key].delete(phoneNumber);
            totalPerson--;
            return true;
        }
        return false;
    }

    public void printed()
    {
        for (int i = 0; i< memberList.length; i++){
            if (memberList[i] != null)
            {
                memberList[i].printed();
            }
        }
    }

}
