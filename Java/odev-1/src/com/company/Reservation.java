package com.company;

// Her iki classın da rezervasyon yapma ve iptal etme özelliğini interface yardımı ile
// sağladım. Parametre olarak aldıkları oda id lerine göre sınıflarında işlem yapılacaktır.
public interface Reservation {
    public void make_reserv(Integer roomNumber);
    public void canceled_reserv(Integer roomNumber);
}
