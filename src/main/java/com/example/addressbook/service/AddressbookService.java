package com.example.addressbook.service;

import com.example.addressbook.model.Addressbook;
import com.example.addressbook.repository.AddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressbookService {

    @Autowired
    private AddressbookRepository addressbookRepository;

    public List getAllContacts(){
        List contacts = new ArrayList<>();
        addressbookRepository.findAll().forEach(contacts::add);

        return contacts;
    }

    public Addressbook getContactById(Long id){
//        System.out.println( addressbookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found")));
//        System.out.println(id);
        return addressbookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }
    public void addContact(Addressbook addressbook){
        addressbookRepository.save(addressbook);
    }


}
