package com.um.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 200)
    @Size(min = 10, max = 200)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
