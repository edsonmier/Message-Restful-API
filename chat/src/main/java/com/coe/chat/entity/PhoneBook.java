package com.coe.chat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="phone_book")
public class PhoneBook implements Serializable {

    public PhoneBook(int id, Customer customerId, Customer myContactId,
                     String nickname, Date createDate, Date updateDate) {
        this.id = id;
        this.customerId = customerId;
        this.myContactId = myContactId;
        this.nickname = nickname;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", referencedColumnName = "id", nullable = false)
    private Customer customerId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="my_contact_id", referencedColumnName = "id", nullable = false)
    private Customer myContactId;
    @Column(name="nickname")
    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name="create_date")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name="update_date")
    private Date updateDate;

    public PhoneBook() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Customer getMyContactId() {
        return myContactId;
    }

    public void setMyContactId(Customer myContactId) {
        this.myContactId = myContactId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", myContactId=" + myContactId +
                ", nickname='" + nickname + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}