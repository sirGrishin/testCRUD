package com.example.testCRUD.repo;

import com.example.testCRUD.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ilya Grishin
 */
@Repository
public interface DictionaryRepo extends JpaRepository<Dictionary, Long> {
}