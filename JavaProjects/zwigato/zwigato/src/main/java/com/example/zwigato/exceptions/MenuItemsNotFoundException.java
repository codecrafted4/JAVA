package com.example.zwigato.exceptions;

public class MenuItemsNotFoundException extends RuntimeException {
    public MenuItemsNotFoundException(String message) {
        super(message);
    }
}
