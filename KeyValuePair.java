package structures;
/**
 * A generic class representing a key-value pair, where the key is of type K and the value is of type V.
 *
 * @param <K> the type of the key, which must be comparable to other keys of the same type
 * @param <V> the type of the value
 */
public class KeyValuePair<K extends Comparable<K>,V> implements Comparable<KeyValuePair<K,V>> {

    /**
     * The key of this key-value pair.
     */
    protected K key;
    
    /**
     * The value of this key-value pair.
     */
    protected V value;
    
    /**
     * Constructs a new key-value pair with the specified key and value.
     *
     * @param k the key of the pair
     * @param v the value of the pair
     */
    public KeyValuePair(K k, V v) {
        key = k;
        value = v;
    }
    
    /**
     * Returns the key of this key-value pair.
     *
     * @return the key of this key-value pair
     */
    public K getKey() {
        return key;
    }
    
    /**
     * Returns the value of this key-value pair.
     *
     * @return the value of this key-value pair
     */
    public V getValue() {
        return value;
    }

    /**
     * Compares this key-value pair with another key-value pair based on their keys.
     *
     * @param o the other key-value pair to compare this one to
     * @return a negative integer, zero, or a positive integer as this key-value pair is less than, equal to, or greater
     * than the specified key-value pair
     */
    public int compareTo(KeyValuePair<K,V> o) {
        return o.getKey().compareTo(this.getKey());
    }
}
