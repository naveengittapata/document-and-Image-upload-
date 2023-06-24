package com.SpringDocImage.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringDocImage.demo.model.ProductModel;

public interface RepoInterface extends JpaRepository<ProductModel, Long> {
	@Query(value= "SELECT p.product_Name FROM Imagedoc p WHERE p.id = :productId",nativeQuery = true)
	public String findProductNameById(int productId);
	@Query(value= "SELECT p.image FROM Imagedoc p WHERE p.id = :productId",nativeQuery = true)
    public byte [] findProductNameByImage(int productId);
	@Query(value= "SELECT p.document FROM Imagedoc p WHERE p.id = :productId",nativeQuery = true)
	public byte[] findProductNameByDocument(int productId);
	


}
