package com.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecom.pojos.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

//	List<Product> findByStatusTrue();

	@Query("SELECT p FROM Product p WHERE p.status = :status")
	List<Product> findByStatus(@Param("status") int status);
}
