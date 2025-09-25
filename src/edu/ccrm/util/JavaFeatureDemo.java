package edu.ccrm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Optimized demonstration class showcasing comprehensive Java language features,
 * best practices, and modern programming techniques.
 * 
 * This class serves as an educational resource covering:
 * - Operator precedence and expressions
 * - All loop constructs and control flow
 * - Exception handling and assertions
 * - Lambda expressions and functional interfaces
 * - Stream API operations
 * - Modern Java features and patterns
 */
public final class JavaFeatureDemo {
    
    /**
     * Demonstrates operator precedence
     * Order: 
     * 1. () parentheses
     * 2. * / multiplication and division
     * 3. + - addition and subtraction
     * 4. &amp;&amp; logical AND
     * 5. || logical OR
     */
    public static int operatorPrecedenceDemo(int a, int b, int c) {
        // Without parentheses: multiplication happens before addition
        int result1 = a + b * c;        // Example: 1 + 2 * 3 = 7 (not 9)
        
        // With parentheses: addition happens first
        int result2 = (a + b) * c;      // Example: (1 + 2) * 3 = 9
        
        // Complex expression with multiple operators
        boolean complex = a > 0 && b > 0 || c > 0;  // AND evaluated before OR
        
        return complex ? result1 : result2;
    }

    /**
     * Demonstrates all loop types and a labeled break
     */
    public static void loopDemo(int[][] matrix) {
        // Traditional for loop with counter
        for (int i = 0; i < 10; i++) {
            if (i == 5) continue; // Skip 5
            System.out.println("Counter: " + i);
        }

        // Enhanced for loop (for-each)
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        // While loop
        int whileCounter = 0;
        while (whileCounter < 5) {
            System.out.println("While: " + whileCounter++);
        }

        // Do-while loop
        int doCounter = 0;
        do {
            System.out.println("Do-while: " + doCounter++);
        } while (doCounter < 3);

        // Labeled break example
        outerLoop: 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    System.out.println("Found -1 at position: " + i + "," + j);
                    break outerLoop; // Breaks both loops
                }
            }
        }
    }

    /**
     * Demonstrates assertions for validation
     */
    public static double calculateAverage(int[] numbers) {
        // Pre-condition
        assert numbers != null : "Input array cannot be null";
        assert numbers.length > 0 : "Input array cannot be empty";

        double sum = 0;
        for (int num : numbers) {
            // Invariant
            assert num >= 0 : "Numbers must be non-negative";
            sum += num;
        }

        double average = sum / numbers.length;
        
        // Post-condition
        assert average >= 0 : "Average must be non-negative";
        return average;
    }

    /**
     * Demonstrates anonymous inner class and lambda expressions
     */
    public static List<String> sortAndFilterStrings(List<String> input) {
        // Anonymous inner class implementation of Comparator
        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        // Lambda expression implementation of Predicate
        Predicate<String> nonEmptyFilter = s -> !s.trim().isEmpty();

        List<String> result = new ArrayList<>(input);
        result.sort(lengthComparator);
        result.removeIf(s -> !nonEmptyFilter.test(s));
        return result;
    }

    /**
     * Demonstrates Java Stream API with various operations
     */
    public static void streamApiDemo() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter, map, and collect
        List<String> evenSquares = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .map(Object::toString)
            .collect(Collectors.toList());
        
        System.out.println("Even squares: " + evenSquares);
        
        // Reduce operation
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        // Grouping and partitioning
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned: " + partitioned);
    }

    /**
     * Demonstrates method references and functional interfaces
     */
    public static void functionalInterfaceDemo() {
        List<String> words = Arrays.asList("Java", "Stream", "Lambda", "Method", "Reference");
        
        // Method reference examples
        words.forEach(System.out::println);  // Method reference to instance method
        
        List<String> upperCase = words.stream()
            .map(String::toUpperCase)  // Method reference to instance method of arbitrary object
            .collect(Collectors.toList());
        
        System.out.println("Uppercase: " + upperCase);
        
        // Constructor reference
        List<StringBuilder> builders = words.stream()
            .map(StringBuilder::new)
            .collect(Collectors.toList());
        
        System.out.println("StringBuilder count: " + builders.size());
    }

    /**
     * Demonstrates exception handling with try-with-resources
     */
    public static void tryWithResourcesDemo() {
        // Simulated resource that implements AutoCloseable
        class MockResource implements AutoCloseable {
            private final String name;
            
            MockResource(String name) {
                this.name = name;
                System.out.println("Opening resource: " + name);
            }
            
            void doWork() {
                System.out.println("Working with resource: " + name);
            }
            
            @Override
            public void close() {
                System.out.println("Closing resource: " + name);
            }
        }
        
        // Try-with-resources automatically closes resources
        try (MockResource resource1 = new MockResource("Resource1");
             MockResource resource2 = new MockResource("Resource2")) {
            
            resource1.doWork();
            resource2.doWork();
            
        } catch (Exception e) {
            System.err.println("Error in try-with-resources: " + e.getMessage());
        }
    }

    /**
     * Demonstrates Optional usage patterns
     */
    public static void optionalDemo() {
        List<String> names = Arrays.asList("Alice", null, "Bob", "", "Charlie");
        
        // Using Optional to handle null values safely
        List<String> validNames = names.stream()
            .filter(Objects::nonNull)
            .filter(name -> !name.trim().isEmpty())
            .collect(Collectors.toList());
        
        // Optional with method chaining
        Optional<String> longest = validNames.stream()
            .max(Comparator.comparing(String::length));
        
        longest.ifPresentOrElse(
            name -> System.out.println("Longest name: " + name),
            () -> System.out.println("No valid names found")
        );
        
        // Optional with default values
        String defaultName = Optional.<String>ofNullable(null)
            .orElse("Default Name");
        System.out.println("Default name: " + defaultName);
    }
    
    // Private constructor to prevent instantiation
    private JavaFeatureDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        System.out.println("=== Java Feature Demonstrations ===\n");
        
        // Operator precedence demo
        System.out.println("1. Operator Precedence Demo:");
        System.out.println("Result: " + operatorPrecedenceDemo(1, 2, 3));
        System.out.println();

        // Loop demo
        System.out.println("2. Loop Constructs Demo:");
        int[][] matrix = {{1, 2}, {3, -1}, {5, 6}};
        loopDemo(matrix);
        System.out.println();

        // Assertions demo (run with -ea flag)
        System.out.println("3. Assertions Demo:");
        try {
            double avg = calculateAverage(new int[]{1, 2, 3, 4, 5});
            System.out.println("Average: " + avg);
        } catch (AssertionError e) {
            System.err.println("Assertion failed: " + e.getMessage());
        }
        System.out.println();

        // Anonymous class and lambda demo
        System.out.println("4. Lambda Expressions Demo:");
        List<String> strings = Arrays.asList("Hello", "", "World", "  ", "Java");
        List<String> filtered = sortAndFilterStrings(strings);
        System.out.println("Filtered and sorted: " + filtered);
        System.out.println();
        
        // Stream API demo
        System.out.println("5. Stream API Demo:");
        streamApiDemo();
        System.out.println();
        
        // Functional interface demo
        System.out.println("6. Functional Interface Demo:");
        functionalInterfaceDemo();
        System.out.println();
        
        // Try-with-resources demo
        System.out.println("7. Try-with-Resources Demo:");
        tryWithResourcesDemo();
        System.out.println();
        
        // Optional demo
        System.out.println("8. Optional Demo:");
        optionalDemo();
        System.out.println();
        
        System.out.println("=== All demonstrations completed ===");
    }
}
