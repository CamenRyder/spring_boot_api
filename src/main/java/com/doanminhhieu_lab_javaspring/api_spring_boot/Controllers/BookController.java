package com.doanminhhieu_lab_javaspring.api_spring_boot.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    @GetMapping
    public String getAllBooks() {
        return "Books/List";
    }
}
