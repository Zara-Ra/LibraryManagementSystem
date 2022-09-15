package service;

import data.model.Book;
import data.model.user.User;
import data.repository.AccountBookRepo;
import data.repository.AccountRepo;
import data.repository.BookRepo;

import java.sql.Date;
import java.sql.SQLException;

public class LibrarianService {
    BookRepo bookRepo = new BookRepo();
    AccountBookRepo accountBookRepo = new AccountBookRepo();
    AccountRepo accountRepo = new AccountRepo();

    public boolean verifyUser() {
        return false;
    }

    public boolean acceptBorrowBook(int bookID) throws SQLException {
        return accountBookRepo.acceptBookBorrow(bookID);
    }

    public boolean acceptReturnBook(int bookID, int userID) throws SQLException {
        return accountBookRepo.acceptRetrunBook(bookID, userID);
    }

    public boolean isBookLost(User user, Book book) throws SQLException {
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        Date due = bookRepo.findDueDate(book);
        if (today.after(due)) {
            accountRepo.lostBook(user.getAccount());
            return true;
        }
        return false;
    }
}
