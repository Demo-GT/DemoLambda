package com.example.samplelambda.SampleLambda;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LambdaService {
    
    @Autowired
    LambdaRepository lambdaRepository;

    public String getAllBooks() {
        final String[] b = {new String()};
        lambdaRepository.findAll().forEach(B -> b[0] +=(B.toString()));
        return b[0].toString();
    }

    /*public String getAllBooks() {
        final String[] books = {" "};
        lambdaRepository.books.stream().forEach(b -> books[0] +=b.toString());
        return books[0];
    }

    public String getBookbyId( int id ) {
        List<Book> books = lambdaRepository.books.stream().filter(B -> B.getBookid()==id).collect(Collectors.toList());
        final String[] book = {" "};
        books.stream().forEach(b -> book[0] +=b.toString());
        return book[0];
    }

    public String saveBook(Book B) {
        if (lambdaRepository.books.stream().noneMatch(book -> book.getBookName().equalsIgnoreCase(B.getBookName()))) {
            return "Book is already in Stack";
        }
        lambdaRepository.books.add(B);
        return B.toString();
    }*/

}
