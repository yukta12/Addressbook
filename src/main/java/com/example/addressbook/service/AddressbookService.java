package com.example.addressbook.service;

import com.example.addressbook.repository.AddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
