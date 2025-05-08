package com.prashant.redisascache.controller;

import com.prashant.redisascache.entity.Customer;
import com.prashant.redisascache.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @GetMapping("/{id}")
    public Customer  get(@PathVariable("id") String id){
        return customerService.get(id);
    }

    @GetMapping("/getall")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        return customerService.delete(id);
    }
}
