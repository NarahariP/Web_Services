package com.hari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hari.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
