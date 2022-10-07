package com.gcep.data;

import java.util.List;

import com.gcep.model.ProductModel;

public interface ProductDataServiceInterface {
	public ProductModel getProduct(int id);
	public List<ProductModel> getProducts();
	public List<ProductModel> searchProducts(String name);
	public int createProduct(ProductModel product);
	public ProductModel updateProduct(int id, ProductModel editedProduct);
	public int deleteProduct(int id);
}
