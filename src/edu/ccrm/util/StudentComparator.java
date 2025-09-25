package edu.ccrm.util;

import edu.ccrm.domain.Student;
import java.util.Comparator;

/**
 * Optimized comparator utility class for Student objects with enhanced comparison options
 * and null-safe implementations.
 */
public final class StudentComparator {
    
    // Pre-defined comparators for better performance
    private static final Comparator<Student> BY_REG_NO = 
        Comparator.comparing(Student::getRegNo, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
    
    private static final Comparator<Student> BY_NAME = 
        Comparator.comparing(Student::getFullName, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
    
    private static final Comparator<Student> BY_EMAIL = 
        Comparator.comparing(Student::getEmail, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
    
    private static final Comparator<Student> BY_GPA = 
        Comparator.comparingDouble(Student::getGpa);
    
    private static final Comparator<Student> BY_ENROLLMENT_DATE = 
        Comparator.comparing(Student::getEnrollmentDate, Comparator.nullsLast(Comparator.naturalOrder()));
    
    // Private constructor to prevent instantiation
    private StudentComparator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Returns a comparator that compares students by registration number (case-insensitive, null-safe)
     * @return comparator for student registration numbers
     */
    public static Comparator<Student> byRegNo() {
        return BY_REG_NO;
    }
    
    /**
     * Returns a comparator that compares students by full name (case-insensitive, null-safe)
     * @return comparator for student names
     */
    public static Comparator<Student> byName() {
        return BY_NAME;
    }
    
    /**
     * Returns a comparator that compares students by email (case-insensitive, null-safe)
     * @return comparator for student emails
     */
    public static Comparator<Student> byEmail() {
        return BY_EMAIL;
    }
    
    /**
     * Returns a comparator that compares students by GPA
     * @return comparator for student GPAs
     */
    public static Comparator<Student> byGpa() {
        return BY_GPA;
    }
    
    /**
     * Returns a comparator that compares students by GPA in descending order (highest first)
     * @return comparator for student GPAs (descending)
     */
    public static Comparator<Student> byGpaDesc() {
        return BY_GPA.reversed();
    }
    
    /**
     * Returns a comparator that compares students by enrollment date (null-safe)
     * @return comparator for student enrollment dates
     */
    public static Comparator<Student> byEnrollmentDate() {
        return BY_ENROLLMENT_DATE;
    }
    
    /**
     * Returns a comparator that compares students by enrollment date in descending order (newest first)
     * @return comparator for student enrollment dates (descending)
     */
    public static Comparator<Student> byEnrollmentDateDesc() {
        return BY_ENROLLMENT_DATE.reversed();
    }
    
    /**
     * Returns a compound comparator that first compares by name, then by registration number
     * @return compound comparator for name and registration number
     */
    public static Comparator<Student> byNameThenRegNo() {
        return BY_NAME.thenComparing(BY_REG_NO);
    }
    
    /**
     * Returns a compound comparator that first compares by GPA (desc), then by name
     * Useful for academic ranking
     * @return compound comparator for GPA and name
     */
    public static Comparator<Student> byGpaDescThenName() {
        return BY_GPA.reversed().thenComparing(BY_NAME);
    }
    
    /**
     * Returns a compound comparator for complete student ordering:
     * Enrollment Date (desc) -> GPA (desc) -> Name -> Reg No
     * @return comprehensive student comparator
     */
    public static Comparator<Student> byCompleteStudentOrder() {
        return BY_ENROLLMENT_DATE.reversed()
                .thenComparing(BY_GPA.reversed())
                .thenComparing(BY_NAME)
                .thenComparing(BY_REG_NO);
    }
    
    /**
     * Returns a comparator that compares students by their active status (active students first)
     * @return comparator for student active status
     */
    public static Comparator<Student> byActiveStatus() {
        return Comparator.comparing(Student::isActive, Comparator.reverseOrder());
    }
}
