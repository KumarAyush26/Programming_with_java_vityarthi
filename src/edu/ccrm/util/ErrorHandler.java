package edu.ccrm.util;

import edu.ccrm.domain.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Optimized centralized error handling for CCRM application with enhanced logging,
 * error categorization, and validation capabilities.
 */
public final class ErrorHandler {
    
    private static final Logger LOGGER = Logger.getLogger(ErrorHandler.class.getName());
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // Error message templates for consistency
    private static final Map<Class<? extends Exception>, ErrorInfo> ERROR_MAPPINGS = new HashMap<>();
    
    static {
        ERROR_MAPPINGS.put(InvalidRegistrationNumberException.class, 
            new ErrorInfo("⚠️ Registration Number Error", Level.WARNING));
        ERROR_MAPPINGS.put(InvalidCourseCreditsException.class, 
            new ErrorInfo("⚠️ Course Credits Error", Level.WARNING));
        ERROR_MAPPINGS.put(InvalidSemesterException.class, 
            new ErrorInfo("⚠️ Invalid Semester", Level.WARNING));
        ERROR_MAPPINGS.put(DuplicateEnrollmentException.class, 
            new ErrorInfo("⚠️ Enrollment Error", Level.WARNING));
        ERROR_MAPPINGS.put(MaxCreditLimitExceededException.class, 
            new ErrorInfo("⚠️ Credit Limit Exceeded", Level.WARNING));
        ERROR_MAPPINGS.put(IllegalArgumentException.class, 
            new ErrorInfo("⚠️ Invalid Input", Level.WARNING));
        ERROR_MAPPINGS.put(IllegalStateException.class, 
            new ErrorInfo("⚠️ Invalid State", Level.WARNING));
    }
    
    // Private constructor to prevent instantiation
    private ErrorHandler() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Handles exceptions with enhanced logging and user-friendly error messages
     * @param e the exception to handle
     */
    public static void handleException(Exception e) {
        handleException(e, null);
    }
    
    /**
     * Handles exceptions with additional context information
     * @param e the exception to handle
     * @param context additional context information
     */
    public static void handleException(Exception e, String context) {
        ErrorInfo errorInfo = ERROR_MAPPINGS.getOrDefault(e.getClass(), 
            new ErrorInfo("❌ System Error", Level.SEVERE));
        
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        String errorMessage = String.format("[%s] %s: %s", timestamp, errorInfo.prefix, e.getMessage());
        
        if (context != null && !context.trim().isEmpty()) {
            errorMessage += " (Context: " + context + ")";
        }
        
        // Log the error
        LOGGER.log(errorInfo.level, errorMessage, e);
        
        // Display user-friendly message
        System.err.println(errorMessage);
        
        // Additional debug information if enabled
        if (LOGGER.isLoggable(Level.FINE)) {
            logDebugInfo(e);
        }
        
        // Log critical errors with stack trace
        if (errorInfo.level == Level.SEVERE) {
            LOGGER.log(Level.SEVERE, "Stack trace for critical error:", e);
        }
    }
    
    /**
     * Logs detailed debug information about the exception
     * @param e the exception to log debug info for
     */
    private static void logDebugInfo(Exception e) {
        LOGGER.fine("=== Debug Information ===");
        LOGGER.fine("Exception type: " + e.getClass().getName());
        LOGGER.fine("Exception message: " + e.getMessage());
        LOGGER.fine("Stack trace:");
        for (StackTraceElement element : e.getStackTrace()) {
            LOGGER.fine("  " + element.toString());
        }
        
        // Log cause if present
        Throwable cause = e.getCause();
        if (cause != null) {
            LOGGER.fine("Root cause: " + cause.getClass().getName() + " - " + cause.getMessage());
        }
    }
    
