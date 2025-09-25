package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.CourseBuilder;
import edu.ccrm.domain.Instructor;
import edu.ccrm.domain.Semester;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {
    private static final Logger LOGGER = Logger.getLogger(CourseServiceImpl.class.getName());
    private final List<Course> courses = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        if (course == null || course.getCode() == null || course.getTitle() == null) {
            LOGGER.warning("Invalid course details provided.");
            throw new IllegalArgumentException("Course details cannot be null.");
        }
        Course builtCourse = new CourseBuilder()
            .setCode(course.getCode())
            .setTitle(course.getTitle())
            .setCredits(course.getCredits())
            .setInstructor(course.getInstructor())
            .setSemester(course.getSemester())
            .setDepartment(course.getDepartment())
            .build();
        courses.add(builtCourse);
    }

    @Override
    public List<Course> listCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public Course getCourseByCode(String code) {
        if (code == null || code.isBlank()) {
            LOGGER.warning("Course code cannot be null or blank.");
            throw new IllegalArgumentException("Course code cannot be null or blank.");
        }
        return courses.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateCourse(Course course) {
        if (course == null || course.getCode() == null) {
            LOGGER.warning("Invalid course details provided for update.");
            throw new IllegalArgumentException("Course details cannot be null.");
        }
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equalsIgnoreCase(course.getCode())) {
                courses.set(i, course);
                return;
            }
        }
        LOGGER.info("Course with code " + course.getCode() + " not found for update.");
    }

    @Override
    public List<Course> searchByInstructor(String instructorId) {
        if (instructorId == null || instructorId.isBlank()) {
            LOGGER.warning("Instructor ID cannot be null or blank.");
            throw new IllegalArgumentException("Instructor ID cannot be null or blank.");
        }
        return courses.stream()
            .filter(course -> course.getInstructor() != null &&
                    course.getInstructor().getId().equals(instructorId))
            .collect(Collectors.toList());
    }

    @Override
    public List<Course> searchByDepartment(String department) {
        if (department == null || department.isBlank()) {
            LOGGER.warning("Department cannot be null or blank.");
            throw new IllegalArgumentException("Department cannot be null or blank.");
        }
        return courses.stream()
            .filter(course -> course.getDepartment().equalsIgnoreCase(department))
            .collect(Collectors.toList());
    }

    @Override
    public List<Course> searchBySemester(String semester) {
        if (semester == null || semester.isBlank()) {
            LOGGER.warning("Semester cannot be null or blank.");
            throw new IllegalArgumentException("Semester cannot be null or blank.");
        }
        return courses.stream()
            .filter(course -> course.getSemester() != null &&
                    course.getSemester().toString().equalsIgnoreCase(semester))
            .collect(Collectors.toList());
    }

    @Override
    public List<Course> searchCourses(String department, String semester, 
            Integer minCredits, Integer maxCredits) {
        return courses.stream()
            .filter(course -> department == null || 
                    course.getDepartment().equalsIgnoreCase(department))
            .filter(course -> semester == null || 
                    (course.getSemester() != null && 
                    course.getSemester().toString().equalsIgnoreCase(semester)))
            .filter(course -> minCredits == null || course.getCredits() >= minCredits)
            .filter(course -> maxCredits == null || course.getCredits() <= maxCredits)
            .collect(Collectors.toList());
    }

    @Override
    public double getAverageCredits() {
        return courses.stream()
            .mapToInt(Course::getCredits)
            .average()
            .orElse(0.0);
    }

    @Override
    public int getTotalCoursesByDepartment(String department) {
        if (department == null || department.isBlank()) {
            LOGGER.warning("Department cannot be null or blank.");
            throw new IllegalArgumentException("Department cannot be null or blank.");
        }
        return (int) courses.stream()
            .filter(course -> course.getDepartment().equalsIgnoreCase(department))
            .count();
    }

    @Override
    public List<Course> getCoursesOrderedByCredits() {
        return courses.stream()
            .sorted(Comparator.comparingInt(Course::getCredits).reversed())
            .collect(Collectors.toList());
    }

    @Override
    public void deactivateCourse(String code) {
        if (code == null || code.isBlank()) {
            LOGGER.warning("Course code cannot be null or blank.");
            throw new IllegalArgumentException("Course code cannot be null or blank.");
        }
        courses.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .forEach(Course::deactivate);
    }

    public List<Course> filterByInstructor(Instructor instructor) {
        if (instructor == null) {
            LOGGER.warning("Instructor cannot be null.");
            throw new IllegalArgumentException("Instructor cannot be null.");
        }
        return courses.stream()
                .filter(c -> c.getInstructor().equals(instructor))
                .collect(Collectors.toList());
    }

    public List<Course> filterByDepartment(String department) {
        if (department == null || department.isBlank()) {
            LOGGER.warning("Department cannot be null or blank.");
            throw new IllegalArgumentException("Department cannot be null or blank.");
        }
        return courses.stream()
                .filter(c -> c.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public List<Course> filterBySemester(Semester semester) {
        if (semester == null) {
            LOGGER.warning("Semester cannot be null.");
            throw new IllegalArgumentException("Semester cannot be null.");
        }
        return courses.stream()
                .filter(c -> c.getSemester() == semester)
                .collect(Collectors.toList());
    }
}
