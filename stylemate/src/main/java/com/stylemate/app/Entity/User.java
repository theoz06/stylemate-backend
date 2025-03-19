package com.stylemate.app.Entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