    /**
     * Enhanced student data validation with detailed error reporting
     * @param id student ID
     * @param regNo registration number
     * @param fullName full name
     * @param email email address
     * @throws IllegalArgumentException if validation fails
     */
    public static void validateStudentData(String id, String regNo, String fullName, String email) {
        ValidationResult result = new ValidationResult();
        
        // Validate each field with specific error messages
        validateField(id, "Student ID", Validator::isNonEmpty, result);
        validateField(regNo, "Registration Number", Validator::isValidRegNo, 
            "Invalid registration number format (expected: 2-3 uppercase letters followed by 6 digits, e.g., CS123456)", result);
        validateField(fullName, "Full Name", Validator::isNonEmpty, result);
        validateField(email, "Email", Validator::isValidEmail, 
            "Invalid email format (expected: user@domain.ext)", result);
        
        if (result.hasErrors()) {
            throw new IllegalArgumentException("Student validation failed:\n" + result.getErrorsAsString());
        }
    }
    
    /**
     * Enhanced course data validation with detailed error reporting
     * @param code course code
     * @param title course title
     * @param credits credit hours
     * @param department department name
     * @throws IllegalArgumentException if validation fails
     */
    public static void validateCourseData(String code, String title, int credits, String department) {
        ValidationResult result = new ValidationResult();
        
        // Validate course code with enhanced pattern
        if (!Validator.isValidCourseCode(code)) {
            result.addError("Course Code", "Invalid format (expected: 2-4 uppercase letters followed by 3-4 digits, e.g., CS101 or MATH1001)");
        }
        
        validateField(title, "Course Title", Validator::isNonEmpty, result);
        validateField(department, "Department", Validator::isNonEmpty, result);
        
        // Validate credits with specific range
        if (!Validator.isValidCredits(credits)) {
            result.addError("Credits", "Must be between 1 and 6, but was " + credits);
        }
        
        if (result.hasErrors()) {
            throw new IllegalArgumentException("Course validation failed:\n" + result.getErrorsAsString());
        }
    }
    
    /**
     * Validates enrollment data
     * @param studentRegNo student registration number
     * @param courseCode course code
     * @param marks marks (if provided)
     * @throws IllegalArgumentException if validation fails
     */
    public static void validateEnrollmentData(String studentRegNo, String courseCode, Integer marks) {
        ValidationResult result = new ValidationResult();
        
        validateField(studentRegNo, "Student Registration Number", Validator::isValidRegNo, result);
        validateField(courseCode, "Course Code", Validator::isValidCourseCode, result);
        
        if (marks != null && !Validator.isValidMarks(marks)) {
            result.addError("Marks", "Must be between 0 and 100, but was " + marks);
        }
        
        if (result.hasErrors()) {
            throw new IllegalArgumentException("Enrollment validation failed:\n" + result.getErrorsAsString());
        }
    }
    
    /**
     * Generic field validation helper
     * @param value the value to validate
     * @param fieldName the name of the field
     * @param validator the validation function
     * @param result the validation result accumulator
     */
    private static void validateField(String value, String fieldName, Function<String, Boolean> validator, 
                                     ValidationResult result) {
        if (!validator.apply(value)) {
            result.addError(fieldName, "is required and cannot be empty");
        }
    }
    
    /**
     * Field validation with custom error message
     * @param value the value to validate
     * @param fieldName the name of the field
     * @param validator the validation function
     * @param errorMessage the custom error message
     * @param result the validation result accumulator
     */
    private static void validateField(String value, String fieldName, Function<String, Boolean> validator, 
                                     String errorMessage, ValidationResult result) {
        if (!validator.apply(value)) {
            result.addError(fieldName, errorMessage);
        }
    }
    
    /**
     * Inner class to hold error information
     */
    private static class ErrorInfo {
        final String prefix;
        final Level level;
        
        ErrorInfo(String prefix, Level level) {
            this.prefix = prefix;
            this.level = level;
        }
    }
    
    /**
     * Helper class to accumulate validation errors
     */
    private static class ValidationResult {
        private final StringBuilder errors = new StringBuilder();
        private int errorCount = 0;
        
        void addError(String fieldName, String message) {
            if (errorCount > 0) {
                errors.append("\n");
            }
            errors.append("  • ").append(fieldName).append(": ").append(message);
            errorCount++;
        }
        
        boolean hasErrors() {
            return errorCount > 0;
        }
        
        String getErrorsAsString() {
            return errors.toString();
        }
    }
}
