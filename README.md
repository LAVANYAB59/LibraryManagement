📚 Library Management System

📌 Project Description

The Library Management System is a console-based Java application that simulates basic library operations.
The system works entirely in memory (no database or file storage) and allows users to manage books and members efficiently.

This project follows a Low-Level Design (LLD) approach using:

Bean (Model) Classes

Service Layer

Main (Menu-driven Console)

🏗️ Project Structure

LibraryManagement

│

├── src

│   ├── com.kce.book.bean

│   │   ├── Book.java

│   │   ├── BorrowRecord.java

│   │   ├── Member.java

│   │

│   ├── com.kce.book.service

│   │   ├── LibraryService.java

│   │

│   ├── com.kce.book.main

│   │   ├── Main.java

│   │

│   └── module-info.java

🚀 Features

1️⃣ Add Book

Add new books to the library.

Each book must have a unique Book ID.

Stores title, author, and number of copies.

2️⃣ Register Member

Register new members.

Each member must have a unique Member ID.

3️⃣ Borrow Book

A member can borrow maximum 3 books.

A book can only be borrowed if copies are available.

Borrow date is recorded automatically.

Due date is set to 14 days from borrow date.

A member cannot borrow the same book twice simultaneously.

4️⃣ Return Book

Calculates fine if overdue.

Fine: Rs. 2 per overdue day

Available copies increase when returned.

5️⃣ Search Book

Search by title or author.

Supports partial keyword matching.

6️⃣ Member Report

Displays books currently borrowed by a member.

Shows borrow date and due date.

7️⃣ Book Report

Shows total and available copies.

Displays members who borrowed the book.

8️⃣ Top Borrowers

Lists members sorted by total number of books ever borrowed (descending).

⚙️ Technologies Used

Java 23

Collections Framework (HashMap, ArrayList, Set)

LocalDate API

ChronoUnit for fine calculation

🧠 Design Approach

🔹 Bean Layer

Book – Stores book details and availability.

Member – Stores member details and borrowed books.

BorrowRecord – Stores borrow date and due date.

🔹 Service Layer

LibraryService handles all business logic.

🔹 Main Layer

Menu-driven console interaction.

🔒 Constraints Followed

No database or file storage (fully in-memory).

Unique Book ID and Member ID.

Max 3 books per member.

14-day due period.

Fine calculation implemented.

Proper validation and error messages.

🖥️ How to Run

Open the project in Eclipse / IntelliJ.

Run Main.java.

Use the menu options in the console.

📌 Sample Menu

1. Add Book

2. Register Member

3. Borrow Book

4. Return Book

5. Search Book

6. Member Report

7. Book Report

8. Top Borrowers

9. Exit

📈 Future Improvements

Add file/database persistence

Add exception handling

Convert to Spring Boot REST API

Add GUI (JavaFX / Swing)

Add Admin login system

👨‍💻 Author

Lavanya B

Output:

<img width="659" height="482" alt="image" src="https://github.com/user-attachments/assets/b54ff376-e05b-464a-80d0-89887e2c6f78" />

