package a4com.example.demo.controller;

import a4com.example.demo.dto.Products;
import a4com.example.demo.entity.books;
import a4com.example.demo.service.booksservice;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class author {
    @Autowired
    booksservice Booksservice;

    @GetMapping("/bookservice/books/author")
    public MappingJacksonValue getallbooks(){

        List<books> bookinfo=Booksservice.getallbooks();
        List<Products> products=new ArrayList<>();
        for (int i = 0; i < bookinfo.size(); i++) {
            Products product= new Products(bookinfo.get(i));
            products.add(product);
            // Booksservice.addbook(bookinfo.get(i));
        }
        //"bookId","name","author","publication","category","pages","price","regNo","authorNo"
       SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("bookId","name","author","publication","category","pages","price","regNo","authorNo");

        FilterProvider filters=new SimpleFilterProvider().addFilter("ProductFilter",filter);


        MappingJacksonValue mapping=new MappingJacksonValue(products);
        mapping.setFilters(filters);

        return mapping;

    }



    @PostMapping("/bookservice/books/author")
    public MappingJacksonValue addbook(@RequestBody books book){
        books book1=Booksservice.addbook(book);
        Products product= new Products(book1);
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("bookId","name","author","publication","category","pages","price","regNo","authorNo");

        FilterProvider filters=new SimpleFilterProvider().addFilter("ProductFilter",filter);


        MappingJacksonValue mapping=new MappingJacksonValue(product);
        mapping.setFilters(filters);

        return mapping;

    }



    @PutMapping("/bookservice/books/author")
    public MappingJacksonValue updatebook(@RequestBody books book){
      String book1=Booksservice.updatebook(book);
         MappingJacksonValue mapping=new MappingJacksonValue(book1);

        return mapping;

    }




    @DeleteMapping("/bookservice/books/author/{id}")
    public  MappingJacksonValue deletebook(@PathVariable("id") int bookid){
        String message=Booksservice.deletebook(bookid);

        MappingJacksonValue mapping=new MappingJacksonValue(message);
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("bookId","name","author","publication","category","pages","price","regNo","authorNo");

        FilterProvider filters=new SimpleFilterProvider().addFilter("ProductFilter",filter);

        return mapping;

    }
    @GetMapping("/bookservice/books/author/{id}")
    public MappingJacksonValue  getbyid(@PathVariable("id") int bookid){
        books message1=Booksservice.getbyid(bookid);
        Products product= new Products(message1);
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("bookId","name","author","publication","category","pages","price","regNo","authorNo");

        FilterProvider filters=new SimpleFilterProvider().addFilter("ProductFilter",filter);


        MappingJacksonValue mapping=new MappingJacksonValue(product);
        mapping.setFilters(filters);

        return mapping;


    }
}
