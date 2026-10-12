package com.finpulse.custumerservice.service;

import com.finpulse.custumerservice.entities.Customer;
import com.finpulse.custumerservice.repository.CustomerRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @McpTool(description = "get all customers")
    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }
    @McpTool(description = "get customer by id")
    public Customer findCustomerById(@McpToolParam(description = "The customer ID") Long id){
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer Not Found"));
    }
    @McpTool(description = "save new customer")
    public Customer addCustomer(@McpToolParam(description = "customer a save in database") Customer customer){
        return customerRepository.save(customer);
    }
}
