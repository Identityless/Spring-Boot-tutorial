package com.example.jpa.service.impl;

import com.example.jpa.data.dao.ProductDAO;
import com.example.jpa.data.dto.ProductDTO;
import com.example.jpa.data.dto.ProductResponseDTO;
import com.example.jpa.data.entity.Product;
import com.example.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDTO getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNumber(product.getNumber());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStock(product.getStock());

        /* 빌더 패턴이나 DTO 객체 내부에 DAO객체로 변환하는 메서드를 넣어 위의
        * DTO 객체를 DAO객체로 변환하는 코드를 깔끔하고 짧게 만들 수 있다.*/

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(savedProduct.getName());
        productResponseDTO.setNumber(savedProduct.getNumber());
        productResponseDTO.setPrice(savedProduct.getPrice());
        productResponseDTO.setStock(savedProduct.getStock());

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO changeProduct(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name, LocalDateTime.now());

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setName(changedProduct.getName());
        productResponseDTO.setNumber(changedProduct.getNumber());
        productResponseDTO.setPrice(changedProduct.getPrice());
        productResponseDTO.setStock(changedProduct.getStock());

        return productResponseDTO;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
