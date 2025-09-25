package edu.ccrm.service;

import edu.ccrm.config.EnrollmentConfig;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.DuplicateEnrollmentException;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.MaxCreditLimitExceededException;
import edu.ccrm.domain.Semester;
import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EnrollmentServiceImpl implements EnrollmentService {
    private static final Logger LOGGER = Logger.getLogger(EnrollmentServiceImpl.class.getName());
    private final List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public void enrollStudent(Student student, Course course) 
        throws DuplicateEnrollmentException, MaxCreditLimitExceededException {
        validateStudentAndCourse(student, course);

        if (isStudentAlreadyEnrolled(student, course)) {
            LOGGER.warning("Student is already enrolled in this course.");
            throw new DuplicateEnrollmentException("Student is already enrolled in this course.");
        }

        int currentCredits = calculateCurrentCredits(student, course.getSemester());

        validateCreditLimits(student, course, currentCredits);

        enrollments.add(new Enrollment(student, course));
        student.enrollCourse(course.getCode());
    }

    private void validateStudentAndCourse(Student student, Course course) {
        if (student == null || course == null) {
            LOGGER.warning("Student or course cannot be null.");
            throw new IllegalArgumentException("Student or course cannot be null.");
        }
    }

    private boolean isStudentAlreadyEnrolled(Student student, Course course) {
        return enrollments.stream()
            .anyMatch(e -> e.getStudent().equals(student) && e.getCourse().equals(course));
    }

    private int calculateCurrentCredits(Student student, Semester semester) {
        return enrollments.stream()
            .filter(e -> e.getStudent().equals(student))
            .filter(e -> e.getCourse().getSemester() == semester)
            .mapToInt(e -> e.getCourse().getCredits())
            .sum();
    }

    private void validateCreditLimits(Student student, Course course, int currentCredits) 
        throws MaxCreditLimitExceededException {
        String validationError = EnrollmentConfig.validateCreditLoad(
            currentCredits, 
            course.getCredits(),
            student.getGpa()
        );

        if (validationError != null) {
            LOGGER.warning(validationError);
            throw new MaxCreditLimitExceededException(validationError);
        }

        if (currentCredits == 0 && course.getCredits() < EnrollmentConfig.getMinCreditsPerSemester()) {
            String error = String.format("Must enroll in at least %d credits for first course in semester",
                EnrollmentConfig.getMinCreditsPerSemester());
            LOGGER.warning(error);
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public void unenrollStudent(Student student, Course course) {
        validateStudentAndCourse(student, course);
        enrollments.removeIf(e -> e.getStudent().equals(student) && e.getCourse().equals(course));
        student.unenrollCourse(course.getCode());
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudent(Student student) {
        if (student == null) {
            LOGGER.warning("Student cannot be null.");
            throw new IllegalArgumentException("Student cannot be null.");
        }
        return enrollments.stream()
            .filter(e -> e.getStudent().equals(student))
            .collect(Collectors.toList());
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourse(Course course) {
        if (course == null) {
            LOGGER.warning("Course cannot be null.");
            throw new IllegalArgumentException("Course cannot be null.");
        }
        return enrollments.stream()
            .filter(e -> e.getCourse().equals(course))
            .collect(Collectors.toList());
    }

    @Override
    public void recordMarks(Student student, Course course, int marks) {
        validateStudentAndCourse(student, course);
        enrollments.stream()
            .filter(e -> e.getStudent().equals(student) && e.getCourse().equals(course))
            .findFirst()
            .ifPresentOrElse(
                e -> e.recordMarks(marks),
                () -> LOGGER.warning("Enrollment not found for student and course.")
            );
    }
}
