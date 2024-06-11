package com.doanminhhieu_lab_javaspring.api_spring_boot.ViewModel;

import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Book;
import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Category;
import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Builder
public record CategoryGetVm (long id , String name , List<Book> books){
    public static CategoryGetVm from(@NotNull Category category) {
        return CategoryGetVm.builder()
                .id(category.getId())
                .name(category.getName())
                .books(category.getBook())
                .build() ;


    }
}
