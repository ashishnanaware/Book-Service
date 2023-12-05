package com.mastek.bookservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter@Setter@AllArgsConstructor@RequiredArgsConstructor@ToString@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private String ISBN;
    private LocalDate publishedDate;
    private String genre;

}
