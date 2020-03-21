package com.example.addressbook.controller;

import com.example.addressbook.model.Addressbook;
import com.example.addressbook.service.AddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressbookController {
    @Autowired
    private AddressbookService addressbookService;

    /**
     * Mapping to display all the records to the database
     * request example : http://localhost:8080/contacts/all
     *
     * @return List
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List getAllContacts() { return addressbookService.getAllContacts(); }

    /**
     * Mapping to display particular record with id from request
     * request example : http://localhost:8080/contacts/1
     *
     * @param id
     * @return Addressbook
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Addressbook getContactById(@PathVariable Long id) { return addressbookService.getContactById(id); }

    /**
     * Mapping to add record to the database
     * request example : http://localhost:8080/contacts/add
     * All the values are fetched from the request body with application/json as the header in request
     * @param addressbook
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addContact(@RequestBody Addressbook addressbook) { addressbookService.addContact(addressbook);  }

    /**
     * Request to handle the edit request to the database
     * request example : http://localhost:8080/contacts/18/edit
     * PATCH Request to handle also fetches the records from the body to the request
     *
     * @param id
     * @param addressbook
     */

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PATCH)
    public void updateContact(@PathVariable Long id, @RequestBody Addressbook addressbook) {
        addressbook.setId(id);
        addressbookService.updateContact(addressbook);
    }

    /**
     * Mapping the request to delete the record in databse
     * request example : http://localhost:8080/contacts/18/delete
     *
     * @param id
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable Long id) { addressbookService.deleteContact(id);  }
}
