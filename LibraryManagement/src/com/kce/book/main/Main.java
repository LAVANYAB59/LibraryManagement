package com.kce.book.main;

import java.util.Scanner;

import com.kce.book.service.LibraryService;

public class Main {
public static void main(String[]args) {
	Scanner scan=new Scanner(System.in);
	LibraryService service=new LibraryService();
	while(true) {
		System.out.println("\n Library Management System");
		System.out.println("1.Add Book");
		System.out.println("2.Register Member");
		System.out.println("3.Borrow Book");
		System.out.println("4.Return Book");
		System.out.println("5.Search Book");
		System.out.println("6.Member Report");
		System.out.println("7.Book Report");
		System.out.println("8.Top Borrowers");
		System.out.println("9.Exit");
		int choice=scan.nextInt();
		scan.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Boo ID:");
			String bid=scan.nextLine();
			System.out.println("Title:");
			String title=scan.nextLine();
			System.out.println("Author:");
			String author=scan.nextLine();
			System.out.println("Copies:");
			int copies=scan.nextInt();
			service.addBook(bid, title, author, copies);
			break;
		case 2:
			System.out.println("Member ID:");
			String mid=scan.nextLine();
			System.out.println("Name:");
			String name=scan.nextLine();
			service.registerMember(mid,name);
			break;
		case 3:
			System.out.println("Member Id:");
			mid=scan.nextLine();
			System.out.println("Book ID:");
			bid=scan.nextLine();
			service.borrowBook(mid,bid);
			break;
		case 4:
			System.out.println("Member ID:");
			mid=scan.nextLine();
			System.out.println("Book ID:");
			bid=scan.nextLine();
			service.returnBook(mid, bid);
			break;
		case 5:
			System.out.println("keyword:");
			String keyword=scan.nextLine();
			service.searchBook(keyword);
			break;
		case 6:
			System.out.println("Member ID:");
			mid=scan.nextLine();
			service.memberReport(mid);
			break;
		case 7:
			System.out.println("Book ID:");
			bid=scan.nextLine();
			service.bookReport(bid);
			break;
		case 8:
			service.topBorrowers();
			break;
		case 9:
			System.out.println("Existing...!");
			return;
		default:
			System.out.println("Invalid choice");
		}
	}
}
}
