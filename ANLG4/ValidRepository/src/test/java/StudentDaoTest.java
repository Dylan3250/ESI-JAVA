import esi.atl.g54027.repository.StudentDao;
import esi.atl.g54027.repository.dto.StudentDto;
import esi.atl.g54027.repository.exception.RepositoryException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
public class StudentDaoTest {
    private final StudentDto bob;
    private final StudentDto patrick;

    private static final int KEY = 12_345;
    private static final String FILE_URL = "resourceTest.txt";
    private static final String FILE_EMPTY_URL = "resourceEmpty.txt";
    private static final String FILE_FIX_URL = "resourceFix.txt";

    private final String url = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_URL)).getFile()).getPath();
    private final String urlEmpty = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_EMPTY_URL)).getFile()).getPath();
    private final String urlFix = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_FIX_URL)).getFile()).getPath();

    private final List<StudentDto> all;

    public StudentDaoTest() {
        System.out.println("==== StudentDaoTest Constructor =====");
        bob = new StudentDto(KEY, "SquarePants", "SpongeBob");
        patrick = new StudentDto(99_999, "Star", "Patrick");

        all = List.of(new StudentDto(64_931, "Olsen", "Maggy"),
                new StudentDto(73_780, "Frost", "Phoebe"),
                new StudentDto(94_853, "Ortega", "Skyler"),
                new StudentDto(93_371, "Blankenship", "Byron"),
                new StudentDto(82_227, "Cote", "Molly"),
                bob);
    }

    @Test
    public void testSelectExist() throws Exception {
        System.out.println("testSelectExist");
        //Arrange
        StudentDto expected = new StudentDto(64_931, "Olsen", "Maggy");
        StudentDao dao = new StudentDao(url);
        //Action
        StudentDto result = dao.get(64_931);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        //Arrange
        StudentDao dao = new StudentDao(url);
        //Action
        StudentDto result = dao.get(patrick.getKey());
        //Assert
        assertNull(result);
    }

    @Test
    public void testSelectIncorrectParameter() throws Exception {
        System.out.println("testSelectIncorrectParameter");
        //Arrange
        StudentDao dao = new StudentDao(url);
        Integer incorrect = null;
        //Assert
        assertThrows(IllegalArgumentException.class, () -> {
            dao.get(incorrect);
        });
    }

    @Test
    public void testSelectWhenFileNotFound() throws Exception {
        System.out.println("testSelectWhenFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);
            dao.get(KEY);
        });
    }

    @Test
    // Possible de donner un ordre d'execution avec @Order(1)
    public void testSelectAllExist() throws Exception {
        System.out.println("testSelectAllExist");
        //Arrange
        List<StudentDto> expected = all;
        StudentDao dao = new StudentDao(urlFix);
        //Action
        List<StudentDto> result = dao.getAll();
        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSelectAllNotExist() throws Exception {
        System.out.println("testSelectAllNotExist");
        //Arrange
        List<StudentDto> expected = new LinkedList<>();
        StudentDao dao = new StudentDao(urlEmpty);
        //Action
        List<StudentDto> result = dao.getAll();
        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSelectAllWhenFileNotFound() throws Exception {
        System.out.println("testSelectAllWhenFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);
            dao.getAll();
        });
    }

    @Test
    public void testInsertExist() throws Exception {
        // Tester si c'est insérable = repo, rien à tester ?
        StudentDao dao = new StudentDao(url);
        dao.insert(new StudentDto(64931, "Olsen", "Maggy"));
        assertEquals(dao.get(64931), new StudentDto(64931, "Olsen", "Maggy"));
    }

    @Test
    public void testInsertNotExist() throws Exception {
        // Tester si c'est insérable = repo, rien à tester ? => retourne void
        StudentDao dao = new StudentDao(url);
        dao.insert(new StudentDto(777777, "NouveauBoy", "VraiNew"));
        assertEquals(dao.get(777777), new StudentDto(777777, "NouveauBoy", "VraiNew"));
    }

    @Test
    public void testInsertIncorrectParameter() throws Exception {
        System.out.println("testInsertIncorrectParameter");
        //Arrange
        StudentDao dao = new StudentDao(url);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> {
            dao.insert(null);
        });
    }

    @Test
    public void testInsertWhenFileNotFound() throws Exception {
        System.out.println("testInsertWhenFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);
            dao.insert(bob);
        });
    }

    @Test
    public void testUpdateExist() throws Exception {
        // Tester si c'est updatable = repo, rien à tester ?
        StudentDao dao = new StudentDao(url);
        dao.update(new StudentDto(12_345, "Boby", "Rectangle"));
        // (dao.get(12345), new StudentDto(12_345, "Boby", "Rectangle"));
    }

    @Test
    public void testUpdateNotExist() throws Exception {
        // Tester si c'est updatable = repo, rien à tester ? => retourne void
        StudentDao dao = new StudentDao(url);
        dao.update(patrick);
        assertNull(dao.get(patrick.getKey()));
    }

    @Test
    public void testUpdateIncorrectParameter() throws Exception {
        System.out.println("testUpdateIncorrectParameter");
        //Arrange
        StudentDao dao = new StudentDao(url);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> {
            dao.update(null);
        });
    }

    @Test
    public void testUpdateWhenFileNotFound() throws Exception {
        System.out.println("testUpdateWhenFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);
            dao.update(bob);
        });
    }

    @Test
    public void testDeleteExist() throws Exception {
        // Tester si c'est deletable = repo, rien à tester ?
        StudentDao dao = new StudentDao(url);
        dao.delete(KEY);
        assertNull(dao.get(KEY));
    }

    @Test
    public void testDeleteNotExist() throws Exception {
        // Tester si c'est deletable = repo, rien à tester ? => retourne void
        StudentDao dao = new StudentDao(url);
        dao.delete(KEY);
        assertNull(dao.get(KEY));
    }

    @Test
    public void testDeleteIncorrectParameter() throws Exception {
        System.out.println("testDeleteIncorrectParameter");
        //Arrange
        StudentDao dao = new StudentDao(url);
        Integer incorrect = null;
        //Assert
        assertThrows(IllegalArgumentException.class, () -> {
            dao.get(incorrect);
        });
    }

    @Test
    public void testDeleteWhenFileNotFound() throws Exception {
        System.out.println("testDeleteWhenFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);
            dao.get(KEY);
        });
    }
}
