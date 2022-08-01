package com.example.testCRUD.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Ilya Grishin
 */
@Getter
@Setter
@Table(name = "dictionary")
@Entity
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "dictionary_generator")
    @SequenceGenerator(name = "dictionary_generator", sequenceName = "dictionary_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String name;
}
