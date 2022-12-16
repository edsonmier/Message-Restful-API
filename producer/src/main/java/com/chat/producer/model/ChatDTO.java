package com.chat.producer.model;

import java.io.Serializable;
import java.util.Date;

public class ChatDTO implements Serializable {

    public ChatDTO() {
    }

    private int id;

    private Customer customer_id;

    private PhoneBook phone_book_id;

    private Date create_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public PhoneBook getPhone_book_id() {
        return phone_book_id;
    }

    public void setPhone_book_id(PhoneBook phone_book_id) {
        this.phone_book_id = phone_book_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
