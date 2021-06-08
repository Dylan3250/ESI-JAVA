package esi.atl.g54027.repository;

import esi.atl.g54027.repository.dto.StudentDto;
import esi.atl.g54027.repository.exception.RepositoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDao implements Dao<Integer, StudentDto> {
    // Pour écrire à une position précise, il est plus performant d'utiliser
    // des buffers et d'écrire à cet endroit, mais ici le but est de comprendre
    // le principe de Repository

    private Path path;

    public StudentDao() {
        try {
            ConfigManager.getInstance().load();
            path = Paths.get(ConfigManager.getInstance().getProperties("file.url"));
        } catch (IOException e) {
            System.err.println("Chargement de la configuration impossible " + e.getMessage());
        }
    }

    public StudentDao(String url) {
        System.out.println(url);
        path = Paths.get(url);
    }

    @Override
    public void insert(StudentDto item) throws RepositoryException, IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Aucun étudiant indiqué");
        }
        StringBuilder value = new StringBuilder(
                Integer.toString(item.getKey()))
                .append(",")
                .append(item.getFirstName())
                .append(",")
                .append(item.getLastName())
                .append(System.getProperty("line.separator"));
        try {
            Files.writeString(path, value, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
        try {
            String content = Files.lines(path)
                    .filter(line -> !line.contains(key.toString()))
                    .collect(Collectors.joining(System.getProperty("line.separator")));
            content += System.getProperty("line.separator");
            Files.writeString(path, content, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RepositoryException(e);
        }

    }

    @Override
    public void update(StudentDto item) throws RepositoryException, IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Aucun étudiant indiqué");
        }
        StringBuilder value = new StringBuilder(",")
                .append(item.getFirstName())
                .append(",")
                .append(item.getLastName());
        try {
            List<String> list = Files.lines(path)
                    .filter(line -> !line.contains(Integer.toString(item.getKey())))
                    .collect(Collectors.toList());
            Files.lines(path)
                    .filter(line -> line.contains(Integer.toString(item.getKey())))
                    .map(line -> line.replaceAll(",.*", value.toString()))
                    .collect(Collectors.toCollection(() -> list));
            Files.write(path, list);
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public StudentDto get(Integer key) throws RepositoryException, IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Aucun étudiant indiqué");
        }
        StudentDto user;
        try {
            user = Files.lines(path)
                    .filter(line -> line.contains(key.toString()))
                    .findFirst()
                    .map(line -> line.split(","))
                    .map(usr -> new StudentDto(Integer.parseInt(usr[0]), usr[1], usr[2]))
                    .orElse(null);
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
        return user;
    }

    @Override
    public List<StudentDto> getAll() throws RepositoryException {
        List<StudentDto> users;
        try {
            users = Files.lines(path)
                    .map(line -> line.split(","))
                    .filter(line -> line.length == 3)
                    .map(usr -> new StudentDto(Integer.parseInt(usr[0]), usr[1], usr[2]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
        return users;
    }
}
