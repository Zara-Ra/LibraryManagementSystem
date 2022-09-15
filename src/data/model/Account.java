package data.model;

public class Account {
    private int ID;
    private String username;
    private String password;
    private int noBorrowed;
    private int noReserved;
    private int noLost;
    private int noReturned;
    private int fineAmount;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int ID, String username, String password, int noBorrowed, int noReserved, int noLost, int noReturned, int fineAmount) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.noBorrowed = noBorrowed;
        this.noReserved = noReserved;
        this.noLost = noLost;
        this.noReturned = noReturned;
        this.fineAmount = fineAmount;
    }

    public Account(String username, String password, int noBorrowed, int noReserved, int noLost, int noReturned, int fineAmount) {
        this.username = username;
        this.password = password;
        this.noBorrowed = noBorrowed;
        this.noReserved = noReserved;
        this.noLost = noLost;
        this.noReturned = noReturned;
        this.fineAmount = fineAmount;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNoBorrowed() {
        return noBorrowed;
    }

    public void setNoBorrowed(int noBorrowed) {
        this.noBorrowed = noBorrowed;
    }

    public int getNoReserved() {
        return noReserved;
    }

    public void setNoReserved(int noReserved) {
        this.noReserved = noReserved;
    }

    public int getNoLost() {
        return noLost;
    }

    public void setNoLost(int noLost) {
        this.noLost = noLost;
    }

    public int getNoReturned() {
        return noReturned;
    }

    public void setNoReturned(int noReturned) {
        this.noReturned = noReturned;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", noBorrowed=" + noBorrowed +
                ", noReserved=" + noReserved +
                ", noLost=" + noLost +
                ", noReturned=" + noReturned +
                ", fineAmount=" + fineAmount +
                '}';
    }
}
