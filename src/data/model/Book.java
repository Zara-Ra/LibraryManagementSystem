package data.model;


import java.sql.Date;

public class Book {
    private int ID;
    private String title;
    private String author;
    private String publication;
    private String ISBN;

    private boolean reservStatus;
    private Date dueDate;

    public Book(String title, String author, String publication, String ISBN) {
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.ISBN = ISBN;
    }

    public Book(String title, String author, String publication, String ISBN, Date dueDate) {
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.ISBN = ISBN;
        this.dueDate = dueDate;
    }

    public boolean isReservStatus() {
        return reservStatus;
    }

    public void setReservStatus(boolean reservStatus) {
        this.reservStatus = reservStatus;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", reservStatus=" + reservStatus +
                ", dueDate=" + dueDate +
                '}';
    }
}
