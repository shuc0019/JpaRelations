package com.example.jparelations.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//lombok^
@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String firstName;
     String lastName;
     String email;
     String phone;
     @ManyToOne
     Address address;
     @ManyToOne
     Town town;

 public Citizen(String firstName, String lastName, String email, String phone) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phone = phone;
 }
}
