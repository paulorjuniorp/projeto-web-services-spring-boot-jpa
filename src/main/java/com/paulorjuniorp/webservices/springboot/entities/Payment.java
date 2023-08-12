package com.paulorjuniorp.webservices.springboot.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date moment;
	
	private Order order;
	
	public Payment() {
	}

	public Payment(Long id, Date moment, Order order) {
		super();
		this.id = id;
		this.moment = moment;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
