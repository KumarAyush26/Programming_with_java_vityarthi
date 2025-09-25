import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * TestRegex - Comprehensive Regular Expression Testing Utility
 * 
 * This class demonstrates regex pattern validation for student registration numbers
 * in the Campus Course & Records Manager (CCRM) system.
 * 
 * Registration Number Format:
 * - 2-3 uppercase letters (department code)
 * - Exactly 6 digits (student ID)
 * - Examples: CS123456, CSE123456, IT789012
 * 
 * @author CCRM Development Team
 * @version 2.0
 * @since Java 17
 */
public class TestRegex {
    
    // Pre-compiled regex pattern for better performance
    private static final Pattern REG_NO_PATTERN = Pattern.compile("^[A-Z]{2,3}\\d{6}$");
    
    // Test cases with expected results
    private static final TestCase[] TEST_CASES = {
        // Valid cases
        new TestCase("CS123456", true, "Valid: 2 letters + 6 digits"),
        new TestCase("CSE123456", true, "Valid: 3 letters + 6 digits"),
        new TestCase("IT789012", true, "Valid: IT department code"),
        new TestCase("ECE456789", true, "Valid: ECE department code"),
        
        // Invalid cases - Wrong digit count
        new TestCase("CSE10789", false, "Invalid: Only 5 digits"),
        new TestCase("CS12345", false, "Invalid: Only 5 digits"),
        new TestCase("CSE1234567", false, "Invalid: 7 digits"),
        new TestCase("CS12345678", false, "Invalid: 8 digits"),
        
        // Invalid cases - Wrong letter count
        new TestCase("C123456", false, "Invalid: Only 1 letter"),
        new TestCase("CSED123456", false, "Invalid: 4 letters"),
        new TestCase("COMPUTER123456", false, "Invalid: Too many letters"),
        
        // Invalid cases - Wrong format
        new TestCase("cse123456", false, "Invalid: Lowercase letters"),
        new TestCase("CS12A456", false, "Invalid: Letter in digits"),
        new TestCase("123456CS", false, "Invalid: Numbers first"),
        new TestCase("CS-123456", false, "Invalid: Contains hyphen"),
        new TestCase("CS 123456", false, "Invalid: Contains space"),
        
        // Edge cases
        new TestCase("", false, "Invalid: Empty string"),
        new TestCase(null, false, "Invalid: Null value"),
        new TestCase("CS", false, "Invalid: Too short"),
        new TestCase("CS000000", true, "Valid: Leading zeros allowed")
    };
    
    /**
     * Main method - Executes comprehensive regex testing
     * 
     * Tests various registration number formats and displays results
     * with detailed explanations and statistics.
     */
    public static void main(String[] args) {
        System.out.println("================================================================");
        System.out.println("         CCRM Registration Number Regex Tester v2.0           ");
        System.out.println("================================================================");
        System.out.println();
        
        System.out.println("Pattern: " + REG_NO_PATTERN.pattern());
        System.out.println("Format: [A-Z]{2,3}\\d{6} (2-3 uppercase letters + 6 digits)");
        System.out.println();
        System.out.println("Running " + TEST_CASES.length + " test cases...");
        System.out.println("================================================================");
        
        int passed = 0;
        int failed = 0;
        
        for (int i = 0; i < TEST_CASES.length; i++) {
            TestCase testCase = TEST_CASES[i];
            boolean actualResult = validateRegistrationNumber(testCase.input);
            boolean testPassed = actualResult == testCase.expected;
            
            // Display test result
            String status = testPassed ? "PASS" : "FAIL";
            String resultIcon = actualResult ? "TRUE " : "FALSE";
            String inputDisplay = testCase.input == null ? "null" : "\"" + testCase.input + "\"";
            
            System.out.printf("Test %2d: %-12s -> %s [%s] | %s%n", 
                i + 1, inputDisplay, resultIcon, status, testCase.description);
            
            if (testPassed) {
                passed++;
            } else {
                failed++;
                System.out.println("    Expected: " + testCase.expected + ", Got: " + actualResult);
            }
        }
        
        System.out.println("================================================================");
        
        // Display test statistics
        System.out.println("TEST RESULTS SUMMARY:");
        System.out.println("   Passed: " + passed + "/" + TEST_CASES.length);
        System.out.println("   Failed: " + failed + "/" + TEST_CASES.length);
        System.out.printf("   Success Rate: %.1f%%%n", (passed * 100.0 / TEST_CASES.length));
        
        if (failed == 0) {
            System.out.println("   ALL TESTS PASSED! Regex pattern is working correctly.");
        } else {
            System.out.println("   Some tests failed. Please review the regex pattern.");
        }
        
        System.out.println();
        System.out.println("Usage Example:");
        System.out.println("   if (REG_NO_PATTERN.matcher(regNo).matches()) {");
        System.out.println("       // Valid registration number");
        System.out.println("   }");
    }
    
    /**
     * Validates a registration number using the compiled pattern
     * 
     * @param regNo The registration number to validate (can be null)
     * @return true if the registration number matches the pattern, false otherwise
     */
    private static boolean validateRegistrationNumber(String regNo) {
        try {
            return regNo != null && REG_NO_PATTERN.matcher(regNo).matches();
        } catch (PatternSyntaxException e) {
            System.err.println("Pattern syntax error: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Test case data structure
     * 
     * Encapsulates test input, expected result, and description
     * for comprehensive testing scenarios.
     */
    private static class TestCase {
        final String input;
        final boolean expected;
        final String description;
        
        TestCase(String input, boolean expected, String description) {
            this.input = input;
            this.expected = expected;
            this.description = description;
        }
    }
}
