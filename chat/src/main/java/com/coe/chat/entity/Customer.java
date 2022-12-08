package com.coe.chat.entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {

    public Customer() {
    }

    public Customer(int id, String name, String preferredName, String phoneNumber,
                    String email, CustomerStatus status,
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
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private CustomerStatus status;
    @Column(name = "create_date", nullable = false)
    private Date createDate;
    @Column(name = "last_time_online")
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

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
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