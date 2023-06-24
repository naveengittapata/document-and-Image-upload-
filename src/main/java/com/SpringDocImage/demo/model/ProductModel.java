package com.SpringDocImage.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data

//@Getter
//@Setter
@Entity
@Table(name = "ImageDoc")
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	//	@NotEmpty(message = "should be not empty")
	@Column(name = "product_Name")
	public String product_Name;

	@Column(name = "document")
	public byte[] document;

	@Column(name = "image")
	public byte[] image;



}
