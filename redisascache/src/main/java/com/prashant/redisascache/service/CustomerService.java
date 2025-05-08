package com.prashant.redisascache.service;

import com.prashant.redisascache.entity.Customer;
import com.prashant.redisascache.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService  {

    @Autowired
    CustomerRepository customerRepository;

    @CachePut(value = "customers",key = "#result.id")
    public Customer create(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        return customerRepository.saveAndFlush(customer);

    }

    @Cacheable(value = "customers",key = "#id")
    public Customer get(String id){
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException(" customer not found with the given id "));

    }
    @Cacheable(value = "allCustomers")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @CacheEvict(value = "customers",key = "#id")
    public String delete(String id){
        System.out.println("staring delete operation");
        if (!customerRepository.existsById(id)) {
           return "not found";
        }
        else {
            customerRepository.deleteById(id);
            return "deleted successfully";
        }
    }
}