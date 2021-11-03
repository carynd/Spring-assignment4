package a4com.example.demo.service;


import a4com.example.demo.Exceptions.BookNotFound;
import a4com.example.demo.entity.books;
import a4com.example.demo.repository.booksrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class booksservice {

    @Autowired
    booksrepository BooksRepository;//inject BooksRepository, in repository name booksrepository.
    public List<books> getallbooks(){
        List<books> booksinfo=BooksRepository.findAll();
        return booksinfo;
    }

    public books addbook(books book){
        books book1=BooksRepository.save(book);
        return book1;

    }

    public String updatebook(books book) {
        Optional<books> book1=BooksRepository.findById(book.getBookId());
        if(book1.isEmpty()) { throw new BookNotFound("Error");}


        //can use module wrapper also
        book1.get().setBookId(book.getBookId());
        book1.get().setName(book.getName());
        book1.get().setAuthor(book.getAuthor());
        book1.get().setPublication(book.getPublication());
        book1.get().setCategory(book.getCategory());
        book1.get().setPages(book.getPages());
        book1.get().setPrice(book.getPrice());

        BooksRepository.save(book1.get());
        return  "Information updated";


    }




    public String deletebook(int bookid) {
        books b1=BooksRepository.findById(bookid).get();

        try{
            BooksRepository.delete(b1);
            return "deleted";
        }
        catch (Exception ex){
            throw new BookNotFound("Error");
        }
    }

    public books getbyid(int bookid) {

        Optional<books> b1 = BooksRepository.findById(bookid);
        if (b1.isEmpty()) {
            throw new BookNotFound("Error");
        }

        return b1.get();

    }


}
