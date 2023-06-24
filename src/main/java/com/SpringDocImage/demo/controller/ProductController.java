package com.SpringDocImage.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.SpringDocImage.demo.model.ProductModel;
import com.SpringDocImage.demo.service.ServiceInterface;



@RestController
@RequestMapping("/doc/uplode")
public class ProductController {
	@Autowired
	ServiceInterface InterService;
	
	
	
	@PostMapping("/doc")
	public ResponseEntity<ProductModel> UploadDocImg(@RequestParam("product_Name")String product_Name, MultipartFile files1, MultipartFile file2,ProductModel m2){
		
		ProductModel me2 = InterService.uplodeFile(m2, files1, product_Name, file2);
		
		return new ResponseEntity<ProductModel>(me2,HttpStatus.OK);
		
	}
	
	
	@GetMapping("doc/retrive")
	public ResponseEntity<ProductModel> RetrivemyFile(){
		
		ProductModel me1= InterService.retriveFile();
		
		return new ResponseEntity<ProductModel>(me1,HttpStatus.OK);
		
		
	}
	

}
