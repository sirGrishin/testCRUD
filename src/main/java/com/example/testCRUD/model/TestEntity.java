package com.example.testCRUD.model;

import com.example.testCRUD.util.SortOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Ilya Grishin
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "test")
public class TestEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private UUID documentId;

    @Column
    private LocalDate documentDate;

    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    private Dictionary dictionary;

    @Enumerated(EnumType.STRING)
    @Column(name = "sort_order")
    private SortOrder sortOrder;

}


