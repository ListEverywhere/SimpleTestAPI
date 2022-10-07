package com.gcep.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gcep.model.ProductModel;

public class ProductDataService implements ProductDataServiceInterface {
	
	JdbcTemplate jdbc;
	DataSource data;
	
	
	public ProductDataService(DataSource data) {
		this.data = data;
		this.jdbc = new JdbcTemplate(data);
	}

	@Override
	public ProductModel getProduct(int it) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> searchProducts(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createProduct(ProductModel product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductModel updateProduct(int id, ProductModel editedProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
