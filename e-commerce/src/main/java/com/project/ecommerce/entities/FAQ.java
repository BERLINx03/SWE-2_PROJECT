package com.project.ecommerce.entities;

import com.project.ecommerce.dto.FAQDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String question;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    //converting the entity into faq dto
    public FAQDto getFAQDto(){
        FAQDto faqDto = new FAQDto();
        faqDto.setId(id);
        faqDto.setQuestion(question);
        faqDto.setAnswer(answer);
        faqDto.setProductId(product.getId());

        return faqDto;
    }
}
