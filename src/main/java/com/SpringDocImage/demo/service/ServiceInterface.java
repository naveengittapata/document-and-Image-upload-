package com.SpringDocImage.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.SpringDocImage.demo.model.ProductModel;

public interface ServiceInterface {
	
	public ProductModel uplodeFile(ProductModel proModel, MultipartFile mulp, String product_Name,MultipartFile mulp2);
	public ProductModel retriveFile();
	


}