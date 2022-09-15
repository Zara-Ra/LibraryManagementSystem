package data.model.user;

import data.enums.ClassType;
import data.model.Account;

public class Student extends User{
    private String sutdentNum;
    private ClassType classes;

    public Student(String name, String phonenumber, String sutdentNum, ClassType classes) {
        super(name, phonenumber);
        this.sutdentNum = sutdentNum;
        this.classes = classes;
    }

    public String getSutdentNum() {
        return sutdentNum;
    }

    public void setSutdentNum(String sutdentNum) {
        this.sutdentNum = sutdentNum;
    }

    public ClassType getClasses() {
        return classes;
    }

    public void setClasses(ClassType classes) {
        this.classes = classes;
    }
}
