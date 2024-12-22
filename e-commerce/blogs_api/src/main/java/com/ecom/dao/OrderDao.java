package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.pojos.Orders;

public interface OrderDao extends JpaRepository<Orders, Long> {

}
