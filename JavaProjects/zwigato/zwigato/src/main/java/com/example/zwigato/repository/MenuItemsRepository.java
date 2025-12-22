package com.example.zwigato.repository;

import com.example.zwigato.models.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemsRepository extends JpaRepository<MenuItems,Integer> {
}
