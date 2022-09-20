package com.example.jpa.data.dto;


import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long number;
    private String name;
    private int price;
    private int stock;
}
