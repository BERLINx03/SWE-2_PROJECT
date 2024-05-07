package com.project.ecommerce.repository;

import com.project.ecommerce.entities.FAQ;
import com.project.ecommerce.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByProductId(Long productsId);
}
