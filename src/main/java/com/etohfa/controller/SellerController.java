package com.etohfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etohfa.dto.ProductResponseDto;
import com.etohfa.resource.ProductResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/sellers")
@CrossOrigin(origins = "http://localhost:3000")
public class SellerController {

	@Autowired
	private ProductResource productResource;	
    
	@GetMapping("/{sellerId}/products")
	@Operation(summary = "Api to fetch all seller active product")
	public ResponseEntity<ProductResponseDto> getProductsBySellerId(@PathVariable(name = "sellerId") int sellerId) {
		return this.productResource.getProductsBySellerId(sellerId);
	}
}
