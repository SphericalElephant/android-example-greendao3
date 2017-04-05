package com.sphericalelephant.example.greendao3.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by siyb on 05/04/17.
 */

@Entity
public class OrderProduct {
	@Id
	private Long id;
	private Long productId;
	private Long orderId;
	@Generated(hash = 1505960636)
	public OrderProduct(Long id, Long productId, Long orderId) {
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
	}
	@Generated(hash = 1818552344)
	public OrderProduct() {
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return this.productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getOrderId() {
		return this.orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
