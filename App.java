package com.mitesh;

import com.mit.jdbc.model.service.BookService;
import java.util.Scanner;




public class App 
{
	 public static void main( String[] args ) 

	    {
		   BookService bookService = new BookService();
		   Scanner sc = new Scanner(System.in);
		   int opt = 0 ;
		   do {
			   System.out.println("1. add book");
			   System.out.println("2  Show all Book");
		       System.out.println("3  Show Books by category");
		       System.out.println("4  Show Book by title");
		       System.out.println("5  Delete Book By Title");
		       System.out.println("6 Exit");
		       System.out.println("enter your option:--    ");
		       opt = sc.nextInt();
		       sc.next();
		       switch(opt){
		              case  1: 
		              bookService.addBooK();
		              break;
		            case 2:
		             bookService.showAllBooks();
		             break;
		            case  3:
		            bookService.shopwBookByCategory();
		             break;
		           case 4:
		    	   bookService.showBookByTitle();
		    	   break;
		            case 5 : 
		    	   bookService.deleteBookByTitle();
		    	   break;
		           case 6:
		    	   System.out.println("you are quiting menu");
		    	   break;
		    	   default:
		    	   System.out.println("not a correct option...plase hose correct option");
		    	
		         
		    	   
		       }
		   
		   
		 
	    } while(opt!=6);
	    				
	    }      
}
