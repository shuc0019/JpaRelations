package com.example.jparelations.config;

import com.example.jparelations.entity.Address;
import com.example.jparelations.entity.Citizen;
import com.example.jparelations.entity.Town;
import com.example.jparelations.repository.AddressRepository;
import com.example.jparelations.repository.CitizenRepository;
import com.example.jparelations.repository.TownRepository;
import com.example.jparelations.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperData implements ApplicationRunner {

   private final AddressRepository addressRepository;
   private final AddressService addressService;
   private final TownRepository townRepository;

    public DeveloperData(AddressRepository addressRepository, AddressService addressService, TownRepository townRepository) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
        this.townRepository = townRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Town town = new Town();
        townRepository.save(town);

        Address a1 = new Address("Lyngbyvej 1", "Lyngby", "2800");
        Citizen citizen1 = new Citizen("Kurt", "Wonnegut", "a@b.dk","123");
        Citizen citizen2 = new Citizen("Hanne", "Wonnegut", "h@b.dk", "234");
        a1.addCitizen(citizen1);
        a1.addCitizen(citizen2);
        citizen1.setTown(town);
        citizen2.setTown(town);
        //citizenRepository.save(citizen1);
        //citizenRepository.save(citizen2);




        addressRepository.save(a1);//Save the address

        System.out.println("------- Select statements starts here ------------");
        /*Address address_1 = addressRepository.findById(a1.getId()).get();
        System.out.println(address_1.getStreet());
        System.out.println("Press Enter to continue");

        System.in.read();  //This will block so you have time to read the DEBUG statements
        System.out.println("Citizens: "+address_1.getCitizens().size());
*/
        addressService.printFullAddressInfo(1,true);

    }
}
