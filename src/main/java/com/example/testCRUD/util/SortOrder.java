package com.example.testCRUD.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Ilya Grishin
 */
@RequiredArgsConstructor
@Getter
public enum SortOrder {

    ASC(0L, "По натуральному порядку"),
    DESC(1L,"В обратном порядке");

    private final Long id;
    private final String name;
}
