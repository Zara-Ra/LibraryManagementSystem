package data.model;

import data.model.Book;
import data.model.user.Librarian;
import data.model.user.User;

import java.util.List;

public class Library {
    private List<User> userList;
    private List<Book> bookList;
    private Librarian librarian;
}
