
package structures;
/**

The Node class represents a node in our AVL Tree.

@param <K> the type of the key

@param <V> the type of the value
*/
public class Node<K extends Comparable<K>, V> {

    /** The key of the node. */
    K key;
    
    /** The height of the node. */
    int height;
    
    /** The value of the node. */
    V value;
    
    /** The parent of the node. */
    Node<K, V> parent;
    
    /** The left child of the node. */
    Node<K, V> left;
    
    /** The right child of the node. */
    Node<K, V> right;
    
    /**
    
    Constructs a new Node object with the specified key and value.
    @param key the key of the node
    @param value the value of the node
    */
    Node(K key, V value) {
    this.key = key;
    this.value = value;
    }
    /**
    
    Returns the value of the node.
    @return the value of the node
    */
    public V getValue() {
    return this.value;
    }
    }
    
    // Note: This Node class is used to represent a node in a binary search tree.
    // It contains fields for the key, height, value, parent, left child, and right child of the node. 
    // The key is of a generic type parameter K that extends the Comparable interface, 
    // and the value is of a generic type parameter V. The Node class has a constructor that 
    // takes a key and value as arguments, and a getValue() method that returns the value of the node.