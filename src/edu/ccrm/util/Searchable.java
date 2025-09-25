package edu.ccrm.util;

import java.util.List;
import java.util.function.Predicate;

/**
 * Generic interface for searchable collections using functional predicates.
 * 
 * This interface provides a unified way to search through collections
 * using lambda expressions and method references for filtering criteria.
 * 
 * @param <T> the type of objects that can be searched
 */
public interface Searchable<T> {
    
    /**
     * Searches the collection for items matching the given predicate
     * 
     * @param predicate the condition to match items against
     * @return list of items that match the predicate, empty list if none found
     * @throws IllegalArgumentException if predicate is null
     */
    List<T> search(Predicate<T> predicate);
}
