import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher> {

    private final List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long maxId = 0L;
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() > maxId) {
                maxId = teacher.getTeacherId();
            }
        }
        maxId++;
        Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth, maxId);
        teachers.add(teacher);
    }
}
