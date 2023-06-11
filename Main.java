package UAS;

import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {    

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void cls(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void welcome(){
        cls();
        System.out.println("===============================");
        System.out.println("|           LIBRARY           |");
        System.out.println("===============================");
        System.out.println("| 1. Login                    |");
        System.out.println("| 2. Register Account         |");
        System.out.println("===============================");
    }

    public static void retry(){
        Scanner sc = new Scanner(System.in);
            System.out.print("\nInvalid option, please press enter to retry!");
            sc.nextLine();
    }

    public static void login(){
        while(true){
        cls();
        DBConnector.initDBConnection();
        Scanner sc = new Scanner(System.in);
        String username,password,user_type;
        System.out.println("===============================");
        System.out.println("|           LOGIN             |");
        System.out.println("===============================");
        System.out.print("Username : ");
        username = sc.nextLine();
        System.out.print("Password : ");
        password = sc.nextLine();
        System.out.println("===============================");
        try {
            Statement st = DBConnector.connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'");
            if(rs.next()){
                user_type=rs.getString("user_type");
                System.out.println("Welcome "+username);
                System.out.println("\npress enter to continue...");
                sc.nextLine();
                if(user_type.equals("Admin")){
                    AdminInterface();
                }else if(user_type.equals("User")){
                    UserInterface();
                }
            }
            retry();
        } catch (Exception ex) {
            System.out.println(ex);
        }}
    }

    public static void register(){
        cls();
        DBConnector.initDBConnection();
        Scanner sc = new Scanner(System.in);
        String username,password,user_type;
        System.out.println("===============================");
        System.out.println("|           REGISTER          |");
        System.out.println("===============================");
        System.out.print("Username : ");
        username = sc.nextLine();
        System.out.print("Password : ");
        password = sc.nextLine();
        user_type="User";
        System.out.println("===============================");
        try {
            Statement st = DBConnector.connection.createStatement();
            String query = "INSERT INTO users (username, password,user_type) VALUES ('" + username + "','" + password + "','" + user_type + "')";
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
            System.out.println("Successfully registered your account, welcome " + username);
            System.out.println("\nPress enter to continue...");
            sc.nextLine();
            if(user_type.equals("Admin")){
                AdminInterface();
            }else if(user_type.equals("User")){
                UserInterface();
            }
        }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static void AdminInterface(){
        int option;
        Scanner sc = new Scanner(System.in);
        while(true){
        cls();
        System.out.println("===============================");
        System.out.println("|  LIBRARY (ADMIN INTERRFACE) |");
        System.out.println("===============================");
        System.out.println("| 1. List of Books            |");
        System.out.println("| 2. Upload a Book            |");
        System.out.println("| 3. Exit                     |");
        System.out.println("===============================");
        System.out.print("Please enter your option : ");
        option = sc.nextInt();
        if(option==1){
            ListofBooks(option);
        }
        else if(option==2){
            UploadBooks();
        }
        else if(option==3){
            cls();
            System.out.println("===============================");
            System.out.println("|       HAVE A NICE DAY       |");
            System.out.println("===============================");
            System.exit(0);
        }
        else{
            retry();
        }
        }
    }

    public static void UserInterface(){
        int option;
        Scanner sc = new Scanner(System.in);
        while(true){
            cls();
            System.out.println("===============================");
            System.out.println("|           LIBRARY           |");
            System.out.println("===============================");
            System.out.println("| 1. List of All Books        |");
            System.out.println("| 2. Fiction   Books          |");
            System.out.println("| 3. Non-Fiction Books        |");
            System.out.println("| 4. Exit                     |");
            System.out.println("===============================");
            System.out.print("Please enter your option : ");
            option = sc.nextInt();
            if(option==1){
                ListofBooks(option);
            }
            else if(option==2){
               ListofBooks(option);
            }
            else if(option==3){
                ListofBooks(option);
            }
            else if(option==4){
                cls();
                System.out.println("===============================");
                System.out.println("|       HAVE A NICE DAY       |");
                System.out.println("===============================");
                System.exit(0);
            }
            else{
                retry();
            }
            }
    }

    public static void ListofBooks(int option){
        cls();
        DBConnector.initDBConnection();
        Scanner sc = new Scanner(System.in);
        if(option==1){
            try {
                Statement st = DBConnector.connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM books");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("Title");
                    String author = rs.getString("Author");
                    String publisher = rs.getString("Publisher");
                    int year = rs.getInt("YearPublished");
                    String type = rs.getString("Type");
                    String genre = rs.getString("Genre");
                    String topic = rs.getString("Topic");
                    System.out.println(ANSI_YELLOW+ title+ ANSI_RESET+ " (id : " + ANSI_GREEN + id + ANSI_RESET + ")");
                    System.out.print("by " + author + "\nPublished by " + publisher + "\nYear published: " + year + "\n" + type+ "\nGenre: " + genre + "\nTopic: " + topic+"\n\n");
                }
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
        }else if (option==2){
            try {
                Statement st = DBConnector.connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM books WHERE Type='Fiction'");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("Title");
                    String author = rs.getString("Author");
                    String publisher = rs.getString("Publisher");
                    int year = rs.getInt("YearPublished");
                    String type = rs.getString("Type");
                    String genre = rs.getString("Genre");
                    String topic = rs.getString("Topic");
                    System.out.println(ANSI_YELLOW+ title+ ANSI_RESET+ " (id : " + ANSI_GREEN + id + ANSI_RESET + ")");
                    System.out.print("by " + author + "\nPublished by " + publisher + "\nYear published: " + year + "\n" + type + "\nGenre: " + genre + "\n\n");
                }
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
        }else if (option==3){
            try {
                Statement st = DBConnector.connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM books WHERE Type='Non-fiction'");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("Title");
                    String author = rs.getString("Author");
                    String publisher = rs.getString("Publisher");
                    int year = rs.getInt("YearPublished");
                    String type = rs.getString("Type");
                    String topic = rs.getString("Topic");
                    System.out.println(ANSI_YELLOW+ title+ ANSI_RESET+ " (id : " + ANSI_GREEN + id + ANSI_RESET + ")");
                    System.out.print("by " + author + "\nPublished by " +publisher+ "\nYear published: " + year + "\n" +type+ "\nTopic: " + topic+ "\n\n");
                }
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
        System.out.println("press enter to return home...");
        sc.nextLine();
    }

    public static void UploadBooks(){
    ArrayList<Book> books = new ArrayList<Book>();
    Scanner sc = new Scanner(System.in);
    cls();
    System.out.println("===============================");
    System.out.println("| 1. Fiction Books            |");
    System.out.println("| 2. Non-Fiction Books        |");
    System.out.println("===============================");
    System.out.print("Please enter your option : ");
    int option = sc.nextInt();
    sc.nextLine(); // Consume the remaining newline character

    if (option == 1) {
        cls();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Publisher: ");
        String publisher = sc.nextLine();
        System.out.print("Year: ");
        int year = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline character
        String type = "Fiction";
        System.out.print("Genre: ");
        String genre = sc.nextLine();
        DBConnector.initDBConnection();
        try {
            Statement st = DBConnector.connection.createStatement();
            String query = "INSERT INTO books (Title, Author, Publisher, YearPublished, Type, Genre) VALUES ('" + title + "','" + author + "','" + publisher + "','" + year + "','" + type + "','" + genre + "')";
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Successfully added the book");}
        } catch (SQLException ex) {
            System.out.println("Error executing SQL query: " + ex.getMessage());
        }
        }
        else if(option==2){
            cls();
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Publisher: ");
            String publisher = sc.nextLine();
            System.out.print("Year: ");
            int year = sc.nextInt();
            sc.nextLine(); // Consume the remaining newline character
            String type = "Non-fiction";
            System.out.print("Topic: ");
            String topic = sc.nextLine();

            DBConnector.initDBConnection();
            try{
                Statement st = DBConnector.connection.createStatement();
                String query = "INSERT INTO books (Title, Author, Publisher, YearPublished, Type, Topic) VALUES ('" + title + "','" + author + "','" + publisher + "','" + year + "','" + type + "','" + topic + "')";
                int rowsAffected = st.executeUpdate(query);
                if (rowsAffected > 0) {
                    System.out.println("Successfully added the book");}
            } catch (SQLException ex) {
                System.out.println("Error executing SQL query: " + ex.getMessage());
            }
            }
    }

        
    public static void main(String[] args) {
        cls();
        int option;
        Scanner sc = new Scanner(System.in);
        do{
            welcome();
            System.out.print("Please enter your option : ");
            option = sc.nextInt();
            if(option==1){
                login();
            }
            else if(option==2){
                register();
            }
            else{
                retry();
            }
        }while(option!=1&&option!=2);
        
    }
}
