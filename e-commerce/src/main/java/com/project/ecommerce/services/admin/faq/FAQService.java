package com.project.ecommerce.services.admin.faq;

import com.project.ecommerce.dto.FAQDto;

public interface FAQService {
    FAQDto postFAQ(Long productId, FAQDto faqDto);
}
