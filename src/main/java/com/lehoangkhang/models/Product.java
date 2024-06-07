package com.lehoangkhang.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	@Column(name = "product_name")
	private String productName;
//	size = max
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	private Double price;
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category  category;

	public Product(Integer id, String productName, String description, Double price, String image) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
				+ price + ", image=" + image + "]";
	}
	
	
}
