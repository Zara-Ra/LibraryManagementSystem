package presentation;

import data.enums.ClassType;
import data.model.Account;
import data.model.Book;
import data.model.user.Student;
import data.model.user.User;
import service.BookService;
import service.LibrarianService;
import service.UserService;

import java.sql.Date;
import java.sql.SQLException;

public class MainHandler {
    public UserService userService = new UserService();
    public LibrarianService librarianService = new LibrarianService();
    public BookService bookService = new BookService();

    public void FirstMenu() throws SQLException {
        //Account account = new Account("Zari", "Zari", 0, 0, 0, 0, 0);
        //User user = new Student("Zahra", "0912", account, 12345, ClassType.MASTER);

        //userService.register(account,user);
        Account login = userService.login("Zari", "Zari");
        User user = userService.findUserByAccountID(login.getID());
        user.setAccount(login);
        System.out.println(user);
        System.out.println(login);
        Book book = new Book("Cinderella", "James", "Star", "N121323242");
        bookService.addBook(book);
        //System.out.println(bookService.searchBook("Cinderella"));
        //bookService.deleteBook(book);
        userService.borrowBook(user,book);

    }

}
