package com.coe.chat.repository;

import com.coe.chat.entity.Customer;
import com.coe.chat.producer.model.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findFirstByPhoneNumber(String phoneNumber);
}
