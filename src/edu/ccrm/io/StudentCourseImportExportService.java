package edu.ccrm.io;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;

public class StudentCourseImportExportService implements ImportExportService<Object> {

    private static final Logger LOGGER = Logger.getLogger(StudentCourseImportExportService.class.getName());
    private static final int STUDENT_PARTS_LENGTH = 4;
    private static final int COURSE_PARTS_LENGTH = 6;

    @Override
    public List<Object> importFromFile(String filePath) {
        List<Object> imported = new ArrayList<>();
        Path path = Paths.get(filePath);
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                parseLine(line).ifPresent(imported::add);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading file: {0}", e.getMessage());
        }
        return imported;
    }

    private Optional<Object> parseLine(String line) {
        String[] parts = line.split(",");
        if (parts.length == STUDENT_PARTS_LENGTH) {
            return Optional.of(new Student(parts[0], parts[1], parts[2], parts[3]));
        } else if (parts.length == COURSE_PARTS_LENGTH) {
            try {
                return Optional.of(new Course(parts[0], parts[1], Integer.parseInt(parts[2]), null, null, parts[5]));
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Invalid course credits in line: {0}", line);
            }
        } else {
            LOGGER.log(Level.WARNING, "Invalid line format: {0}", line);
        }
        return Optional.empty();
    }

    @Override
    public void exportToFile(List<Object> data, String filePath) {
        Path path = Paths.get(filePath);
        List<String> lines = new ArrayList<>();
        for (Object obj : data) {
            lines.add(formatObject(obj));
        }
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing file: {0}", e.getMessage());
        }
    }

    private String formatObject(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            return String.join(",",
                s.getId(), s.getRegNo(), s.getFullName(), s.getEmail()
            );
        } else if (obj instanceof Course) {
            Course c = (Course) obj;
            return String.join(",",
                c.getCode(), c.getTitle(), String.valueOf(c.getCredits()),
                c.getInstructor() != null ? c.getInstructor().getFullName() : "",
                c.getSemester() != null ? c.getSemester().toString() : "", c.getDepartment()
            );
        }
        return "";
    }
}
