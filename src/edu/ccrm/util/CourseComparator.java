package edu.ccrm.util;

import edu.ccrm.domain.Course;
import java.util.Comparator;

/**
 * Optimized comparator utility class for Course objects with enhanced comparison options
 * and null-safe implementations.
 */
public final class CourseComparator {
    
    // Pre-defined comparators for better performance
    private static final Comparator<Course> BY_CODE = 
        Comparator.comparing(Course::getCode, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
    
    private static final Comparator<Course> BY_TITLE = 
        Comparator.comparing(Course::getTitle, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
    
    private static final Comparator<Course> BY_CREDITS = 
        Comparator.comparingInt(Course::getCredits);
    
    private static final Comparator<Course> BY_DEPARTMENT = 
        Comparator.comparing(Course::getDepartment, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
    
    private static final Comparator<Course> BY_SEMESTER = 
        Comparator.comparing(course -> course.getSemester() != null ? course.getSemester().toString() : null,
                           Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
    
    // Private constructor to prevent instantiation
    private CourseComparator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Returns a comparator that compares courses by code (case-insensitive, null-safe)
     * @return comparator for course codes
     */
    public static Comparator<Course> byCode() {
        return BY_CODE;
    }
    
    /**
     * Returns a comparator that compares courses by title (case-insensitive, null-safe)
     * @return comparator for course titles
     */
    public static Comparator<Course> byTitle() {
        return BY_TITLE;
    }
    
    /**
     * Returns a comparator that compares courses by credit hours
     * @return comparator for course credits
     */
    public static Comparator<Course> byCredits() {
        return BY_CREDITS;
    }
    
    /**
     * Returns a comparator that compares courses by department (case-insensitive, null-safe)
     * @return comparator for course departments
     */
    public static Comparator<Course> byDepartment() {
        return BY_DEPARTMENT;
    }
    
    /**
     * Returns a comparator that compares courses by semester (null-safe)
     * @return comparator for course semesters
     */
    public static Comparator<Course> bySemester() {
        return BY_SEMESTER;
    }
    
    /**
     * Returns a comparator that compares courses by credits in descending order
     * @return comparator for course credits (descending)
     */
    public static Comparator<Course> byCreditsDsc() {
        return BY_CREDITS.reversed();
    }
    
    /**
     * Returns a compound comparator that first compares by department, then by code
     * @return compound comparator for department and code
     */
    public static Comparator<Course> byDepartmentThenCode() {
        return BY_DEPARTMENT.thenComparing(BY_CODE);
    }
    
    /**
     * Returns a compound comparator that first compares by semester, then by code
     * @return compound comparator for semester and code
     */
    public static Comparator<Course> bySemesterThenCode() {
        return BY_SEMESTER.thenComparing(BY_CODE);
    }
    
    /**
     * Returns a compound comparator for complete course ordering:
     * Department -> Semester -> Credits (desc) -> Code
     * @return comprehensive course comparator
     */
    public static Comparator<Course> byCompleteCourseOrder() {
        return BY_DEPARTMENT
                .thenComparing(BY_SEMESTER)
                .thenComparing(BY_CREDITS.reversed())
                .thenComparing(BY_CODE);
    }
}
