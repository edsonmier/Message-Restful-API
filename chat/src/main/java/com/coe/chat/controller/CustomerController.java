package com.coe.chat.controller;

import com.coe.chat.entity.Customer;
import com.coe.chat.producer.model.CustomerDTO;
import com.coe.chat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{idCustomer}")
    public CustomerDTO getCustomerById(@PathVariable("idCustomer") int idCustomer) {
        Customer customerEntity = customerRepository.findById(idCustomer).orElse(null);
        return new CustomerDTO(customerEntity);
    }

    @GetMapping("")
    public List<CustomerDTO> getCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();
        List<Customer> entities = customerRepository.findAll();
        for (Customer entity : entities
        ) {
            customers.add(new CustomerDTO(entity));
        }
        return customers;
    }

    @GetMapping("/phone-number/{phoneNumber}")
    public CustomerDTO getCustomerByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) throws IOException {
        Customer entityAux = customerRepository.findFirstByPhoneNumber(phoneNumber);
        return (entityAux != null) ? new CustomerDTO(entityAux) : null;
    }
}
