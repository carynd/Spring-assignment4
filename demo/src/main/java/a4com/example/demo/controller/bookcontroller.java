package a4com.example.demo.controller;

import a4com.example.demo.entity.books;
import a4com.example.demo.service.booksservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookcontroller {

    @Autowired
    booksservice Booksservice;

    @GetMapping("/bookservice/books")
    public List<books> getallbooks(){

        List<books> bookinfo=Booksservice.getallbooks();
        return bookinfo;
    }



        @PostMapping("/bookservice/books")
        public books addbook(@RequestBody books book){
            books book1=Booksservice.addbook(book);
            return book1;
    }



    @PutMapping("/bookservice/books")
    public String updatebook(@RequestBody books book){
      String book1=Booksservice.updatebook(book);
        return book1;
    }




    @DeleteMapping("/bookservice/books/{id}")
    public String deletebook(@PathVariable("id") int bookid){
        String message=Booksservice.deletebook(bookid);
        return message;

    }
    @GetMapping("/bookservice/books/{id}")
    public books getbyid(@PathVariable("id") int bookid){
        books message1=Booksservice.getbyid(bookid);
        return message1;

    }
}
