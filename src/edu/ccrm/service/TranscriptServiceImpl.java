package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.util.Validator;
import java.util.List;
import java.util.StringJoiner;

public class TranscriptServiceImpl implements TranscriptService {
    private final EnrollmentService enrollmentService;

    public TranscriptServiceImpl(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @Override
    public String generateTranscript(Student student) {
        Validator.requireNonNull(student, "Student cannot be null");

        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(student);
        if (enrollments == null || enrollments.isEmpty()) {
            return "No enrollments found for student: " + student.getFullName();
        }

        StringJoiner transcript = new StringJoiner("\n", "Transcript for " + student.getFullName() + ":\n", "");
        enrollments.forEach(e -> transcript.add(e.toString()));

        return transcript.toString();
    }

    @Override
    public double computeGPA(Student student) {
        Validator.requireNonNull(student, "Student cannot be null");

        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(student);
        if (enrollments == null || enrollments.isEmpty()) {
            return 0.0;
        }

        int totalCredits = 0;
        int totalPoints = 0;

        for (Enrollment e : enrollments) {
            if (e.getGrade() != null && e.getCourse() != null) {
                int credits = e.getCourse().getCredits();
                totalCredits += credits;
                totalPoints += credits * e.getGrade().getGradePoint();
            }
        }

        return totalCredits == 0 ? 0.0 : (double) totalPoints / totalCredits;
    }
}
