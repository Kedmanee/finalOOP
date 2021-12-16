package model;
import java.util.*;

import com.mongodb.client.FindIterable;
import database.MongoDB;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import java.util.List;

public class Book {
    private int bookID;
    private String title;
    private String categories;
    private boolean status;
    private String writer;
    private double price;
    private int day;

    public Book(int bookID, String title, String categories, boolean status, String writer, double price, int day) {
        this.bookID = bookID;
        this.title = title;
        this.categories = categories;
        this.status = status;
        this.writer = writer;
        this.price = price;
        this.day = day;
    }
    public Book() {
        this.bookID = 0;
        this.title = "";
        this.categories = "";
        this.status = false;
        this.writer = "";
        this.price = 0;
        this.day = 0;
    }

    //insert book to database
    public void insertBook(){
        MongoDB mongoDB = new MongoDB();
        Document doc = new Document("bookID", this.bookID)
                .append("title", this.title)
                .append("categories", this.categories)
                .append("status", this.status)
                .append("writer", this.writer)
                .append("price", this.price)
                .append("day", this.day);
        mongoDB.getBookCollection().insertOne(doc);
    }

    //get book list from database
    public List<Book> getBookList(){
        List<Book> bookList = new LinkedList<Book>();
        MongoDB mongoDB = new MongoDB();
        List<Document> results = new ArrayList<>();
        FindIterable<Document> iterable = mongoDB.getBookCollection().find();
        iterable.into(results);
        for(Document iterate : iterable) {
            Book book = new Book(iterate.getInteger("bookID"),iterate.getString("title"),iterate.getString("categories"),iterate.getBoolean("status"),iterate.getString("writer"),iterate.getDouble("price"),iterate.getInteger("day"));
            bookList.add(book);
        }
        return bookList;
    }

    //delete book from database by id
     public void deleteBook(int bookid){
         MongoDB mongoDB = new MongoDB();
         Document doc = new Document("bookID", bookid);
         mongoDB.getBookCollection().deleteOne(doc);
     }

    //change the status of a rented book list
     public void rentBooks(List<Book> books){
         MongoDB mongoDB = new MongoDB();
         for(Book book:books){
             Document ID = new Document("bookID", book.bookID);
             Document rent = new Document("bookID", book.bookID)
                     .append("title", book.title)
                     .append("categories", book.categories)
                     .append("status", book.status)
                     .append("writer", book.writer)
                     .append("price", book.price)
                     .append("day", book.day);
             mongoDB.getBookCollection().replaceOne(ID, rent);
         }
     }

    //change the status of a return book by id
    public void returnBook(int id){
        MongoDB mongoDB = new MongoDB();
        Document ID = new Document("bookID", id);
        FindIterable<Document> iterable = mongoDB.getBookCollection().find(ID);
        for(Document iterate : iterable) {
            Book book = new Book(iterate.getInteger("bookID"),iterate.getString("title"),iterate.getString("categories"),iterate.getBoolean("status"),iterate.getString("writer"),iterate.getDouble("price"),iterate.getInteger("day"));
            Document returnbook = new Document("bookID", book.bookID)
                    .append("title", book.title)
                    .append("categories", book.categories)
                    .append("status", true)
                    .append("writer", book.writer)
                    .append("price", book.price)
                    .append("day", 0);
                mongoDB.getBookCollection().replaceOne(ID, returnbook);
        }
    }
    public void editBookDetail(){
        MongoDB mongoDB = new MongoDB();
        Document ID = new Document("bookID", this.bookID);
            Document editBook = new Document("bookID", this.bookID)
                    .append("title", this.title)
                    .append("categories", this.categories)
                    .append("status", true)
                    .append("writer", this.writer)
                    .append("price", this.price)
                    .append("day", this.day);
            mongoDB.getBookCollection().replaceOne(ID, editBook);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookID() { return bookID; }

    public void setBookID(int bookID) { this.bookID = bookID; }

    public int getDay() { return day; }

    public void setDay(int day) { this.day = day; }
}
