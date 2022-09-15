package service;

import data.model.Account;
import data.model.user.User;

import java.sql.SQLException;

public interface LibraryService {
    Account login(String username,String password) throws SQLException;
    boolean logout(User user);
    int register(Account account, User user) throws SQLException;
}
