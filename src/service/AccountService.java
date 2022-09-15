package service;

import data.model.Account;
import data.model.Book;
import data.model.user.Librarian;
import data.repository.AccountRepo;

import java.sql.SQLException;

public class AccountService {
    AccountRepo accountRepo = new AccountRepo();
    LibrarianService librarianService = new LibrarianService();
    public void borrowBook(Account account, Book book) throws SQLException {
        if(librarianService.acceptBorrowBook(book.getID()))
            accountRepo.borrowBook(account,book);
    }

    public void returnBook(Account account, Book book) throws SQLException {
        if(librarianService.acceptReturnBook(book.getID() , account.getID() ) )
            accountRepo.returnBook(account,book);
    }
}
