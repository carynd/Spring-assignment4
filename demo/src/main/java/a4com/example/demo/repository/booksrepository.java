package a4com.example.demo.repository;

import a4com.example.demo.entity.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface booksrepository extends JpaRepository<books,Integer> {


}
