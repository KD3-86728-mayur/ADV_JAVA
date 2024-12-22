package com.ecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDto;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserDao userDao;

	@Override
	public ApiResponse addNewProduct(ProductDto productDto) {

		User admin = userDao.findById(productDto.getUserId()).orElseThrow(() -> new RuntimeException("Invalid User"));

		if (admin.getRole() == UserRole.ADMIN) {
			Product persist = mapper.map(productDto, Product.class);
			persist.setStatus(1);
			Product add = productDao.save(persist);
			return new ApiResponse("Product Added Successfully");
		}

		return new ApiResponse("Failed To Add Product ! Login as Admin");

//		System.out.println(persist);

	}

	@Override
	public ApiResponse softDelete(Long productId, Long userId) {

		User admin = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Invalid User"));
		Product prod = productDao.findById(productId).orElseThrow(() -> new RuntimeException("Product Not Found"));

		if (admin.getRole() == UserRole.ADMIN && productDao.existsById(productId)) {
			prod.setStatus(0);
			return new ApiResponse("Deleted Successfully");
		}

		return new ApiResponse("Failed to Delete");
	}

}
