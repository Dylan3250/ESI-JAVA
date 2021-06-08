package esi.atl.g54027.repository;

import java.util.List;

public interface Repository<T> {

    public void add(T item);

    public void remove(T item);

    public T get(T item);

    public List<T> getAll();

    public boolean contains(T item);
}
