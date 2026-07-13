package com.etohfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etohfa.dto.OrderResponseDto;
import com.etohfa.dto.ProductResponseDto;
import com.etohfa.dto.ProductReviewResponseDto;
import com.etohfa.resource.OrderResource;
import com.etohfa.resource.ProductResource;
import com.etohfa.resource.ReviewResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/sellers")
@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://kritikeshri.github.io"
})
public class SellerController {

	@Autowired
	private ProductResource productResource;	
	@Autowired
	private OrderResource orderResource;	
	@Autowired
	private ReviewResource reviewResource;	
    
	@GetMapping("/{sellerId}/products")
	@Operation(summary = "Api to fetch all seller active product")
	public ResponseEntity<ProductResponseDto> getProductsBySellerId(@PathVariable(name = "sellerId") int sellerId) {
		return this.productResource.getProductsBySellerId(sellerId);
	}

	@GetMapping(value = "/{sellerId}/products" , params = "productName")
	@Operation(summary = "Api to search the seller active products by name")
	public ResponseEntity<ProductResponseDto> searchSellerProductsByName(
			@PathVariable(name = "sellerId") int sellerId, @RequestParam(name = "productName") String productName) {
		return this.productResource.searchSellerProductsByName(productName, sellerId);
	}

	@GetMapping(value = "/{sellerId}/products" , params = "categoryId")
	@Operation(summary = "Api to fetch all seller active product by category")
	public ResponseEntity<ProductResponseDto> getProductsBySellerAndCatagory(
			@PathVariable(name = "sellerId") int sellerId, @RequestParam(name = "categoryId") int categoryId) {
		return this.productResource.getProductsBySellerAndCatagory(sellerId, categoryId);
	}

	@GetMapping("/{sellerId}/orders")
	@Operation(summary = "Api to get all orders by seller id")
	public ResponseEntity<OrderResponseDto> getOrdersBySeller(@PathVariable("sellerId") int sellerId) {
		return orderResource.getOrdersBySeller(sellerId);
	}

		
	@GetMapping("/{sellerId}/reviews")
	@Operation(summary = "Api to fetch all reviews of seller products")
	public ResponseEntity<ProductReviewResponseDto> getReviewsBySellerId(@PathVariable("sellerId") int sellerId) {
		return this.reviewResource.getReviewsBySellerId(sellerId);
	}
}
