package com.nw.shoppingbackend.dao;

import java.util.List;

import com.nw.shoppingbackend.dto.Product;

public interface ProductDao {

	Product get(int productId);

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	// business methods
	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryId);

	List<Product> getLatestActiveProducts(int count);

}
