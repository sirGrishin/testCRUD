package com.example.testCRUD.repo;

import com.example.testCRUD.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Ilya Grishin
 */
@Repository
public interface TestEntityRepo extends JpaRepository<TestEntity, UUID> {
}
