package com.kce.book.service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.kce.book.bean.Book;
import com.kce.book.bean.BorrowRecord;
import com.kce.book.bean.Member;

public class LibraryService {
private Map<String,Book>books=new HashMap<>();
private Map<String,Member>members=new HashMap<>();
public void addBook(String id,String title,String author,int copies) {
	if(books.containsKey(id)) {
		System.out.println("Book ID Already Exits..!");
		return;
	}
	books.put(id, new Book(id,title,author,copies));
	System.out.println("Book Added Successfully..!");
}
public void registerMember(String id,String name) {
	if(members.containsKey(id)) {
		System.out.println("Member ID Already exits..!");
	}
	members.put(id, new Member(id,name));
	System.out.println("Member Registered Succesfully");
}
public void borrowBook(String memberId,String bookId) {
	Member member=members.get(memberId);
	Book book=books.get(bookId);
	if(member==null) {
		System.out.println("Member Not Found..!");
		return;
	}
	if(book==null) {
		System.out.println("Book Not Found..!");
		return;
	}
	if(member.getBorrowedBooks().size()>=3) {
		System.out.println("Borrow Limit Reached (Max 3 Books).");
		return;
	}
	if(member.getBorrowedBooks().containsKey(bookId)) {
		System.out.println("Member Already Borrowed this Book.");
		return;
	}
	if(book.getAvailableCopies()<=0) {
		System.out.println("No Copies Available.");
		return;
	}
	BorrowRecord record=new BorrowRecord(bookId);
	member.getBorrowedBooks().put(bookId, record);
	member.incrementTotalBorrowed();
	book.decreaseCopy();
	book.incrementBorrowCount();
	book.getBorrowedByMembers().add(memberId);
	System.out.println("Book Borrowed Successfully..!");
}
public void returnBook(String memberId,String bookId) {
	Member member=members.get(memberId);
	Book book=books.get(bookId);
	if(member==null||book==null) {
		System.out.println("Member or Book not Found..!");
		return;
	}
	BorrowRecord record=member.getBorrowedBooks().remove(bookId);
	if(record==null) {
		System.out.println("This Book was not Borrowed by the Member.");
		return;
	}
	book.increaseCopy();
	book.getBorrowedByMembers().remove(memberId);
	LocalDate today=LocalDate.now();
	long overdueDays=ChronoUnit.DAYS.between(record.getDueDate(),today);
	if(overdueDays>0) {
		long fine=overdueDays*2;
		System.out.println("Book returned with fine:Rs."+fine);
	}else {
		System.out.println("Book returned Succesfully.No Fine.");
	}
}
public void searchBook(String keyword) {
	keyword=keyword.toLowerCase();
	for(Book book:books.values()) {
		if(book.getTitle().toLowerCase().contains(keyword)||book.getAuthor().toLowerCase().contains(keyword)) {
			System.out.println(book.getBookId()+"|"+book.getTitle()+"|"+book.getAuthor()+"|Available:"+ book.getAvailableCopies());
		}
	}
}
public void memberReport(String memberId) {
	Member member=members.get(memberId);
	if(member==null) {
		System.out.println("Member not Found..!");
		return;
	}
	for(BorrowRecord record:member.getBorrowedBooks().values()) {
		System.out.println("Book ID:"+record.getBookId()+"|Borrow Date:"+record.getBorrowDate()+"|Due Date:"+record.getDueDate());
	}
}
public void bookReport(String bookId) {
	Book book=books.get(bookId);
	if(book==null) {
		System.out.println("Book not Found..!");
		return;
	}
	System.out.println("TotalCopies:"+book.getTotalCopies());
	System.out.println("Available Copies:"+book.getAvailableCopies());
	System.out.println("Borrowed by Members:"+book.getBorrowedByMembers());
}
public void topBorrowers() {
	java.util.List<Member>list=new ArrayList<>(members.values());
	list.sort((a,b)->b.getTotalBooksBorrowed()-a.getTotalBooksBorrowed());
	for(Member m:list) {
		System.out.println(m.getMemberId()+"|"+m.getName()+"|Total Borrowed:"+m.getTotalBooksBorrowed());
	}
}
}
