package edu.ccrm.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Optimized utility class for recursive file system operations with enhanced functionality,
 * error handling, and performance improvements.
 */
public final class RecursionUtils {
    
    private static final Logger LOGGER = Logger.getLogger(RecursionUtils.class.getName());
    private static final String INDENT_UNIT = "  "; // Two spaces for indentation
    private static final int MAX_RECURSION_DEPTH = 50; // Prevent stack overflow
    
    // Private constructor to prevent instantiation
    private RecursionUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Recursively print all files and directories by depth with improved formatting
     * @param dir the directory to start from
     * @param depth the current depth level
     */
    public static void printFilesByDepth(Path dir, int depth) {
        printFilesByDepthWithFilter(dir, depth, path -> true);
    }
    
    /**
     * Recursively print files and directories with a filter predicate
     * @param dir the directory to start from
     * @param depth the current depth level
     * @param filter predicate to filter which paths to include
     */
    public static void printFilesByDepthWithFilter(Path dir, int depth, Predicate<Path> filter) {
        if (depth < 0 || depth > MAX_RECURSION_DEPTH) {
            LOGGER.warning("Invalid or excessive recursion depth: " + depth);
            return;
        }
        
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            LOGGER.warning("Path does not exist or is not a directory: " + dir);
            return;
        }
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (filter.test(path)) {
                    String indent = INDENT_UNIT.repeat(depth);
                    String type = Files.isDirectory(path) ? "📁" : "📄";
                    System.out.printf("%s%s %s%n", indent, type, path.getFileName());
                    
                    if (Files.isDirectory(path)) {
                        printFilesByDepthWithFilter(path, depth + 1, filter);
                    }
                }
            }
        } catch (IOException e) {
            String errorMsg = "Error reading directory: " + dir + " - " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMsg, e);
            System.err.println(errorMsg);
        }
    }
    
    /**
     * Recursively compute total number of files in a directory with improved performance
     * @param dir the directory to count files in
     * @return the total number of files
     */
    public static int countFiles(Path dir) {
        return countFilesWithFilter(dir, path -> !Files.isDirectory(path));
    }
    
    /**
     * Recursively count files and directories matching a filter
     * @param dir the directory to start from
     * @param filter predicate to filter which paths to count
     * @return the count of matching paths
     */
    public static int countFilesWithFilter(Path dir, Predicate<Path> filter) {
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            LOGGER.warning("Path does not exist or is not a directory: " + dir);
            return 0;
        }
        
        int count = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (filter.test(path)) {
                    count++;
                }
                if (Files.isDirectory(path)) {
                    count += countFilesWithFilter(path, filter);
                }
            }
        } catch (IOException e) {
            String errorMsg = "Error reading directory: " + dir + " - " + e.getMessage();
            LOGGER.log(Level.SEVERE, errorMsg, e);
            System.err.println(errorMsg);
        }
        return count;
    }
    
    /**
     * Recursively find all files with a specific extension
     * @param dir the directory to search in
     * @param extension the file extension to search for (without dot)
     * @return list of paths matching the extension
     */
    public static List<Path> findFilesByExtension(Path dir, String extension) {
        List<Path> results = new ArrayList<>();
        findFilesByExtensionRecursive(dir, extension.toLowerCase(), results);
        return results;
    }
    
    private static void findFilesByExtensionRecursive(Path dir, String extension, List<Path> results) {
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            return;
        }
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    findFilesByExtensionRecursive(path, extension, results);
                } else {
                    String fileName = path.getFileName().toString().toLowerCase();
                    if (fileName.endsWith("." + extension)) {
                        results.add(path);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Error reading directory: " + dir, e);
        }
    }
    
    /**
     * Calculate the total size of all files in a directory recursively
     * @param dir the directory to calculate size for
     * @return total size in bytes
     */
    public static long calculateDirectorySize(Path dir) {
        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            LOGGER.warning("Path does not exist or is not a directory: " + dir);
            return 0L;
        }
        
        long totalSize = 0L;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    totalSize += calculateDirectorySize(path);
                } else {
                    try {
                        totalSize += Files.size(path);
                    } catch (IOException e) {
                        LOGGER.log(Level.WARNING, "Error getting size for file: " + path, e);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading directory: " + dir, e);
        }
        return totalSize;
    }
    
    /**
     * Find the maximum depth of a directory tree
     * @param dir the directory to analyze
     * @return the maximum depth
     */
    public static int findMaxDepth(Path dir) {
        return findMaxDepthRecursive(dir, 0);
    }
    
    private static int findMaxDepthRecursive(Path dir, int currentDepth) {
        if (!Files.exists(dir) || !Files.isDirectory(dir) || currentDepth > MAX_RECURSION_DEPTH) {
            return currentDepth;
        }
        
        int maxDepth = currentDepth;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    int pathDepth = findMaxDepthRecursive(path, currentDepth + 1);
                    maxDepth = Math.max(maxDepth, pathDepth);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Error reading directory: " + dir, e);
        }
        return maxDepth;
    }
    
    /**
     * Recursively delete a directory and all its contents
     * @param dir the directory to delete
     * @return true if successful, false otherwise
     */
    public static boolean deleteDirectoryRecursively(Path dir) {
        if (!Files.exists(dir)) {
            return true;
        }
        
        try {
            Files.walk(dir)
                 .sorted((path1, path2) -> path2.compareTo(path1)) // Delete children first
                 .forEach(path -> {
                     try {
                         Files.delete(path);
                     } catch (IOException e) {
                         LOGGER.log(Level.WARNING, "Failed to delete: " + path, e);
                     }
                 });
            return true;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error deleting directory: " + dir, e);
            return false;
        }
    }
}
