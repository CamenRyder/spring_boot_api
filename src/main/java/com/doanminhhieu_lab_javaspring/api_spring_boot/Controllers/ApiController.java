package com.doanminhhieu_lab_javaspring.api_spring_boot.Controllers;

import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Book;
import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Category;
import com.doanminhhieu_lab_javaspring.api_spring_boot.Service.BookService;
import com.doanminhhieu_lab_javaspring.api_spring_boot.Service.CategoryService;
import com.doanminhhieu_lab_javaspring.api_spring_boot.ViewModel.BookGetVm;
import com.doanminhhieu_lab_javaspring.api_spring_boot.ViewModel.BookPostVm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ApiController {
    private  final BookService bookService;
    private  final CategoryService categoryService;

    @GetMapping("/books/get-books")
    public ResponseEntity<List<BookGetVm>> getAllBooks(Integer pageNo,
                                                       Integer pageSize, String sortBy) {
        return ResponseEntity.ok(bookService.getAllBooks(
                pageNo == null ? 0 : pageNo,pageSize == null ? 20 : pageSize,
                        sortBy == null ? "id" : sortBy)
                .stream()
                .map(BookGetVm::from)
                .toList());
    }

    @GetMapping("/books/id")
    public ResponseEntity<BookGetVm> getBookById(@RequestParam("id") String id) {
                Long idConverted = Long.valueOf(id);
                return ResponseEntity.ok(bookService.getBookById(idConverted)
                        .map(BookGetVm::from)
                        .orElse(null));
    }


    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build() ;
    }

    @PostMapping("/books/create-book")
    public ResponseEntity<String> addBook(@RequestBody BookPostVm bookPostVm) {
        Optional<Category> categoryOptional = categoryService.getCategoryById(bookPostVm.categoryId());
        if (categoryOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Book book = new Book();
        book.setId(bookPostVm.id());
        book.setTitle(bookPostVm.title());
        book.setAuthor(bookPostVm.author());
        book.setPrice(bookPostVm.price());
        book.setCategory(categoryOptional.get());
        bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED).body("Book created");
    }

    @PutMapping("/books/update-book")
    public ResponseEntity<String> updateBook(@RequestBody BookPostVm bookPostVm) {
        Optional<Category> categoryOptional = categoryService.getCategoryById(bookPostVm.categoryId());
        if (categoryOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Book book = new Book();
        book.setId(bookPostVm.id());
        book.setTitle(bookPostVm.title());
        book.setAuthor(bookPostVm.author());
        book.setPrice(bookPostVm.price());
        book.setCategory(categoryOptional.get());
        bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED).body("Book created");
    }


}
