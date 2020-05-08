package app.service;

import app.model.bookmodel.Book;
import app.model.bookmodel.BookNameCost;
import app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void removeBookById(int id) {
        bookRepository.deleteById(id);
    }

    public void patchBookById(int id,String name ) {
        Book book = bookRepository.getOne(id);
        book.setName(name);
        bookRepository.save(book);
    }

    public void replaceBook(int id, Book book) {
        book.setId(id);
        bookRepository.save(book);
    }

    //ex2.a
    public List<BookNameCost> findAllBooksNameCost(){ return bookRepository.findAllBookNameCost(); }

    //ex3.c
    public List<BookNameCost> findAllBooksNameCostWithFilter(String name, double cost) {
        return bookRepository.findAllBookNameAndCostWithFilter(name,cost);
    }
}
