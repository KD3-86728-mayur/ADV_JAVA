package com.ecom.service;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDto;

public interface ProductService {

	ApiResponse addNewProduct(ProductDto productDto);

	ApiResponse softDelete(Long productId, Long userId);

}
