package edu.ccrm.util;

import java.util.regex.Pattern;

/**
 * Optimized validator utility class with compiled patterns for better performance
 * and enhanced validation capabilities.
 */
public final class Validator {
    
    // Pre-compiled patterns for better performance
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    
    private static final Pattern REG_NO_PATTERN = Pattern.compile("^[A-Z]{2,3}\\d{6}$");
    
    private static final Pattern COURSE_CODE_PATTERN = Pattern.compile("^[A-Z]{2,4}\\d{3,4}$");
    
    // Private constructor to prevent instantiation
    private Validator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Validates email format with improved regex pattern
     * @param email the email to validate
     * @return true if email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email.trim()).matches();
    }
    
    /**
     * Validates registration number format (2-3 uppercase letters followed by 6 digits)
     * @param regNo the registration number to validate
     * @return true if registration number is valid, false otherwise
     */
    public static boolean isValidRegNo(String regNo) {
        return regNo != null && REG_NO_PATTERN.matcher(regNo.trim()).matches();
    }
    
    /**
     * Validates course code format (2-4 uppercase letters followed by 3-4 digits)
     * @param courseCode the course code to validate
     * @return true if course code is valid, false otherwise
     */
    public static boolean isValidCourseCode(String courseCode) {
        return courseCode != null && COURSE_CODE_PATTERN.matcher(courseCode.trim()).matches();
    }
    
    /**
     * Checks if a string is non-empty after trimming
     * @param value the string to check
     * @return true if string is not null and not empty after trimming
     */
    public static boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    
    /**
     * Validates that an object is not null, throwing IllegalArgumentException if it is
     * @param obj the object to validate
     * @param message the error message to use if validation fails
     * @param <T> the type of object being validated
     * @throws IllegalArgumentException if obj is null
     */
    public static <T> void requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }
    
    /**
     * Validates that a string is not null or empty, throwing IllegalArgumentException if it is
     * @param str the string to validate
     * @param fieldName the name of the field being validated (for error message)
     * @throws IllegalArgumentException if string is null or empty
     */
    public static void requireNonEmpty(String str, String fieldName) {
        if (!isNonEmpty(str)) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }
    
    /**
     * Validates that a number is within a specified range
     * @param value the value to validate
     * @param min the minimum allowed value (inclusive)
     * @param max the maximum allowed value (inclusive)
     * @param fieldName the name of the field being validated
     * @throws IllegalArgumentException if value is outside the range
     */
    public static void requireInRange(int value, int min, int max, String fieldName) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(
                String.format("%s must be between %d and %d, but was %d", fieldName, min, max, value)
            );
        }
    }
    
    /**
     * Validates credit hours for courses (1-6 credits)
     * @param credits the credit hours to validate
     * @return true if credits are valid, false otherwise
     */
    public static boolean isValidCredits(int credits) {
        return credits >= 1 && credits <= 6;
    }
    
    /**
     * Validates marks/grades (0-100)
     * @param marks the marks to validate
     * @return true if marks are valid, false otherwise
     */
    public static boolean isValidMarks(int marks) {
        return marks >= 0 && marks <= 100;
    }
}
