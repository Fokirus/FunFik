package com.example.kursovoyProject.entity;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    private Long bookId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Column
    private String urlBook;

    @Column
    private String fileNameBook;
}
