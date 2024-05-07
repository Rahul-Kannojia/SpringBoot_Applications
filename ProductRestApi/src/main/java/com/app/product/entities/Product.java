package com.app.product.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@Column(name="name")
	@NotNull
	private String pname;
	@Size(min = 2, max = 50, message = "Description length should between 2 to 50")
	private String description;
	@Min(value = 1)
	private double price;
	public Integer getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
