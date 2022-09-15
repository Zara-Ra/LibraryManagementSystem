package data.model.user;

import data.enums.ClassType;
import data.model.Account;

public class Student extends User{
    private int sutdentNum;
    private ClassType classes;

    public Student(String name, String phonenumber, int sutdentNum, ClassType classes) {
        super(name, phonenumber);
        this.sutdentNum = sutdentNum;
        this.classes = classes;
    }

    public int getSutdentNum() {
        return sutdentNum;
    }

    public void setSutdentNum(int sutdentNum) {
        this.sutdentNum = sutdentNum;
    }

    public ClassType getClasses() {
        return classes;
    }

    public void setClasses(ClassType classes) {
        this.classes = classes;
    }
}
