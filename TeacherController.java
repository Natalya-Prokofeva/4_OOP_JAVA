import java.time.LocalDate;

public class TeacherController implements UserController<Teacher> {

    private final TeacherService teacherService = new TeacherService();
    private final TeacherView teacherView = new TeacherView();

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        teacherService.create(firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(teacherService.getAll());
    }

    public void updateTeacher(Long teacherId, String newFirstName, String newSecondName, String newPatronymic) {
        for (Teacher teacher : teacherService.getAll()) {
            if (teacher.getTeacherId().equals(teacherId)) {
                teacher.setFirstName(newFirstName);
                teacher.setSecondName(newSecondName);
                teacher.setPatronymic(newPatronymic);
            }
        }
    }
    
    public void displayAllTeachers() {
        teacherView.sendOnConsole(teacherService.getAll());
    }
}
