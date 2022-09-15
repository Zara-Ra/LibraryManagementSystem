package data.repository;

import data.model.Book;
import utils.ApplicationConstant;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO book (title,author,isbn,publication,due_date) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,book.getTitle());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setString(3,book.getISBN());
        preparedStatement.setString(4,book.getPublication());
        preparedStatement.setDate(5,book.getDueDate());
        preparedStatement.executeUpdate();
    }
    public void deleteBook(Book book) throws SQLException {
        String sql = "DELETE FROM book WHERE title = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,book.getTitle());
        preparedStatement.executeUpdate();
    }
    public Book searchBook(String title) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM book WHERE title = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,title);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            String booktitle = resultSet.getString(1);
            String author = resultSet.getString(2);
            String isbn = resultSet.getString(3);
            String pub = resultSet.getString(4);
            Date dueDate = resultSet.getDate(5);
            book = new Book(booktitle,author,pub,isbn,dueDate);
        }
        return book;
    }

    public Date findDueDate(Book book) throws SQLException {
        Date date = null;
        String sql = "SELECT due_date From book where id = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, book.getID());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            date = resultSet.getDate(1);
        }
        return date;
    }
    public int getBookID(String title) throws SQLException {
        int result = 0 ;
        String sql = "SELECT id From book where title = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, title);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            result = resultSet.getInt(1);
        }
        return result;
    }

    public List<Book> allBooks() throws SQLException {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT title, author FROM book";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String bookTitle = resultSet.getString(1);
            String author = resultSet.getString(2);
            Book book = new Book(bookTitle,author);
            bookList.add(book);
        }
        return bookList;
    }
}
