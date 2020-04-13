package com.nw.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nw.shoppingbackend.dao.CategoryDao;
import com.nw.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nw.shoppingbackend");
		context.refresh();
		
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	
	@Test
	public void testCRUDCategory() {
		// add
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageUrl("CAT_1.png");
		assertEquals("Successfully added a category into the table.", true, categoryDao.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageUrl("CAT_2.png");
		assertEquals("Successfully added a category into the table.", true, categoryDao.add(category));
		
		// update
	    category = categoryDao.get(2);
	    category.setName("TV");
	    assertEquals("Successfully updated a category in the table.",
	                                 true,   categoryDao.update(category));
	    
	    // delete
	    assertEquals("Successfully deleted a category in the table.",
                true, categoryDao.delete(category));
	    
	    // fetch list
	    assertEquals("Successfully fetched a list of categories from the table.", 1, categoryDao.list().size());
	    
	    
	}
	
}
