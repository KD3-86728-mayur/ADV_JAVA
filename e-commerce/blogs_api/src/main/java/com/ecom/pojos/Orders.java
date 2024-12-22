package com.ecom.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "userId , productId")
public class Orders extends BaseClass {

	private double bill;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;
}
