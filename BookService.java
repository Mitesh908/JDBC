package com.mit.jdbc.model.service;
import java.util.Scanner;

import com.mitesh.Book;
import com.mitesh.model.dao.BookDAO;


public class BookService {
	
	public static Scanner sc = new Scanner(System.in);
	private BookDAO bdao = new BookDAO();
	public String addBooK()
	{
		System.out.println("Enter Book id");
		String bookId =  sc.nextLine();
		System.out.println("Enter book title");
		String bookTitle =  sc.nextLine();
		System.out.println("Enter book Author");
		String bookAuthor =  sc.nextLine();
		System.out.println("Enter book Categroy");
		String bookCategory =  sc.nextLine();
		System.out.println("Enter book price");
		double bookPrice =  sc.nextDouble();
		System.out.println("Enter book title");
		int copies =  sc.nextInt();
		sc.next();
		if(bdao.insertBook(new Book(bookId,bookTitle,bookAuthor,bookCategory,bookPrice,copies)))
			return "BOOK Details Added";
		return "Book Addtion fAILED";

	}
	
	public void showAllBooks()
	{
		for(Book b : bdao.getAllBook())
		System.out.println(b.getBookId()+"  "+b.getBookTitle()+"  "+b.getBookAuthor()+"   "+b.getBookCategory()+"   "+b.getBookPrice()+"   "+b.getCopies());
		
	}
	
	public void shopwBookByCategory()
	{
		System.out.println("ENter bok categrory");
		String category = sc.nextLine();
	    for(Book b : bdao.getBookByCategory(category))
	    	System.out.println(b.getBookId()+"  "+b.getBookTitle()+"  "+b.getBookAuthor()+"   "+b.getBookCategory()+"   "+b.getBookPrice()+"   "+b.getCopies());
	    	
	}
	
	public void showBookByTitle()
	{
		System.out.println("enter book tile");
		String bookTitle = sc.nextLine();
		Book b = bdao.getBookByTitle(bookTitle);
				if(b!=null)
					System.out.println(b.getBookId()+"  "+b.getBookTitle()+"  "+b.getBookAuthor()+"   "+b.getBookCategory()+"   "+b.getBookPrice()+"   "+b.getCopies());
				else
					System.out.println("book does not exist"+bookTitle);
	}
	
	public void deleteBookByTitle() {
		System.out.println("enter booik title");
		String bookTitle = sc.nextLine();
		if(bdao.deleteBookByTitle(bookTitle))
			System.out.println(bookTitle+"deleted successfully");
		else
			System.out.println("book not exist"+bookTitle);
	}

}
