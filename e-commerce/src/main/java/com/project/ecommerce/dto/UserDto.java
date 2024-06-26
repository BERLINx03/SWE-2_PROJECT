package com.project.ecommerce.dto;

import com.project.ecommerce.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String email;
    private String name;
    private UserRole userRole;
}
