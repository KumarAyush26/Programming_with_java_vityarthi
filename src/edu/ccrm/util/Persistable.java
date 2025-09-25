package edu.ccrm.util;

/**
 * Interface for objects that can be serialized to and deserialized from string format.
 * This provides a simple persistence mechanism for domain objects.
 * 
 * Implementations should ensure that:
 * - serialize() produces a string that can be fully reconstructed via deserialize()
 * - deserialize() properly handles malformed input gracefully
 * - The serialization format is consistent and versioned if needed
 */
public interface Persistable {
    
    /**
     * Serializes the object to a string representation
     * @return string representation of the object
     */
    String serialize();
    
    /**
     * Deserializes object state from a string representation
     * @param data the string data to deserialize from
     * @throws IllegalArgumentException if data format is invalid
     */
    void deserialize(String data);
}
