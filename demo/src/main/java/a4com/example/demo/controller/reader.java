package a4com.example.demo.controller;

import a4com.example.demo.dto.Products;
import a4com.example.demo.entity.books;
import a4com.example.demo.service.booksservice;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class reader {
    @Autowired
    booksservice Booksservice;
    /*
regNo;
    private String authorNo;
     */

    @GetMapping("/bookservice/books/reader/{id}")
    public MappingJacksonValue getprodcutsreader(@PathVariable("id") int bookid){


        books message1=Booksservice.getbyid(bookid);
        //return message1;

        Products product= new Products(message1);
/*
  private int bookId;
    private String name;
    private String author;
    private String publication;
    private String category;
    private int pages;
    private int price;
    private int regNo;
    private String authorNo;
 */
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("name","author","publication","category","pages","price");

        FilterProvider filters=new SimpleFilterProvider().addFilter("ProductFilter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(product);

        mapping.setFilters(filters);

        return mapping;
        //return new Products(101,"C++","Nitesh","Rajput Publication","Computer Programming",1500,250,5120,"ga121");
    }
    @GetMapping("/bookservice/books/reader")
    public MappingJacksonValue getallprodcutsreader() {

        List<books> bookinfo = Booksservice.getallbooks();
        List<Products> products=new ArrayList<>();
        for (int i = 0; i < bookinfo.size(); i++) {
            Products product= new Products(bookinfo.get(i));
            products.add(product);
           // Booksservice.addbook(bookinfo.get(i));
        }
        //return message1;
        //   List<Products> product=new List<Products>;
        //   product.add(bookinfo);



        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("name","author","publication","category","pages","price");

        FilterProvider filters=new SimpleFilterProvider().addFilter("ProductFilter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(products);
         mapping.setFilters(filters);

        return mapping;


       // return mapping;
        //return new Products(101,"C++","Nitesh","Rajput Publication","Computer Programming",1500,250,5120,"ga121");
    }

}
