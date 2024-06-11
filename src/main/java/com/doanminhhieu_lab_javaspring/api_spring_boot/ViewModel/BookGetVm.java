package com.doanminhhieu_lab_javaspring.api_spring_boot.ViewModel;

import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Book;
import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;


@Builder
public record BookGetVm (Long id, String title , String author , Double price , String category ) {
    public static BookGetVm from(@NotNull Book book) {
        return BookGetVm.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .category(book.getCategory().getName())
                .build() ;
    }
}
