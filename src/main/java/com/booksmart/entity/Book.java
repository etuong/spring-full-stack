package com.booksmart.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private long isbn;
    private String publisher;
    private double listPrice;
    private double ourPrice;
    @Column(columnDefinition="text")
    private String description;
}
