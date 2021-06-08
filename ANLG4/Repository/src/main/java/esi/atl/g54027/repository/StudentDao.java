package esi.atl.g54027.repository;

import esi.atl.g54027.repository.dto.StudentDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentDao implements Dao<StudentDto> {
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

    @Override
    public void insert(StudentDto item) {
        StringBuilder value = new StringBuilder(
                Integer.toString(item.getMatricule()))
                .append(",")
                .append(item.getFirstName())
                .append(",")
                .append(item.getLastName())
                .append(System.getProperty("line.separator"));
        try {
            Files.writeString(path, value, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'insertion : " + e.getMessage());
        }
    }

    @Override
    public void delete(StudentDto item) {
        StringBuilder value = new StringBuilder(
                Integer.toString(item.getMatricule()))
                .append(",")
                .append(item.getFirstName())
                .append(",")
                .append(item.getLastName());

        try {
            String content = Files.lines(path)
                    .filter(line -> !line.equalsIgnoreCase(value.toString()))
                    .collect(Collectors.joining(System.getProperty("line.separator")));
            content += System.getProperty("line.separator");
            Files.writeString(path, content, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Erreur lors de la supression : " + e.getMessage());
        }
    }

    @Override
    public void update(StudentDto item) {
        StringBuilder value = new StringBuilder(",")
                .append(item.getFirstName())
                .append(",")
                .append(item.getLastName());
        try {
            List<String> list = Files.lines(path)
                    .filter(line -> !line.contains(Integer.toString(item.getMatricule())))
                    .collect(Collectors.toList());
            Files.lines(path)
                    .filter(line -> line.contains(Integer.toString(item.getMatricule())))
                    .map(line -> line.replaceAll(",.*", value.toString()))
                    .collect(Collectors.toCollection(() -> list));
            Files.write(path, list);
        } catch (IOException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
    }

    @Override
    public StudentDto get(StudentDto item) {
        StringBuilder value = new StringBuilder(
                Integer.toString(item.getMatricule()))
                .append(",")
                .append(item.getFirstName())
                .append(",")
                .append(item.getLastName());

        boolean isExist = false;
        try {
            isExist = Files.lines(path)
                    .anyMatch(line -> line.equalsIgnoreCase(value.toString()));
        } catch (IOException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
        return isExist ? item : null;
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentDto> users = new LinkedList<>();
        try {
            users = Files.lines(path)
                    .map(line -> line.split(","))
                    .map(usr -> new StudentDto(Integer.parseInt(Optional.of(usr[0]).orElse("")),
                    Optional.of(usr[1]).orElse(""),
                    Optional.of(usr[2]).orElse("")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Erreur lors de l'affichage de tous les éléments : " + e.getMessage());
        }
        return users;
    }
}
