package com.example.jpa.service;

import com.example.jpa.data.dto.ProductDTO;
import com.example.jpa.data.dto.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO getProduct(Long number);

    ProductResponseDTO saveProduct(ProductDTO productDTO);

    ProductResponseDTO changeProduct(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
