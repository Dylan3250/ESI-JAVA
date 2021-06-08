package esi.atl.g54027.repository;

import esi.atl.g54027.repository.dto.Dto;
import esi.atl.g54027.repository.exception.RepositoryException;

import java.util.List;

public interface Repository<K, T extends Dto<K>> {

    void add(T item) throws RepositoryException;

    void remove(K key) throws RepositoryException;

    T get(K key) throws RepositoryException;

    List<T> getAll() throws RepositoryException;

    boolean contains(K key) throws RepositoryException;
}
