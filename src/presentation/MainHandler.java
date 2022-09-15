package presentation;

import data.enums.ClassType;
import data.enums.DepatType;
import data.enums.UserType;
import data.model.Account;
import data.model.Book;
import data.model.user.Staff;
import data.model.user.Student;
import data.model.user.User;
import service.BookService;
import service.LibrarianService;
import service.UserService;
import utils.ApplicationConstant;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class MainHandler {
    private UserService userService = new UserService();
    private LibrarianService librarianService = new LibrarianService();
    private BookService bookService = new BookService();

    private User user;
    public Scanner scanner = ApplicationConstant.getScanner();

    /*public void FirstMenu() throws SQLException {
        Account account = new Account("Zari", "Zari", 0, 0, 0, 0, 0);
        User user = new Student("Zahra", "0912", account, 12345, ClassType.MASTER);

        userService.register(account,user);
        Account login = userService.login("Zari", "Zari");
        User user = userService.findUserByAccountID(login.getID());
        user.setAccount(login);
        System.out.println(user);
        System.out.println(login);
        Book book = new Book("Cinderella", "James", "Star", "N121323242");
        bookService.addBook(book);
        System.out.println(bookService.searchBook("Cinderella"));
        bookService.deleteBook(book);
        userService.borrowBook(user,book);
        userService.returnBook(user,book);
        if(librarianService.isBookLost(user,book))
            System.out.println(user.getName()+" has lost a book!");

    }*/
    public void firstMenu() throws SQLException {
        System.out.println("Press 1 --> Register as a new user");
        System.out.println("Press 2 --> Log in");
        System.out.println("Press 3 --> Log out");
        System.out.println("Press 4 --> Sign in as Librarian");
        System.out.println("Press 5 --> Exit");
        int nextStep = Integer.parseInt(scanner.nextLine());
        switch (nextStep){
            case 1:
                System.out.println("Press 1 --> Register as Student");
                System.out.println("Press 2 --> Register as Staff");
                int usertype = Integer.parseInt(scanner.nextLine());
                if(registerUser(UserType.values()[usertype])){
                    System.out.println("New User Registered Successfully!");
                    userMenu();
                }
                else{
                    System.out.println("Unable to Register New User...");
                    firstMenu();
                }
                break;
            case 2:
                if(loginUser()) {
                    System.out.println("User Log in Successful");
                    userMenu();
                }
                else {
                    System.out.println("Unable to Log in");
                    firstMenu();
                }
                break;
            case 3:
                if(logOutUser()){
                    System.out.println("User Log out Successful");
                    firstMenu();
                }
                break;
            case 4:
                librarianMenu();
                break;
            default:
                exit(0);
        }

    }
    public void userMenu() throws SQLException {
        System.out.println("Press 1 --> Borrow Book");
        System.out.println("Press 2 --> Return Book");
        System.out.println("Press 3 --> Previous Menu");
        int nextStep = Integer.parseInt(scanner.nextLine());
        switch (nextStep) {
            case 1:
                showAllBookInfo();
                borrowBook();
                userMenu();
                break;
            case 2:
                returnBook();
                userMenu();
                break;
            case 3:
                firstMenu();
                break;
        }

        }
    public void librarianMenu(){
        System.out.println("Press 1 --> Add Book to Library");
        System.out.println("Press 2 --> Delete a Book from Library");
        System.out.println("Press 3 --> Mark a Book as Lost");
        int nextStep = Integer.parseInt(scanner.nextLine());
        switch (nextStep) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
    public boolean registerUser(UserType userType) throws SQLException {

        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        Account account = new Account(username,password);

        System.out.println("Enter Full name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNo = scanner.nextLine();

        if(userType == UserType.STUDENT){
            System.out.println("Enter Student Number: ");
            String studeneno = scanner.nextLine();
            System.out.println("Enter Class type:(BACHLOR,MASTER,DOCTORIAN" );
            ClassType classType = ClassType.valueOf(scanner.nextLine());
            user = new Student(name,phoneNo,studeneno,classType);
        }
        else if(userType == UserType.STAFF){
            System.out.println("Enter Staff Number: ");
            String staffno = scanner.nextLine();
            System.out.println("Enter Department:(CULTURAL,PUBLIC,IT,HR ,STATE) " );
            DepatType deptType = DepatType.valueOf(scanner.nextLine());
            user = new Staff(name,phoneNo,staffno,deptType);
        }
        user.setAccount(account);
        return userService.register(account,user);
    }
    public boolean loginUser() throws SQLException{
        boolean result = false;
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        Account account = userService.login(username,password);
        if(account != null) {
            user = userService.findUserByAccountID(account.getID());
            user.setAccount(account);
            result = true;
        }
        return result;
    }
    public boolean logOutUser() {
        return userService.logout(user);
    }
    public void returnBook() throws SQLException {
        System.out.println("Enter the Book Title to Return: ");
        String bookTitle = scanner.nextLine();
        userService.returnBook(user,bookTitle);
        System.out.println("Booked Returned to Library!");
    }
    public void showAllBookInfo() throws SQLException {
        System.out.println("All the Books Availabe in the Library: ");
        List<Book> bookList = userService.showAllBooks();
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }
    }
    public void borrowBook() throws SQLException {
        System.out.println("Enter the Book Title to Borrow: ");
        String bookTitle = scanner.nextLine();
        userService.borrowBook(user,bookTitle);
        System.out.println("Book Borrowed!");
    }
}
