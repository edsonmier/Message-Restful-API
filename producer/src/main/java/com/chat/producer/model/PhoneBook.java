package com.chat.producer.model;

import java.io.Serializable;
import java.util.Date;

public class PhoneBook implements Serializable {

    private int id;

    private Customer customerId;

    private Customer myContactId;

    private String nickname;

    private Date createDate;

    private Date updateDate;
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