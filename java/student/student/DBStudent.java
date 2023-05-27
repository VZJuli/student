package student.student;

import org.springframework.aot.generate.GeneratedMethods;

import java.util.ArrayList;

public class DBStudent {
    private static ArrayList<Student> DBStudents = new ArrayList<>();
    private static Long id = 6L;


    static {
        DBStudents.add(new Student(1L, "Serik", "Slambekov", 88, "B"));
        DBStudents.add(new Student(2L, "Serik", "Erikov", 96, "A"));
        DBStudents.add(new Student(3L, "Salma", "zhasikova", 65, "C"));
        DBStudents.add(new Student(4L, "Raya", "Dzetpesbieva", 100, "A"));
        DBStudents.add(new Student(5L, "Masha", "Kulkina", 48, "F"));
        DBStudents.add(new Student(6L, "Fedya", "Safronov", 35, "F"));
    }

    public static ArrayList<Student> getDBStudents() {

        return DBStudents;
    }

    public static void addStudent(Student student) {
        student.setId(id);
        DBStudents.add(student);
        id++;
    }
}