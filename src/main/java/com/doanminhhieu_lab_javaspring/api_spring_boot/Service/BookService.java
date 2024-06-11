package com.doanminhhieu_lab_javaspring.api_spring_boot.Service;

import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Book;
import com.doanminhhieu_lab_javaspring.api_spring_boot.Repositories.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {
    private final IBookRepository bookRepository;
    public List<Book> getAllBooks(Integer pageNo , Integer pageSize , String sortBy) {

        return bookRepository.findAllBooks(pageNo,pageSize , sortBy );
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId())
                .orElse(null);
        Objects.requireNonNull(existingBook).setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setCategory(book.getCategory());
        bookRepository.save(existingBook);

    }




    public void updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).orElse(null) ;
        Objects.requireNonNull(existingBook).setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setCategory(book.getCategory());
        bookRepository.save(existingBook);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
