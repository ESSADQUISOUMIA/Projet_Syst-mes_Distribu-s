package com.finpulse.custumerservice.controllers;

import com.finpulse.custumerservice.entities.Customer;
import com.finpulse.custumerservice.repository.CustomerRepository;
import com.finpulse.custumerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {
    private CustomerService customerService;
    public CustomerRestController(CustomerService customerService){
        this.customerService= customerService;
    }
    @GetMapping("/customers")
    public List<Customer> allCustomers(){
        return customerService.allCustomers();
    }
    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
}
