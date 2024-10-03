package structures;
 /**
     * The CustomArrayList class represents an array which has no upper capacity.
     * It is resized to double its capacity everytime it is full. 
     * @param <E> The type of element stored in the array list.
     */
public class CustomArrayList<E> {

    public Object[] array; //The array in which all elements are stored.
    private int size;      //The total number of elements in the arraylist.
    private int capacity;  //The maximum number of elements to be able to be stored in the current array.
    
     /**
     * Initializes a new empty array list with a capacity of 100.
     * @return CustomArrayList<E> of capacity 100
     */
    public CustomArrayList() {
        this.capacity = 100;
        this.array = new Object[capacity];
        this.size = 0;
    }
    
    /**
     * Initializes a new empty array list with a capacity of n.
     * @param n The capacity of the array
     * @return CustomArrayList<E> of capacity n
     */
    public CustomArrayList(int n) {
        this.capacity = n;
        this.array = new Object[n];
        this.size = 0;
    }

    /**
    Adds the specified element to this dynamic array.
     
    @param element the element to be added
    */
    public void add(E element) {
        
       // Check if the current size of the array is equal to the capacity.
    if (this.size >= this.capacity) {
        // If the size is equal to the capacity, double the capacity.
        this.capacity = (capacity * 2);
            // Create a new array with the doubled capacity.
            Object[] tmp = new Object[this.capacity];
            // Copy the elements from the old array to the new array.
            for (int i = 0; i < this.size; i++) {
                tmp[i] = this.array[i];
        }        
        this.array = tmp; // Set the old array to the new array.
    }
    // Add the element to the array.
    this.array[size] = element;
    // Increment the size value of the array list.
    this.size++;    
    }

    /**

    Returns true if this ArrayList contains the specified element.
    @param element the element to be checked for presence in this ArrayList.
    @return true if this ArrayList contains the specified element, false otherwise.
    */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(this.array[i])) {return true;}
        }
        return false;
    }
    
    /**Returns how many elements are in the array
     * 
     * @return the size of the array
     */
    public int size() {
        return size;
    }

    /**

    Returns the ArrayList as an Object[] Array.
    @return the Object[] array.
    */
    public Object[] toArray() {
        
        Object[] returnArray = new Object[size];
        for (int i = 0; i < this.size; i++) {
            returnArray[i] = array[i];
        }    
        return returnArray;
    }

    @SuppressWarnings("unchecked") 
    public E get(int index) {
        return (E) this.array[index];
    }

    /**Sets the value of the given index to the new value.
     * 
     * @param index The given index to store the value
     * @param value The value to be stored
     */
    public void set(int index, E value) {
        array[index] = value;
    }

    /**
     * Sets the element at the given index to null and returns 
     * the previous value stored at the index
     * @param index the index of the element to be null
     * @return the value stored previously at the index
     */
    public E remove(int index) {
        //Grab the value of the element before setting it to null
        E temp = (E)array[index];
        array[index] = null;
        //Return the value
        return temp;
    }
    
    /**
     * Returns true if the array list has no elements in it.
     * @return true if the array list has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
}
