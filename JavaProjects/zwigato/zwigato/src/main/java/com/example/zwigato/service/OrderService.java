package com.example.zwigato.service;

import com.example.zwigato.dto.request.OrderItemsRequest;
import com.example.zwigato.dto.response.OrderResponse;
import com.example.zwigato.exceptions.CustomerNotFoundException;
import com.example.zwigato.models.*;
import com.example.zwigato.repository.CustomerRepository;
import com.example.zwigato.repository.MenuItemsRepository;
import com.example.zwigato.repository.OrderEntityRepository;
import com.example.zwigato.repository.RestaurantRepository;
import com.example.zwigato.utility.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerRepository customerRepository;
    private final MenuItemsRepository menuItemsRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderEntityRepository orderEntityRepository;
    public OrderResponse placeOrder(int customer_id, List<OrderItemsRequest> orderItemsRequest) {
        Optional<Customer> OptionalCustomer = customerRepository.findById(customer_id);
        if (OptionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("invalid customer");
        }
        Customer customer = OptionalCustomer.get();
        List<MenuItems> menuItems = new ArrayList<>();
        int totalCost = 0;
        List<OrderItems> orderItems = new ArrayList<>();
        OrderEntity order = new OrderEntity();
        List<String> names = new ArrayList<>();

        for (OrderItemsRequest request : orderItemsRequest) {
            MenuItems menuItem= menuItemsRepository.findById(request.getMenuItemsId()).get();
            names.add(menuItem.getName());
            totalCost += (menuItem.getPrice()*request.getQuantity());
            menuItems.add(menuItemsRepository.findById(request.getMenuItemsId()).get());
            OrderItems orderItem = new OrderItems();
            orderItem.setId(String.valueOf(UUID.randomUUID()));
            orderItem.setQuantity(request.getQuantity());
            orderItem.setMenuItem(menuItem);
            orderItem.setOrderEntity(order);
            orderItems.add(orderItem);
        }
        order.setStatus(OrderStatus.ONT_THE_WAY);
        order.setTotalCost(totalCost);
        order.setCustomer(customer);
        order.setOrderItems(orderItems);


        OrderEntity savedOrder = orderEntityRepository.save(order);

        return OrderResponse.builder()
                .status(savedOrder.getStatus())
                .createdAt(savedOrder.getCreatedAt())
                .totalCost(savedOrder.getTotalCost())
                .name(names)
                .customerName(customer.getName())
                .build();
    }
}
