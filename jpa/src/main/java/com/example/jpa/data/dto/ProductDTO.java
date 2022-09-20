package com.example.jpa.data.dto;


import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private int price;
    private int stock;
}
