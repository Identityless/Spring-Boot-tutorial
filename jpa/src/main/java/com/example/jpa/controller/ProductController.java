package com.example.jpa.controller;

import com.example.jpa.data.dto.ChangeProductNameDTO;
import com.example.jpa.data.dto.ProductDTO;
import com.example.jpa.data.dto.ProductResponseDTO;
import com.example.jpa.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @ApiOperation(value = "Product get api", notes = "Spring JPA를 이용한 database연동 tutorial")
    @GetMapping(value = "/get")
    public ResponseEntity<ProductResponseDTO> getProduct(@ApiParam(value = "품목 번호", required = true) @RequestParam Long number){
        ProductResponseDTO responseDTO = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @ApiOperation(value = "Product post api", notes = "Spring JPA를 이용한 database연동 tutorial")
    @PostMapping(value = "/post")
    public ResponseEntity<ProductResponseDTO> postPrduct(@ApiParam(value = "품목 정보", required = true) @RequestBody ProductDTO productDTO){
        ProductResponseDTO responseDTO = productService.saveProduct(productDTO);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @ApiOperation(value = "Product put api", notes = "Spring JPA를 이용한 database연동 tutorial")
    @PutMapping(value = "/change")
    public ResponseEntity<ProductResponseDTO> changeProductName(@ApiParam(value = "품목 번호와 변경할 이름", required = true) @RequestBody ChangeProductNameDTO changeProductNameDTO) throws Exception{
        ProductResponseDTO responseDTO = productService.changeProduct(changeProductNameDTO.getNumber(), changeProductNameDTO.getName());

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @ApiOperation(value = "Product delete api", notes = "Spring JPA를 이용한 database연동 tutorial")
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteProduct(@ApiParam(value = "삭제할 품목 번호", required = true) @RequestParam Long number) throws Exception{
        productService.deleteProduct(number);
        String msg = "정상적으로 삭제되었습니다.";

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

}
