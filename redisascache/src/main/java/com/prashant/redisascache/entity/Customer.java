package com.prashant.redisascache.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Customer implements Serializable {
    @Id
    private String id;
    private String userName;
    private String email;

}
