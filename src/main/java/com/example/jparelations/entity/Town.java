package com.example.jparelations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//lombok^
@Entity
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String name;
     String zipCode;
     String mayor;
     int schools;


 public Town(String name, String zipCode, String mayor, int schools) {
  this.name = name;
  this.zipCode = zipCode;
  this.mayor = mayor;
  this.schools = schools;
 }
}
