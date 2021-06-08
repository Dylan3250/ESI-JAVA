package esi.atl.g54027.repository;

import esi.atl.g54027.repository.dto.StudentDto;
import java.util.List;

public class StudentRepository implements Repository<StudentDto> {
    private final StudentDao dao;
    
    private StudentRepository() {
        dao = new StudentDao();
    }

    public static StudentRepository getInstance() {
        return StudentRepositoryHolder.INSTANCE;
    }

    private static class StudentRepositoryHolder {

        private static final StudentRepository INSTANCE = new StudentRepository();
    }
    
    @Override
    public void add(StudentDto item) {
        boolean isExist = false;
        try {
            newUpdate(item);
            System.out.println("Element " + item.getMatricule() + " existe déjà");
        } catch (IllegalArgumentException e) {
            dao.insert(item);
        }
    }

    @Override
    public void remove(StudentDto item) {
        get(item);
        dao.delete(item);
    }

    @Override
    public StudentDto get(StudentDto item) {
        if (dao.get(item) == null) {
            throw new IllegalArgumentException("L'utilisateur n'existe pas");
        }
        return dao.get(item);
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentDto> students = dao.getAll();
        if (students.isEmpty()) {
            throw new IllegalArgumentException("Il n'y a aucun utilisateur");
        }
        return students;
    }

    @Override
    public boolean contains(StudentDto item) {
        List<StudentDto> list = dao.getAll();
        return list
                .parallelStream()
                .anyMatch(value -> value.getMatricule() == item.getMatricule());
    }

    public void newUpdate(StudentDto item) {
        if (contains(item)) {
            dao.update(item);
        } else {
            throw new IllegalArgumentException("L'utilisateur n'existe pas");
        }
    }
}
