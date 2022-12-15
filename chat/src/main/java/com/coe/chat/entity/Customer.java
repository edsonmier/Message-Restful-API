package com.coe.chat.entity;

import com.coe.chat.producer.model.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    public Customer(int id, String name, String preferredName, String phoneNumber,
                    String email, String status,
                    Date createDate, Date lastTimeOnline) {
        this.id = id;
        this.name = name;
        this.preferredName = preferredName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.createDate = createDate;
        this.lastTimeOnline = lastTimeOnline;
    }

    public Customer(CustomerDTO customerDTO){
        this.id = customerDTO.getId();
        this.name = customerDTO.getName();
        this.preferredName = customerDTO.getPreferredName();
        this.phoneNumber = customerDTO.getPhoneNumber();
        this.email = customerDTO.getEmail();
        this.status = customerDTO.getStatus();
        this.createDate = customerDTO.getCreateDate();
        this.lastTimeOnline = customerDTO.getLastTimeOnline();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "preferred_name")
    private String preferredName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "status")
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "last_time_online")
    private Date lastTimeOnline;

    public Customer() {

    }

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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", preferredName='" + preferredName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", lastTimeOnline=" + lastTimeOnline +
                '}';
    }
}