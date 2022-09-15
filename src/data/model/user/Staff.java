package data.model.user;

import data.enums.DepatType;
import data.model.Account;

public class Staff extends User{
    private String  staffNum;
    private DepatType dept;

    public Staff(String name, String phonenumber, String staffNum, DepatType dept) {
        super(name, phonenumber);
        this.staffNum = staffNum;
        this.dept = dept;
    }

    public Staff(String name, String phonenumber, Account account) {
        super(name, phonenumber, account);
    }

    public String getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(String staffNum) {
        this.staffNum = staffNum;
    }

    public DepatType getDept() {
        return dept;
    }

    public void setDept(DepatType dept) {
        this.dept = dept;
    }
}
