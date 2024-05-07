package com.project.ecommerce.dto;

import com.project.ecommerce.entities.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
public class FAQDto {

    private Long id;

    private String question;

    private String answer;

    private Long productId;

}
