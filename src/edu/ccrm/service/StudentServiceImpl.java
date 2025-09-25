package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class.getName());
    private final List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        if (student == null || student.getRegNo() == null || student.getFullName() == null) {
            LOGGER.warning("Invalid student details provided.");
            throw new IllegalArgumentException("Student details cannot be null.");
        }
        students.add(student);
    }

    @Override
    public List<Student> listStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public Student getStudentByRegNo(String regNo) {
        if (regNo == null || regNo.isBlank()) {
            LOGGER.warning("Registration number cannot be null or blank.");
            throw new IllegalArgumentException("Registration number cannot be null or blank.");
        }
        return students.stream()
                .filter(s -> s.getRegNo().equalsIgnoreCase(regNo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateStudent(Student student) {
        if (student == null || student.getRegNo() == null) {
            LOGGER.warning("Invalid student details provided for update.");
            throw new IllegalArgumentException("Student details cannot be null.");
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRegNo().equalsIgnoreCase(student.getRegNo())) {
                students.set(i, student);
                return;
            }
        }
        LOGGER.info("Student with registration number " + student.getRegNo() + " not found for update.");
    }

    @Override
    public void deactivateStudent(String regNo) {
        if (regNo == null || regNo.isBlank()) {
            LOGGER.warning("Registration number cannot be null or blank.");
            throw new IllegalArgumentException("Registration number cannot be null or blank.");
        }
        students.stream()
                .filter(s -> s.getRegNo().equalsIgnoreCase(regNo))
                .forEach(Student::deactivate);
    }
}
