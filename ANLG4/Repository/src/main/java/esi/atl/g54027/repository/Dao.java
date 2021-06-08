package esi.atl.g54027.repository;

import java.util.List;

public interface Dao<T> {

    public void insert(T item);

    public void delete(T item);

    public void update(T item);

    public T get(T item);

    public List<T> getAll();
}
