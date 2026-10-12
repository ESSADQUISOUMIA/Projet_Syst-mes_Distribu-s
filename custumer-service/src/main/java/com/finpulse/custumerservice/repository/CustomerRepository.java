package com.finpulse.custumerservice.repository;

import com.finpulse.custumerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
