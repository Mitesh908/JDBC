package com.mitesh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.mitesh.Book;



public class BookDAO {

	private static String url = "jdbc:mysql//localhost:3306/mysql";
	
	public boolean insertBook(Book book)
	{
		int count =0;
		try(Connection con = DriverManager.getConnection(url,"root","Mitesh@123");
				PreparedStatement pst = con.prepareStatement("insert into book values(?,?,?,?,?)"))
		{
			pst.setString(1,book.getBookId());
			pst.setString(2, book.getBookTitle());
			pst.setString(3,book.getBookAuthor());
			pst.setString(4, book.getBookCategory());
			pst.setDouble(5,book.getBookPrice());
			pst.setInt(6,book.getCopies());
			count = pst.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return count==1;
		
	}
	
	public ArrayList<Book> getBookByCategory(String bookCategory)
	{
		ArrayList<Book> blist = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(url,"root","Mitesh@123");
				PreparedStatement pst = con.prepareStatement("insert into book where book_category = ?"))
									
		{
					pst.setString(1, bookCategory);
			        ResultSet rs = pst.executeQuery();
			        while(rs.next())
			        	blist.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6)));
		}
		catch(Exception ex)
		{
					ex.printStackTrace();
		}
		return blist;
	}
	public ArrayList<Book> getAllBook()
	{
		ArrayList<Book> blist = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(url,"root","Mitesh@123");
				PreparedStatement pst = con.prepareStatement("select * from book"))
		      
									
		{
			 ResultSet rs = pst.executeQuery();
				
			        while(rs.next())
			        	blist.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6)));
		}
		catch(Exception ex)
		{
					ex.printStackTrace();
		}
		return blist;
		
	}
	public Book getBookByTitle(String bookTitle)
	{
		Book book = null;
		
		try(Connection con = DriverManager.getConnection(url,"root","Mitesh@123");
				PreparedStatement pst = con.prepareStatement("insert into book where book_title = ?"))
									
		{
					pst.setString(1, bookTitle);
			        ResultSet rs = pst.executeQuery();
			        if(rs.next())
			        	book = new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
		}
		catch(Exception ex)
		{
					ex.printStackTrace();
		}
		return book;
		
	}
	
	public boolean deleteBookByTitle(String bookTitle)
	{
		int count =0;
		try(Connection con = DriverManager.getConnection(url,"root","Mitesh@123");
				PreparedStatement pst = con.prepareStatement("delete from book where book_title=?"))
		{
			pst.setString(1, bookTitle);
			count = pst.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return count==1;
	}
}
