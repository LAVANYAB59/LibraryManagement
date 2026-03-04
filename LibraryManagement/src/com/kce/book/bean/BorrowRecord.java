package com.kce.book.bean;

import java.time.LocalDate;

public class BorrowRecord {
private String bookId;
private LocalDate borrowDate;
private LocalDate dueDate;
public BorrowRecord(String bookId) {
	this.bookId=bookId;
	this.borrowDate=LocalDate.now();
	this.dueDate=borrowDate.plusDays(14);
}
public String getBookId() {
	return bookId;
}
public LocalDate getBorrowDate() {
	return borrowDate;
}
public LocalDate getDueDate() {
	return dueDate;
}
}
