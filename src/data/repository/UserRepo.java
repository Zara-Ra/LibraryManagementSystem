package data.repository;

import data.enums.ClassType;
import data.enums.DepatType;
import data.model.user.Staff;
import data.model.user.Student;
import data.model.user.User;
import utils.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo {
    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO users ( name,phone,account_id,personal_number,depart_type,class_type) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2,user.getPhonenumber());
        preparedStatement.setInt(3, user.getAccount().getID());
        if(user instanceof Staff){
            preparedStatement.setString(4,((Staff) user).getStaffNum());
            preparedStatement.setString(5,((Staff) user).getDept().toString());
            preparedStatement.setString(6,null);
        }
        else if(user instanceof Student){
            preparedStatement.setString(4,((Student) user).getSutdentNum());
            preparedStatement.setString(5,null);
            preparedStatement.setString(6,((Student) user).getClasses().toString());
        }

        return preparedStatement.executeUpdate()>0;
    }
    public User findUserByAccountID(int accountID) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM users WHERE account_id = ?";
        PreparedStatement preparedStatement = ApplicationConstant.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, accountID);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String phone = resultSet.getString(3);
            int account = resultSet.getInt(4);
            String personalno = resultSet.getString(5);
            String depttype = resultSet.getString(6);
            String clastype = resultSet.getString(7);
            if(depttype != null){
                user = new Staff(name,phone,personalno, DepatType.valueOf(depttype));
            }
            else if (clastype != null) {
                user = new Student(name,phone,personalno, ClassType.valueOf(clastype));
            }
        }
        return user;
    }
}
