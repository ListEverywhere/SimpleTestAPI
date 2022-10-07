package com.gcep.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcep.data.ProductDataServiceInterface;
import com.gcep.model.ProductModel;

@RequestMapping("/products")
@RestController
public class ProductsRestApi {

	@Autowired
	ProductDataServiceInterface productsDAO;
	
	@GetMapping("/")
	public ResponseEntity<?> products() {
		List<ProductModel> products = productsDAO.getProducts();
		if (products != null) {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
