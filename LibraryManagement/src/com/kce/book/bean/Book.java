package com.kce.book.bean;
import java.util.*;
public class Book {
private String bookId;
private String title;
private String author;
private int totalCopies;
private int availableCopies;
private int totalBorrowCount;
private Set<String>borrowedByMembers;
public Book(String bookId,String title,String author,int copies) {
	this.bookId=bookId;
	this.title=title;
	this.author=author;
	this.totalCopies=copies;
	this.availableCopies=copies;
	this.totalBorrowCount=0;
	this.borrowedByMembers=new HashSet<>();
}
public String getBookId() {
	return bookId;
}
public String getTitle() {
	return title;
}
public String getAuthor() {
	return author;
}
public int getTotalCopies() {
	return totalCopies;
}
public int getAvailableCopies() {
	return availableCopies;
}
public int getTotalBorrowCount() {
	return totalBorrowCount;
}
public Set<String>getBorrowedByMembers(){
	return borrowedByMembers;
}
public void decreaseCopy() {
	availableCopies--;
}
public void increaseCopy() {
	availableCopies++;
}
public void incrementBorrowCount() {
	totalBorrowCount++;
}
}
