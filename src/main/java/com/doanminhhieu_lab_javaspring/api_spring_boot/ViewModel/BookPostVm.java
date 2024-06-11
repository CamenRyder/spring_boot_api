package com.doanminhhieu_lab_javaspring.api_spring_boot.ViewModel;

import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Book;
import org.antlr.v4.runtime.misc.NotNull;

public record BookPostVm (Long id,   String title, String author, Double price , Long categoryId) {
        public static BookPostVm from(@NotNull Book book) {
            return new BookPostVm(book.getId() ,   book.getTitle() , book.getAuthor(), book.getPrice() , book.getCategory().getId());
        }
}

