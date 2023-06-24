package com.SpringDocImage.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SpringDocImage.demo.model.ProductModel;
import com.SpringDocImage.demo.repository.RepoInterface;
@Service
public class serviceImplement implements ServiceInterface {

	@Autowired
	
	RepoInterface repo;
	
	
	

	@Override
	public ProductModel uplodeFile(ProductModel proModel, MultipartFile mulp, String product_Name, MultipartFile mulp2) {
		proModel.setProduct_Name(product_Name);
		try {
			proModel.setImage(mulp.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			proModel.setDocument(mulp2.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return repo.save(proModel);
	}

	@Override



	public  ProductModel retriveFile() {
//		ProductModel proModel2 = new ProductModel();
		long m = repo.count();
		System.out.println("this is the count"+m);
//		System.out.println("this is the product "+proModel2.getProduct_Name());
		
		for(int i=1; i<=m; i++) {
			
		String me =repo.findProductNameById((int) i);
		System.out.println("this is id"+me);
		byte [] me1 =repo.findProductNameByImage((int) i);
		System.out.println("this is id"+me1);
		byte[] me2 =repo.findProductNameByDocument((int) i);
		System.out.println("this is id"+me2);
		
		Object[] arr = {me, me1, me2};
		
		
//		System.out.println("this is byte"+proModel2.getImage());
//	   for(long i=0; (long)i<= repo.count(); i++) {
//	    ProductModel proModel1 = repo.findById(1L).orElse(null);
//	    
//	    
//
//	    if (proModel1 != null) {
//	    	
//	        byte[] m1 = proModel1.getImage();
//	        byte[] m2 = proModel1.getDocument();
		
	        for(Object j: arr) {
	        try (FileOutputStream fos = new FileOutputStream("C:/Users/Naveen/Downloads/file1.txt")) {
	        	ProductModel retrievedModel = new ProductModel();
	        	fos.write(me1);
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }

	        try (FileOutputStream fos = new FileOutputStream("C:/Users/Naveen/Downloads/file2.txt")) {
	            fos.write(me2);
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
//	        ProductModel retrievedModel = proModel1;
//            return retrievedModel;
//	    }
	   
//	}
	        ProductModel retrievedModel = new ProductModel();
	        retrievedModel.setProduct_Name(me);
	        retrievedModel.setImage(me1);
	        retrievedModel.setDocument(me2);

	        return retrievedModel;
	


	        }
			
	        	
	}
		return null;
	}
	
	
}
	



