package org.sergei.restapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CategoryDAO {

	private static Map<String, Category> categoryMap = new HashMap<>();
	private static Map<String, Collection<Book>> bookMap = new HashMap<>();

	static {

		Category category1 = new Category();
		category1.setCategoryId("001");
		category1.setCategoryName("Java");
		categoryMap.put(category1.getCategoryId(), category1);

		Book book1 = new Book();
		book1.setAuthor("Naveen Balani");
		book1.setBookName("Spring Series");
		book1.setBookId("001");
		book1.setBookISBNnumber("ISB001");

		Book book2 = new Book();
		book2.setAuthor("Rajeev Hathi");
		book2.setBookName("CXF Series");
		book2.setBookId("002");
		book2.setBookISBNnumber("ISB002");

		Collection<Book> booksList = new ArrayList<Book>();
		booksList.add(book1);
		booksList.add(book2);

		bookMap.put(category1.getCategoryId(), booksList);
	}

	public void addCategory(Category category)
	{
		categoryMap.put(category.getCategoryId(), category);
	}

	public void addBook(Category category)
	{
		bookMap.put(category.getCategoryId(), category.getBooks());
	}

	public Collection<Book> getBooks(String categoryId)
	{
		return bookMap.get(categoryId);
	}

	public Category getCategory(String id)
	{
		Category cat = null;

		if( categoryMap.get(id) != null ) {
			cat = new Category();
			cat.setCategoryId(categoryMap.get(id).getCategoryId());
			cat.setCategoryName(categoryMap.get(id).getCategoryName());
		}
		return cat;
    }

	public void deleteCategory(String id)
	{
		categoryMap.remove(id);
		bookMap.remove(id);
	}

	public void updateCategory(Category category)
	{
		categoryMap.put(category.getCategoryId(), category);
	}
}
