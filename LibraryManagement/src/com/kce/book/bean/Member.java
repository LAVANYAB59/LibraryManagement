package com.kce.book.bean;
import java.util.*;

public class Member {
private String memberId;
private String name;
private int totalBooksBorrowed;
private Map<String,BorrowRecord>borrowedBooks;
public Member(String memerId,String name) {
	this.memberId=memberId;
	this.name=name;
	this.totalBooksBorrowed=0;
	this.borrowedBooks=new HashMap<>();
}
public String getMemberId() {
	return memberId;
}
public String getName() {
	return name;
}
public int getTotalBooksBorrowed() {
	return totalBooksBorrowed;
}
public Map<String,BorrowRecord>getBorrowedBooks(){
	return borrowedBooks;
}
public void incrementTotalBorrowed() {
	totalBooksBorrowed++;
}
}
