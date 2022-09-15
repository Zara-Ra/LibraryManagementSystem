package data.model.user;

import data.enums.DepatType;
import data.model.Account;

public class Staff extends User{
    private int staffNum;
    private DepatType dept;

    public Staff(String name, String phonenumber, int staffNum, DepatType dept) {
        super(name, phonenumber);
        this.staffNum = staffNum;
        this.dept = dept;
    }

    public Staff(String name, String phonenumber, Account account) {
        super(name, phonenumber, account);
    }

    public int getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }

    public DepatType getDept() {
        return dept;
    }

    public void setDept(DepatType dept) {
        this.dept = dept;
    }
}
