package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.annotation.ApplicationScope;

@NoArgsConstructor
@ApplicationScope
@Data
public class Employee {
    private String firstName;
    private String lastName;
}
