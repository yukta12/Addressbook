package com.example.addressbook.repository;

import com.example.addressbook.model.Addressbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AddressbookRepository extends JpaRepository<Addressbook,Long> {
}
