package a4com.example.demo.dto;

import a4com.example.demo.entity.books;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonFilter("ProductFilter")
public class Products {
    private int bookId;
    private String name;
    private String author;
    private String publication;
    private String category;
    private int pages;
    private int price;
    private int regNo;
    private String authorNo;


    public Products(books message1) {
        this.bookId=message1.getBookId();
        this.name=message1.getName();
        this.author=message1.getAuthor();
        this.publication=message1.getPublication();
        this.category=message1.getCategory();
        this.pages=message1.getPages();
        this.price= message1.getPages();
        this.regNo=message1.getRegNo();
        this.authorNo=message1.getAuthorNo();

    }


}
