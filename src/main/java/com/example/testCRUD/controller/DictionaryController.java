package com.example.testCRUD.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ilya Grishin
 */
@RestController
@RequestMapping(value = "/dictionary", produces = MediaType.APPLICATION_JSON_VALUE)
public class DictionaryController {
}
