package com.gcep.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcep.exception.DatabaseException;
import com.gcep.model.ProductModel;
import com.gcep.model.ProductRowMapper;

@Repository
public class ProductDataService implements ProductDataServiceInterface {
	
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbc;
	
	
	public ProductDataService(DataSource data) {
		this.dataSource = data;
		this.jdbc = new JdbcTemplate(data);
	}

	@Override
	public ProductModel getProduct(int id) {
		ProductModel product = null;
		try {
			product = jdbc.queryForObject("SELECT * FROM products WHERE ID=?", new ProductRowMapper(), new Object[] {id});
			return product;
		} catch (Exception e) {
			throw new DatabaseException("An error has occured while trying to get the data.");
		}
	}

	@Override
	public List<ProductModel> getProducts() {
		List<ProductModel> products = null;
		try {
			products = jdbc.query("SELECT * FROM products", new ProductRowMapper());
			return products;
		} catch (Exception e) {
			throw new DatabaseException("An error has occured while trying to get the data.");
		}
	}

	@Override
	public List<ProductModel> searchProducts(String name) {
		List<ProductModel> products = null;
		try {
			products = jdbc.query("SELECT * FROM products WHERE NAME LIKE ?", new ProductRowMapper(), new Object[] {"%" + name + "%"});
			return products;
		} catch (Exception e) {
			throw new DatabaseException("An error has occured while trying to get the data.");
		}
	}

	@Override
	public int createProduct(ProductModel product) {
		int result = 0;
		try {
			result = jdbc.update("INSERT INTO products (NAME, QUANTITY, IMAGE_NAME) VALUES (?,?,?)",
					product.getName(),
					product.getQuantity(),
					product.getImage_name());
			return result;
		} catch (Exception e) {
			throw new DatabaseException("An error has occured while trying to create a product.");
		}
	}

	@Override
	public ProductModel updateProduct(ProductModel editedProduct) {
		ProductModel result = null;
		try {
			int rows = jdbc.update("UPDATE products SET NAME=?, QUANTITY=?, IMAGE_NAME=? WHERE ID=?",
					editedProduct.getName(),
					editedProduct.getQuantity(),
					editedProduct.getImage_name(),
					editedProduct.getId());
			if (rows == 1) {
				result = editedProduct;
			}
			return result;
		} catch (Exception e) {
			throw new DatabaseException("An error has occured while trying to update a product.");
		}
	}

	@Override
	public int deleteProduct(int id) {
		int result = 0;
		try {
			result = jdbc.update("DELETE FROM products WHERE ID=?", id);
			return result;
		} catch (Exception e) {
			throw new DatabaseException("An error has occured while trying to delete a product.");
		}
	}

}
