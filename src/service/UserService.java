package service;

import data.model.Account;
import data.model.Book;
import data.model.user.User;
import data.repository.AccountRepo;
import data.repository.UserRepo;

import java.sql.SQLException;
import java.util.List;

public class UserService implements LibraryService{
    private AccountRepo accountRepo = new AccountRepo();
    private UserRepo userRepo = new UserRepo();
    private AccountService accountService = new AccountService();
    private BookService bookService = new BookService();
    @Override
    public Account login(String username, String password) throws SQLException {
        return accountRepo.login(username,password);
    }

    @Override
    public boolean logout(User user) {
        user = null;
        return true;
    }

    @Override
    public boolean register(Account account, User user) throws SQLException {
        accountRepo.addAccount(account);
        int accountID = accountRepo.findAccountID(account);
        user.getAccount().setID(accountID);
        return userRepo.addUser(user);

    }

    public void borrowBook(User user, String bookTitle) throws SQLException {
        int bookID = bookService.getBookID(bookTitle);
        accountService.borrowBook(user.getAccount(),bookID);
    }
    public void returnBook(User user,String bookTitle) throws SQLException{
        int bookID = bookService.getBookID(bookTitle);
        if(bookID != 0) {
            accountService.returnBook(user.getAccount(), bookID);
        }
    }
    public User findUserByAccountID(int accountID) throws SQLException {
        return userRepo.findUserByAccountID(accountID);
    }

    public List<Book> showAllBooks() throws SQLException {
        return bookService.showAllBooks();
    }
}
