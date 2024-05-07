package com.project.ecommerce.repository;

import com.project.ecommerce.entities.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FAQRepository  extends JpaRepository<FAQ, Long> {

    List<FAQ> findAllByProductId(Long productsId);
}