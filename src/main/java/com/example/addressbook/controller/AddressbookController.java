package com.example.addressbook.controller;

import com.example.addressbook.model.Addressbook;
import com.example.addressbook.service.AddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressbookController {
        @Autowired
        private AddressbookService addressbookService;

        @RequestMapping(value = "/all",method = RequestMethod.GET)
        public List getAllContacts(){
            return addressbookService.getAllContacts();
        }

        @RequestMapping(value = "/{id}",method = RequestMethod.GET)
        public Addressbook getContactById(@PathVariable Long id){
                 return addressbookService.getContactById(id);
        }




}
