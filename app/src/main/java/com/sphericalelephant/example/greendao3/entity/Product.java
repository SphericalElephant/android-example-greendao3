package com.sphericalelephant.example.greendao3.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by siyb on 05/04/17.
 */

@Entity
public class Product {
	@Id(autoincrement = true)
	private Long id;

	@NotNull
	private String name;

	@Unique
	private String internalId;

	@Transient
	private Object doNotSaveToDatabase;

	@Generated(hash = 1134267206)
	public Product(Long id, @NotNull String name, String internalId) {
		this.id = id;
		this.name = name;
		this.internalId = internalId;
	}

	@Generated(hash = 1890278724)
	public Product() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternalId() {
		return this.internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}
}
