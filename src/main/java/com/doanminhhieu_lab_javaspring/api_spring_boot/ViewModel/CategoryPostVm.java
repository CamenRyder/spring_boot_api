package com.doanminhhieu_lab_javaspring.api_spring_boot.ViewModel;

import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Book;
import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Category;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public record CategoryPostVm( Long id , String name , List<Book> BooksId  ) {
    public static CategoryPostVm from(@NotNull Category category) {
        return new CategoryPostVm(category.getId(), category.getName(), category.getBook());
    }
}
