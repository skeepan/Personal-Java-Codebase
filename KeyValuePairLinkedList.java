package structures;
/**

The KeyValuePairLinkedList class represents a linkedlist bucket used in our Hashmap.
It contains all KeyValuePair objects which have the same hashcode, so that collisions are not a problem.

@param <K> the type of the key
@param <V> the type of the value
*/
public class KeyValuePairLinkedList<K extends Comparable<K>,V> {
    //The first element in the list
    protected ListElement<KeyValuePair<K,V>> head;
    //The number of elements in the list
    protected int size;
    
    /**
     * Initializes a new KVP linked list with a null element of size 0
     * which will be updated when the first element is added.
     */
    public KeyValuePairLinkedList() {
        head = null;
        size = 0;
    }
    
    /** 
     * Creates a KeyValuePair object which stores the key
     * and associated value to be added.
     * Calls the private function add() below which stores the 
     * KVP in the list
     * 
     * @param key the key to be added
     * @param value the value under the key
     */
    public void add(K key, V value) {
        this.add(new KeyValuePair<K,V>(key,value));
    }

    /**
    Adds a new KeyValuePair to the front of this LinkedList.
    @param kvp the KeyValuePair to be added to this LinkedList.
    */
    private void add(KeyValuePair<K,V> kvp) {
        //Create a new ListElement which stores the key-value pair
        ListElement<KeyValuePair<K,V>> new_element = new ListElement<>(kvp);
        //Set the listelement to be the head of the list
        new_element.setNext(head);
        head = new_element;
        size++; //Update the size of the list
    }
    
    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list.
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns the first element in the list.
     * @return the first element in the list.
     */
    public ListElement<KeyValuePair<K,V>> getHead() {
        return head;
    }
    
    /**
     * Returns the key-value pair stored under the key given.
     * @param key the key to get the value of.
     * @return the key-value pair stored under the key given.
     */
    public KeyValuePair<K,V> get(K key) {
        //Create a pointer to iterate through the list
        ListElement<KeyValuePair<K,V>> temp = head;
        //Iterate through the list until the key is found or the pointer has reached the end of the list
        while(temp != null) {
            if(temp.getValue().getKey().equals(key)) { //The key of the current pointer is the key we want
                return temp.getValue(); //Return the key-value pair at this key
            }
            
            temp = temp.getNext(); //Set the pointer to the next list element
        }
        //If the list has reached the end, return null
        return null; 
    }


    /**
    * Removes the KeyValuePair with the specified key from this LinkedList if it is present.
    * @param key the key of the KeyValuePair to be removed from this LinkedList.
    * @return true if the KeyValuePair was removed successfully, false otherwise.
    */
    public boolean remove(K key) {
        // If the LinkedList is empty, return false immediately.
        if (head == null) {
            return false;
        }
        // traverse the LinkedList using two ListElement objects (prev and ptr), 
        // until the key value pair with the specified key is found.
        ListElement<KeyValuePair<K, V>> prev = null;
        ListElement<KeyValuePair<K, V>> ptr = head;
    
        while (ptr != null) { //Iterate through all elements in the list
            KeyValuePair<K, V> pair = ptr.getValue();
            if (pair.getKey().equals(key)) { //The key value pair has been found
                if (prev == null) {          // The first element found has the key we are looking for
                    head = ptr.getNext();       //Set the the second element of the list to the head.
                } else {                     // The element is anywhere else on the list
                    prev.setNext(ptr.getNext());// Set the next reference of prev to the next reference of ptr.
                }
                return true; // Returns true since our value has been found
            }
            //Update the ptr and prev elements to iterate through the list
            prev = ptr;
            ptr = ptr.getNext();
        }
        // Return false if Key is not found
        return false;
    }
}
