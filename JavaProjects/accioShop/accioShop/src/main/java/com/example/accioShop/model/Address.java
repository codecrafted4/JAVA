package com.example.accioShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address_details")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String houseNo;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int pincode;

    @OneToOne //relationship wih customer
    @JoinColumn(name ="customer_id")  //foriegn key
    Customer customer;


}
