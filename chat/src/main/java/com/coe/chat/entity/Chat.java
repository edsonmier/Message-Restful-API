package com.coe.chat.entity;

import com.chat.producer.model.ChatDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chat")
public class Chat {

    public Chat() {

    }

    public Chat(int id, Customer customer_id, PhoneBook phone_book_id, Date create_date) {
        this.id = id;
        this.customer_id = customer_id;
        this.phone_book_id = phone_book_id;
        this.create_date = create_date;
    }

    public Chat(ChatDTO chatDTO){
        this.id = chatDTO.getId();
        this.customer_id =  new Customer();
        this.phone_book_id = new PhoneBook();
        this.create_date = chatDTO.getCreate_date();
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer.id", nullable = false)
    private Customer customer_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_book.id", nullable = false)
    private PhoneBook phone_book_id;

    @Column(name = "create_date", nullable = false)
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

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", phone_book_id=" + phone_book_id +
                ", create_date=" + create_date +
                '}';
    }
}
