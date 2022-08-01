package com.example.testCRUD.service;

import com.example.testCRUD.exception.BadRequestException;
import com.example.testCRUD.model.TestEntity;
import com.example.testCRUD.repo.TestEntityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Ilya Grishin
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TestEntityService {

    private static final String ID_IS_NULL_ERROR = "Целевой идентификатор не задан";

    private final TestEntityRepo repository;

    public TestEntity create(TestEntity entity) {
        log.debug("[TestEntityService.create]");
        return repository.save(entity);
    }

    public TestEntity update(UUID id, TestEntity entity) {
        compareId(id, "TestEntity. ");
        get(id);
        return repository.save(entity);
    }

    public void delete(UUID id) {
        get(id);
        repository.deleteById(id);
    }

    public TestEntity get(UUID id) {
        Optional<TestEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new NoSuchElementException(String.format("Not found TestEntity with id = %s", id));
        }
        return optionalEntity.get();
    }

    public Page<TestEntity> getAll(Pageable page) {
        Page<TestEntity> entities = repository.findAll(page);
        return new PageImpl<>(entities.getContent(), page, entities.getTotalElements());
    }

    private void compareId(UUID id, String messagePrefix) {
        if (id == null) {
            throw new BadRequestException(ID_IS_NULL_ERROR);
        }
    }
}
