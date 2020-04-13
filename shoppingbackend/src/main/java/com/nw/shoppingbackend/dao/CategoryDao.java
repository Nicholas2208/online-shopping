package com.nw.shoppingbackend.dao;

import java.util.List;

import com.nw.shoppingbackend.dto.Category;

public interface CategoryDao {
	
	boolean add(Category category);
	
	List<Category> list();
	
	Category get(int id);
	
	boolean update(Category category);
	
	boolean delete(Category category);

}
