package esi.atl.g54027.repository;

import esi.atl.g54027.repository.dto.StudentDto;
import esi.atl.g54027.repository.exception.RepositoryException;

import java.util.List;
import java.util.Objects;

public class StudentRepository implements Repository<Integer, StudentDto> {

    private final StudentDao dao;

    private StudentRepository() {
        dao = new StudentDao();
    }

    public StudentRepository(StudentDao dao) {
        this.dao = dao;
    }

    public static StudentRepository getInstance() {
        return StudentRepositoryHolder.INSTANCE;
    }

    private static class StudentRepositoryHolder {

        private static final StudentRepository INSTANCE = new StudentRepository();
    }

    @Override
    public void add(StudentDto item) throws RepositoryException {
        if (contains(item.getKey())) {
            dao.update(item);
        } else {
            dao.insert(item);
        }
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
        if (contains(key)) {
            dao.delete(key);
        }
    }

    @Override
    public StudentDto get(Integer key) throws RepositoryException {
        return dao.get(key);
    }

    @Override
    public List<StudentDto> getAll() throws RepositoryException {
        return dao.getAll();
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        List<StudentDto> list = dao.getAll();
        return list
                .parallelStream()
                .anyMatch(value -> Objects.equals(value.getKey(), key));
    }
}
