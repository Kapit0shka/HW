package app.controller;

import app.model.bookmodel.Book;
import app.model.bookmodel.BookNameCost;
import app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //ex.1
    @GetMapping("/find/all")
    public List<Book> findAll() {
        return bookService.findAllBooks();
    }

    //ex.1
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createdBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    //ex.1
    @GetMapping("/find")
    public ResponseEntity<Book> findById(@RequestParam int id){
        Book book = bookService.findById(id);
        return book != null? ResponseEntity.ok(book) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //ex.1
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable int id) {
        bookService.removeBookById(id);
    }

    //ex.1
    @PatchMapping("/patch/{id}")
    public void editBookById(@PathVariable int id, @RequestParam String name) {
        bookService.patchBookById(id,name);
    }

    //ex.1
    @PutMapping("/replace/{id}")
    public void replaceBookById(@PathVariable int id, @RequestBody Book book) {
        bookService.replaceBook(id, book);
    }


    //2.a
    @GetMapping("/find/all/nameCost")
    public List<BookNameCost> findAllNameCost() {
        return bookService.findAllBooksNameCost();
    }

    //3.c
    @GetMapping("/find/all/nameCostWithFilter")
    public List<BookNameCost> findAllNameCostWithFilter() {
        return bookService.findAllBooksNameCostWithFilter("Windows",20000);
    }
}
