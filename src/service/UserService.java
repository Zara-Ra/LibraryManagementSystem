package service;

import data.model.Account;
import data.model.Book;
import data.model.user.User;
import data.repository.AccountRepo;
import data.repository.UserRepo;

import java.sql.SQLException;

public class UserService implements LibraryService{
    private AccountRepo accountRepo = new AccountRepo();
    private UserRepo userRepo = new UserRepo();
    private AccountService accountService = new AccountService();
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

    public void borrowBook(User user, Book book) throws SQLException {
        accountService.borrowBook(user.getAccount(),book);
    }
    public void returnBook(User user,Book book) throws SQLException{
        accountService.returnBook(user.getAccount(),book);
    }
    public User findUserByAccountID(int accountID) throws SQLException {
        return userRepo.findUserByAccountID(accountID);
    }
}
