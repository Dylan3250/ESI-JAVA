package esi.atl.g54027.repository;

import esi.atl.g54027.repository.dto.Dto;
import esi.atl.g54027.repository.exception.RepositoryException;

import java.util.List;

public interface Dao<K, T extends Dto<K>> {

    void insert(T item) throws RepositoryException, IllegalArgumentException;

    void delete(K key) throws RepositoryException;

    void update(T item) throws RepositoryException, IllegalArgumentException;

    T get(K key) throws RepositoryException, IllegalArgumentException;

    List<T> getAll() throws RepositoryException;
}
