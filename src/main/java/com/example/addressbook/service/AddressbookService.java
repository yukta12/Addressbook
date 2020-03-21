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

    /**
     * This function is used to fetch all the contacts from database
     * @return List
     */
    public List getAllContacts(){
        List contacts = new ArrayList<>();
        addressbookRepository.findAll().forEach(contacts::add);

        return contacts;
    }

    /**
     * The following function is used to fetch the contact details by ID
     * @param id
     * @return AddressBook
     */

    public Addressbook getContactById(Long id){
//        System.out.println( addressbookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found")));
//        System.out.println(id);
        return addressbookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    /**
     * Function is used to add contact record to the database
     * @param addressbook
     */
    public void addContact(Addressbook addressbook){ addressbookRepository.save(addressbook);  }

    /**
     * Updating the record in the database
     * @param addressbook
     */

    public void updateContact(Addressbook addressbook){ addressbookRepository.save(addressbook);  }

    /**
     * This function is used to delete the contact record
     * @param id
     */
    public void deleteContact(Long id){ addressbookRepository.deleteById(id);  }
}
