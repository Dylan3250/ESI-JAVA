import esi.atl.g54027.repository.StudentDao;
import esi.atl.g54027.repository.StudentRepository;
import esi.atl.g54027.repository.dto.StudentDto;
import esi.atl.g54027.repository.exception.RepositoryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StudentRepositoryTest {
    @Mock
    private StudentDao mock;

    private final StudentDto bob;

    private final StudentDto patrick;

    private static final int KEY = 12_345;

    private final List<StudentDto> all;

    @BeforeEach
    void init() throws RepositoryException {
        System.out.println("==== BEFORE EACH =====");
        //Mock behaviour
        Mockito.lenient().when(mock.get(bob.getKey())).thenReturn(bob);
        Mockito.lenient().when(mock.get(patrick.getKey())).thenReturn(null);
        Mockito.lenient().when(mock.getAll()).thenReturn(all);
        Mockito.lenient().when(mock.get(null)).thenThrow(RepositoryException.class);
    }

    public StudentRepositoryTest() {
        System.out.println("StudentRepositoryTest Constructor");
        //Test data
        bob = new StudentDto(KEY, "SquarePants", "SpongeBob");
        patrick = new StudentDto(99_999, "Star", "Patrick");

        all = new ArrayList<>();
        all.add(bob);
        all.add(patrick);
    }

    @Test
    public void testGetExist() throws Exception {
        System.out.println("testGetExist");
        //Arrange
        StudentDto expected = bob;
        StudentRepository repository = new StudentRepository(mock);
        //Action
        StudentDto result = repository.get(KEY);
        //Assert
        assertEquals(expected, result);
        Mockito.verify(mock, times(1)).get(KEY);
    }

    @Test
    public void testGetNotExist() throws Exception {
        System.out.println("testGetNotExist");
        //Arrange
        StudentDto expected = null;
        StudentRepository repository = new StudentRepository(mock);
        //Action
        StudentDto result = repository.get(patrick.getKey());
        //Assert
        assertEquals(expected, result);
        Mockito.verify(mock, times(1)).get(patrick.getKey());
    }

    @Test
    public void testGetIncorrectParameter() throws Exception {
        System.out.println("testGetIncorrectParameter");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Assert
        assertThrows(RepositoryException.class, () -> {
            repository.get(null);
        });
        Mockito.verify(mock, times(1)).get(null);
    }

    @Test
    public void testAddWhenExisting() throws Exception {
        System.out.println("testAddWhenExisting");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        repository.add(bob);
        //Assert
        Mockito.verify(mock, times(1)).getAll();
        Mockito.verify(mock, times(1)).update(bob);
        Mockito.verify(mock, times(0)).insert(any(StudentDto.class));
    }

    @Test
    public void testAddWhenNotExisting() throws Exception {
        System.out.println("testAddWhenNotExisting");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        var newUser = new StudentDto(77777, "newUser", "reallyNewUser");
        repository.add(newUser);
        //Assert
        Mockito.verify(mock, times(1)).getAll();
        Mockito.verify(mock, times(0)).update(any(StudentDto.class));
        Mockito.verify(mock, times(1)).insert(newUser);
    }

    @Test
    public void testRemoveWhenExisting() throws Exception {
        System.out.println("testRemoveWhenExisting");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        repository.remove(bob.getKey());
        //Assert
        Mockito.verify(mock, times(1)).getAll();
        Mockito.verify(mock, times(1)).delete(bob.getKey());
    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println("testGetAll");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        repository.getAll();
        //Assert
        Mockito.verify(mock, times(1)).getAll();
    }

    @Test
    public void testContainsExist() throws Exception {
        System.out.println("testContainsExist");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        boolean result = repository.contains(bob.getKey());
        //Assert
        assertTrue(result);
        Mockito.verify(mock, times(1)).getAll();
    }

    @Test
    public void testContainsNotExist() throws Exception {
        System.out.println("testContainsNotExist");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        boolean result = repository.contains(66666);
        //Assert
        assertFalse(result);
        Mockito.verify(mock, times(1)).getAll();
    }
}
