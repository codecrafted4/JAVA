package com.example.zwigato.repository;

import com.example.zwigato.models.Customer;
import com.example.zwigato.utility.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

//    @Query(value = "select * from Customer where gender =:gender",nativeQuery = true)
//    List<Customer> findByGender(String gender);

    //jpql
    @Query(value = "select c from Customer c where c.gender= :g")
    List<Customer> findByGender(Gender g);

}
