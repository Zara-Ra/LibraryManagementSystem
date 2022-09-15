package data.repository;

import data.model.Account;
import data.model.Book;
import utils.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepo {
    public Account login(String username, String password) throws SQLException {
        Account account = null;
        String sql = "SELECT * From account WHERE username = ? AND password = ? ";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            String user = resultSet.getString(2);
            String pass = resultSet.getString(3);
            int noBorrowed = resultSet.getInt(4);
            int noReserved = resultSet.getInt(5);
            int noLost = resultSet.getInt(6);
            int noReturned = resultSet.getInt(7);
            int fine = resultSet.getInt(8);
            account = new Account(id,user,pass,noBorrowed,noReserved,noLost,noReturned,fine);
        }
        return account;
    }
    public boolean addAccount(Account account) throws SQLException {
        String sql = "INSERT INTO account(username,password,borrowed,reserved,lost,returned,fine) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, account.getUsername());
        preparedStatement.setString(2, account.getPassword());
        preparedStatement.setInt(3,account.getNoBorrowed());
        preparedStatement.setInt(4,account.getNoReserved());
        preparedStatement.setInt(5,account.getNoLost());
        preparedStatement.setInt(6,account.getNoReturned());
        preparedStatement.setInt(7,account.getFineAmount());

        return preparedStatement.executeUpdate() > 0;
    }
    public int findAccountID(Account account) throws SQLException {
        int result = 0;
        String sql = "SELECT id FROM account WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, account.getUsername());
        preparedStatement.setString(2, account.getPassword());

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            result = resultSet.getInt(1);
        return result;
    }

    public void borrowBook(Account account, int bookID) throws SQLException {
        String sql = "UPDATE account SET borrowed = (SELECT borrowed FROM account WHERE id = ?) +1 WHERE id = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,account.getID());
        preparedStatement.setInt(2,account.getID());
        preparedStatement.executeUpdate();

        String query = "INSERT INTO account_book(account_id,book_id) VALUES (?,?)";
        PreparedStatement preparedStatement2 = ApplicationConstant.getConnection().prepareStatement(query);
        preparedStatement2.setInt(1,account.getID());
        preparedStatement2.setInt(2,bookID);
        preparedStatement2.executeUpdate();

    }

    public void returnBook(Account account, int bookID) throws SQLException {
        String sql = "UPDATE account SET returned = (SELECT returned FROM account WHERE id = ?) +1 WHERE id = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,account.getID());
        preparedStatement.setInt(2,account.getID());
        preparedStatement.executeUpdate();

        String query = "DELETE FROM account_book WHERE account_id = ? AND book_id = ?";
        PreparedStatement preparedStatement2 = ApplicationConstant.getConnection().prepareStatement(query);
        preparedStatement2.setInt(1,account.getID());
        preparedStatement2.setInt(2,bookID);
        preparedStatement2.executeUpdate();
    }

    public void lostBook(Account account) throws SQLException {
        String sql = "UPDATE account SET lost = (SELECT returned FROM account WHERE id = ?) +1 WHERE id = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,account.getID());
        preparedStatement.setInt(2,account.getID());
        preparedStatement.executeUpdate();
    }
}
