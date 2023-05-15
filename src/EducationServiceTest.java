import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class EducationServiceTest {

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObject;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllStudentsBySubject() {
        // Given
        List<Student> students = new ArrayList<>();
        students.add(new Student("Joy Ma", "Spanish"));
        students.add(new Student("Julio Hernandez", "Algebra"));
        students.add(new Student("Jenny Jones", "Calculus"));

        given(studentDataObject.getAllStudents()).willReturn(students);

        // When
        List<Student> result = clientBusinessObject.getAllStudentsBySubject("math");

        // Then
        assertTrue(result.contains(new Student("Julio Hernandez", "Algebra")));
        assertTrue(result.contains(new Student("Jenny Jones", "Calculus")));
        assertFalse(result.contains(new Student("Joy Ma", "Spanish")));
    }

    @Test
    public void testMarkCurrentClassesInactive() {
        // Given
        Class geometry = new Class("Geometry", "Summer 2022");
        Class envScience = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");

        List<Class> classes = Arrays.asList(geometry, envScience, compLit);

        given(classDataObject.getAllCurrentClasses()).willReturn(classes);

        // When
        clientBusinessObject.markCurrentClassesInactive();

        // Then
        verify(classDataObject, times(1)).markInactive(geometry);
        verify(classDataObject, never()).markInactive(envScience);
        verify(classDataObject, never()).markInactive(compLit);
    }

    @Test
    public void testMarkCurrentClassesInactiveWithArgumentCaptor() {
        // Given
        Class geometry = new Class("Geometry", "Summer 2022");
        Class envScience = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");

        List<Class> classes = Arrays.asList(geometry, envScience, compLit);
        given(classDataObject.getAllCurrentClasses()).willReturn(classes);

        ArgumentCaptor<Class> classCaptor = ArgumentCaptor.forClass(Class.class);

        // When
        clientBusinessObject.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(classCaptor.capture());
        assertEquals(geometry, classCaptor.getValue());
    }
}
