package a4com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class books {

    @Id
    private int bookId;
    private String name;
    private String author;
    private String publication;
    private String category;
    private int pages;
    private int price;
    private int regNo;
    private String authorNo;


    //for entity to bind we use this constructor
    public books(){

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getAuthorNo() {
        return authorNo;
    }

    public void setAuthorNo(String authorNo) {
        this.authorNo = authorNo;
    }

    @Override
    public String toString() {
        return "books{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", category='" + category + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", regNo=" + regNo +
                ", authorNo='" + authorNo + '\'' +
                '}';
    }
}



