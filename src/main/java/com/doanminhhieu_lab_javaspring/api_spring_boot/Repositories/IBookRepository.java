package com.doanminhhieu_lab_javaspring.api_spring_boot.Repositories;

import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {
    default List<Book> findAllBooks(Integer pageNo , Integer pageSize , String sortBy)
    {
        return findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortBy))).getContent()  ;
    }

}
