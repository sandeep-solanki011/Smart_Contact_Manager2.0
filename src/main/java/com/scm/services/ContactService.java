package com.scm.services;

import java.util.List;

import com.scm.entities.Contact;

public interface ContactService {

    // save contact
    Contact save(Contact contact);

    // update Contact

    Contact update(Contact contact);

    // get Contact

    List<Contact> getAll();

    // get contact by id

    Contact getById(String id);

    // delete
    void delete(String id);

    // search
    List<Contact> search(String name, String email, String phoneNumber);

    // get contacts by userId
    List<Contact> getByUserId(String userId);

    

}
