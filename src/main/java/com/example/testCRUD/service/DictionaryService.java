package com.example.testCRUD.service;

import com.example.testCRUD.exception.BadRequestException;
import com.example.testCRUD.model.Dictionary;
import com.example.testCRUD.repo.DictionaryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Ilya Grishin
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class DictionaryService {

    private static final String ID_IS_NULL_ERROR = "Целевой идентификатор не задан";

    private final DictionaryRepo repository;

    public Dictionary create(Dictionary entity) {
        log.debug("[DictionaryService.create]");
        return repository.save(entity);
    }

    public Dictionary update(Long id, Dictionary entity) {
        compareId(id, "Dictionary. ");
        get(id);
        return repository.save(entity);
    }

    public void delete(Long id) {
        get(id);
        repository.deleteById(id);
    }

    public Dictionary get(Long id) {
        Optional<Dictionary> optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new NoSuchElementException(String.format("Not found Dictionary with id = %s", id));
        }
        return optionalEntity.get();
    }

    public Page<Dictionary> getAll(Pageable page) {
        Page<Dictionary> entities = repository.findAll(page);
        return new PageImpl<>(entities.getContent(), page, entities.getTotalElements());
    }

    private void compareId(Long id, String messagePrefix) {
        if (id == null) {
            throw new BadRequestException(ID_IS_NULL_ERROR);
        }
    }
}
