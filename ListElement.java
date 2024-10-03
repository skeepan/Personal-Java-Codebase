package structures;
/**
 * The ListElement class is used as a node which
 * stores a value and points to the next and previous nodes in a list. It is used
 * to iterate through and manipulate the list. 
 * 
 * @param <E> Type of element in list.
 */
public class ListElement<E> {
    private final E value;          //The value stored in the list element
    private ListElement<E> next;    //Pointer to the next list element in the list.
    private ListElement<E> prev;    //Poointer to the previosu element in the list. 

    /**Initializes a ListElement with a given value. 
     * 
     * @param value The given value we want to add to the list
     */
    public ListElement(E value) {
        this.value = value;
    }
    
    /**
     * Returns the value stored in the list element
     * 
     * @return the value stored in the list element
     */
    public E getValue() {
        return this.value;
    }
    
    /**
     * Returns the next element in the list.
     *
     * @return the next element in the list
     */
    public ListElement<E> getNext() {
        return this.next;
    }
    
    /**
     * Returns the previous element in the list.
     *
     * @return the previous element in the list
     */
    public ListElement<E> getPrev() {
        return this.prev;
    }

    /**
     * Sets the next element in the list.
     *
     * @param e the element to set as the next element
     */
    public void setNext(ListElement<E> e) {
        this.next = e;
    }

    /**
     * Sets the previous element in the list.
     *
     * @param e the element to set as the previous element
     */
    public void setPrev(ListElement<E> e) {
        this.prev = e;
    }


    }
