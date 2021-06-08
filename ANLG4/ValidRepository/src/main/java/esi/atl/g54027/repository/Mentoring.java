package esi.atl.g54027.repository;

import esi.atl.g54027.repository.dto.StudentDto;
import esi.atl.g54027.repository.exception.RepositoryException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mentoring {

    public static void main(String[] args) {
        try {
            Mentoring mentoring = new Mentoring();
            mentoring.checkPath();

            ConfigManager.getInstance().load();

            String author = ConfigManager.getInstance().getProperties("app.author");
            System.out.println("Auteur : " + author);

            // Ajouter
            StudentRepository students = StudentRepository.getInstance();

            students.add(new StudentDto(64931, "Olsen", "Maggy"));
            students.add(new StudentDto(73780, "Frost", "Phoebe"));
            students.add(new StudentDto(94853, "Ortega", "Skyler"));
            students.add(new StudentDto(93371, "Blankenship", "Byron"));
            students.add(new StudentDto(82227, "Cote", "Mollyte"));

            System.out.println("1. Afficher tous les étudiants :");
            List<StudentDto> listStudents = students.getAll();
            listStudents.forEach(value -> System.out.println(value.getFirstName()));

            System.out.println("2. Ajouter un nouveau élément :");
            students.add(new StudentDto(54027, "Dylan", "Bricar"));

            System.out.println("3. Afficher tous les étudiants :");
            listStudents = students.getAll();
            listStudents.forEach(value -> System.out.println(value.getFirstName()));

            System.out.println("4. Modifier un étudiant :");
            students.add(new StudentDto(54027, "Dylan2.0", "BricarUpdated"));

            System.out.println("5. Afficher tous les étudiants :");
            listStudents = students.getAll();
            listStudents.forEach(value -> System.out.println(value.getFirstName()));

            System.out.println("6. Supprimer un élément :");
            students.remove(64931);

            System.out.println("7. Afficher tous les étudiants :");
            listStudents = students.getAll();
            listStudents.forEach(value -> System.out.println(value.getFirstName()));
        } catch (IOException | RepositoryException e) {
            Logger.getLogger(Mentoring.class.getName()).log(Level.SEVERE, "Le fichier ne peut être ouvert !");
            System.exit(-1);
        }
    }

    public void checkPath() {
        System.out.println("Chemin courant \t" + new File(".").getAbsolutePath());
        System.out.println("Chemin classe \t" + this.getClass().getResource(".").getPath());
        System.out.println("Chemin jar \t" + new File(Objects.requireNonNull(getClass().getClassLoader().getResource(".")).getFile()));
    }
}
