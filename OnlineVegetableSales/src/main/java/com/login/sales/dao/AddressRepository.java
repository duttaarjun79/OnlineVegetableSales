package com.login.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.sales.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
