package com.gcep.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<?> product(@PathVariable(name="id") int id) {
		ProductModel product = productsDAO.getProduct(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createProduct(@RequestBody ProductModel newProduct) {
		int result = productsDAO.createProduct(newProduct);
		if (result == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<?> editProduct(@RequestBody ProductModel updated) {
		ProductModel product = productsDAO.updateProduct(updated);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteproduct(@PathVariable(name="id") int id) {
		int result = productsDAO.deleteProduct(id);
		if (result == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
