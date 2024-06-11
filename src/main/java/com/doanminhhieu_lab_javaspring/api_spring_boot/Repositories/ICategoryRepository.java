package com.doanminhhieu_lab_javaspring.api_spring_boot.Repositories;

import com.doanminhhieu_lab_javaspring.api_spring_boot.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
