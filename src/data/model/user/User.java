package data.model.user;

import data.model.Account;
import data.model.Book;

import java.util.List;

public abstract class User {
    private int ID;
    private String name;
    private String phonenumber;

    public User(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    private Account account;

    public User(String name, String phonenumber, Account account) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.account = account;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", account=" + account +
                '}';
    }

}
