package com.vois.user.service;

import java.util.List;

import com.vois.user.dto.ProductsDto;

public interface ProductsService {
	ProductsDto createProduct(ProductsDto productDto);
	ProductsDto updateProduct(ProductsDto productDto,Integer productId);
	ProductsDto getProductById(Integer productId);
	List<ProductsDto> getAllProducts();
	void deleteProductById(Integer productId);
	
	
}