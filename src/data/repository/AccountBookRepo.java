package data.repository;

import utils.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountBookRepo {
    public boolean acceptBookBorrow(int bookID) throws SQLException {
        boolean result = false;
        String sql = "SELECT account_id FROM account_book WHERE book_id = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,bookID);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(!resultSet.next()){
            result = true;
        }
        return result;
    }

    public boolean acceptRetrunBook(int bookID, int userID) throws SQLException {
        boolean result = false;
        String sql = "SELECT account_id FROM account_book WHERE book_id = ? AND account_id = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,bookID);
        preparedStatement.setInt(2,userID);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            result = true;
        }
        return result;

    }
}
