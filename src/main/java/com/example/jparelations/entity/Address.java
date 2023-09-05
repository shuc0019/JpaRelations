package com.example.jparelations.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//lombok ^
@Entity
public class Address {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String street;
     String zip;
     String city;

     @OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
     //CASCADE:hvis du bruger ALL istedet for persist(gem), så hvis du sletter adress så sletter du ogs citizens
    //@JoinColumn(name = "address_id") - man fjerner joincolumn fordi vi bruger mappedby
     private List<Citizen> citizens = new ArrayList();
     public void addCitizen(Citizen citizen){
         citizens.add(citizen);
         citizen.setAddress(this); //This er
     }


    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
