package service;

import data.model.Book;
import data.repository.BookRepo;

import java.sql.Date;
import java.sql.SQLException;

public class BookService {
    private BookRepo bookRepo = new BookRepo();
    public void addBook(Book book) throws SQLException {
        //Validation...
        long millis=System.currentTimeMillis();
        Date today = new Date(millis);
        millis += 1.21e+9;
        Date dueDate = new Date(millis);
        book.setDueDate(dueDate);
        bookRepo.addBook(book);
        book.setID(getBookID(book.getTitle()));
    }
    public int getBookID(String title) throws SQLException {
        return bookRepo.getBookID(title);
    }
    public void deleteBook(Book book) throws SQLException {
        bookRepo.deleteBook(book);
    }
    public Book searchBook(String title) throws SQLException {
        return bookRepo.searchBook(title);
    }
}
