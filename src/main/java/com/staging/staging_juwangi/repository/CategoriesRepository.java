package com.staging.staging_juwangi.repository;

import com.staging.staging_juwangi.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository <Categories, Long>{
}
