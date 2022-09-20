package com.example.jpa.controller;

import com.example.jpa.data.dto.ChangeProductNameDTO;
import com.example.jpa.data.dto.ProductDTO;
import com.example.jpa.data.dto.ProductResponseDTO;
import com.example.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/get")
    public ResponseEntity<ProductResponseDTO> getProduct(Long number){
        ProductResponseDTO responseDTO = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PostMapping("/post")
    public ResponseEntity<ProductResponseDTO> postPrduct(@RequestBody ProductDTO productDTO){
        ProductResponseDTO responseDTO = productService.saveProduct(productDTO);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PutMapping("/change")
    public ResponseEntity<ProductResponseDTO> changeProductName(@RequestBody ChangeProductNameDTO changeProductNameDTO) throws Exception{
        ProductResponseDTO responseDTO = productService.changeProduct(changeProductNameDTO.getNumber(), changeProductNameDTO.getName());

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);
        String msg = "정상적으로 삭제되었습니다.";

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

}
