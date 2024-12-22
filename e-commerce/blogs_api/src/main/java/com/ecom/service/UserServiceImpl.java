package com.ecom.service;

import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserReqDto;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserServive {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ProductDao productDao;

	@Override
	public ApiResponse addNewUser(UserReqDto userDto) {
		User user = mapper.map(userDto, User.class);
		System.out.println(user);
		User saved = userDao.save(user);

		return new ApiResponse("User Added SuccessFully");
	}

	@Override
	public List<Product> displayAllProducts(Long userId) {
		User user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Invalid User Id"));

		if (user.getRole() == UserRole.CUSTOMER) {
			List<Product> prodList = productDao.findByStatus(1);
			return prodList;
		}

		return null;
	}

}
