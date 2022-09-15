package service;

import data.model.Account;
import data.model.Book;
import data.model.user.Librarian;
import data.repository.AccountRepo;

import java.sql.SQLException;

public class AccountService {
    AccountRepo accountRepo = new AccountRepo();
    LibrarianService librarianService = new LibrarianService();
    public void borrowBook(Account account, int bookID) throws SQLException {
        if(librarianService.acceptBorrowBook(bookID))
            accountRepo.borrowBook(account,bookID);
    }

    public void returnBook(Account account, int bookID) throws SQLException {
        if(librarianService.acceptReturnBook(bookID , account.getID() ) )
            accountRepo.returnBook(account,bookID);
    }
}
