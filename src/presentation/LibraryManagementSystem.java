package presentation;

import data.enums.ClassType;
import data.model.Account;
import data.model.user.Student;
import data.model.user.User;
import service.AccountService;
import service.LibrarianService;
import service.UserService;

import java.sql.SQLException;

public class LibraryManagementSystem {

    public static void main(String[] args) throws SQLException {
        MainHandler mainHandler = new MainHandler();
        mainHandler.FirstMenu();
    }

}
