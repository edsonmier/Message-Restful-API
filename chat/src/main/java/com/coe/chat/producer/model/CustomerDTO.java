package com.coe.chat.producer.model;

import com.coe.chat.entity.Customer;

import java.util.Date;

public class CustomerDTO {

    public CustomerDTO() {
    }

    public CustomerDTO(Customer entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.preferredName = entity.getPreferredName();
        this.phoneNumber = entity.getPhoneNumber();
        this.email = entity.getEmail();
        this.status = entity.getStatus();
        this.createDate = entity.getCreateDate();
        this.lastTimeOnline = entity.getLastTimeOnline();
    }

    private int id;

    private String name;

    private String preferredName;

    private String phoneNumber;

    private String email;

    private String status;

    private Date createDate;

    private Date lastTimeOnline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(Date lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }
}