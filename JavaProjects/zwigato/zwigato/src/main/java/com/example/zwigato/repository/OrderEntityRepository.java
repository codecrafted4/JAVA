package com.example.zwigato.repository;

import com.example.zwigato.models.OrderEntity;
import com.example.zwigato.models.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity,Integer> {
}
