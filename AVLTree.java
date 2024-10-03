package structures;
import java.util.Calendar;
/**

The AVLTree class represents an AVL tree data structure.

@param <K> the type of the key
@param <V> the type of the value
*/
public class AVLTree<K extends Comparable<K>, V> {

    /** How many nodes are in the AVL tree. */
    private int size;
    
    /** The root node of the AVL tree. */
    Node<K, V> root;
    
    /**
    Constructs a new AVLTree object of size 0 and a root node of null.
    */
    public AVLTree() {
    this.size = 0;
    this.root = root;
    }
    
    /**
    Retrieves the value associated with the specified key in the binary search tree.
 
    @param key the key to retrieve the value for
    @return the value associated with the key, or null if the key is not found in the tree
 */
    public V getValueByKey(K key) {
        Node<K, V> current = root;
        while (current != null) {
            if (current.key.compareTo(key)==0) {
               break;
            }
            current = current.key.compareTo(key)<0 ? current.right : current.left;
        }
        return (V)current.getValue();
    }

    /** Call private insert method on root
     */
    public void insert(K key, V value) {
        if (key==null) return;
        root = insert(root, key, value);
    }

    /** Call private delete method on root
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    /** returns the the root
     */
    public Node getRoot() {
        return root;
    }

    /** returns the the size
     */
    public int size() {
        return size;
    }

    /** returns the the height, -1 if root is null.
     * 
     * @return height or -1 if root is null
     */ 
    public int height() {
        return root == null ? -1 : root.height;
    }
    /**
     Inserts a new node with the specified key-value pair into the AVL tree rooted at the given node.
     If the key already exists in the tree, updates the value associated with the key.
    
     @param node the root node of the AVL tree to insert into
     @param key the key of the new node to insert
     @param value the value of the new node to insert
     @return the new root node of the AVL tree after inserting the new node and rebalancing
     */
    public Node insert(Node node, K key, V value) {
        
        if (node == null) {
            size++;
            return new Node(key, value);
        } else if (node.key.compareTo(key) >= 0) {
            node.left = insert(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key, value);
        }
        return rebalance(node);
    }

    /**

    Deletes a node with the specified key from the AVL tree.
    @param node the root of the subtree to be searched
    @param key the key of the node to be deleted
    @return the root of the subtree after the node has been deleted
    */
    public Node delete(Node<K,V> node, K key) {
        if (node == null) {  // If the subtree is empty, return null
            return node; 
        } else if (node.key.compareTo(key) > 0) {   // If the key is smaller than the current node's key, go to the left subtree
            node.left = delete(node.left, key); 
        } else if (node.key.compareTo(key) < 0) {   // If the key is greater than the current node's key, go to the right subtree
            node.right = delete(node.right, key);
        } else {                                    // We have reached the node for deletion 
            if (node.left == null || node.right == null) { //If only one child node if present, it assumes the position of the current node
                node = (node.left == null) ? node.right : node.left; 
                size--;
            } else {                                //If two childen are present, the leftmostchild in the right subtree assumes the position of the current node
                Node<K, V> mostLeftChild = mostLeftChild(node.right); 
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
                size--;
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        
        return node;
    }

    /**
    Returns the leftmost child of a given node.
    @param node the node whose leftmost child is to be found
    @return the leftmost child of the given node
    */
    private Node mostLeftChild(Node<K, V> node) { 
        Node<K, V> current = node;
        // loop down to find the leftmost child
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Rebalances the AVL tree rooted at the specified node.
     * 
     * @param z the node to rebalance
     * @return the new root node of the rebalanced subtree
 */
    private Node rebalance(Node<K, V> z) {
        updateHeight(z);  // update the height of the current node
        int balance = getBalance(z);  // calculate the balance factor of the current node
        if (balance > 1) {  // If the tree is right-heavy, 
            if (height(z.right.right) > height(z.right.left)) {  // case RR: The right subtree of the right child is taller than the left subtree of the right child.
                z = rotateLeft(z);                                  // rotate left around the current node to balance the subtree
            } else {                                             // case RL: The left subtree of the right child is taller than the right subtree of the right child.
                z.right = rotateRight(z.right);                     // rotate right around the right child of the current node
                z = rotateLeft(z);                                  // rotate left around the current node to balance the subtree
            }
        } else if (balance < -1) {  // the tree is left-heavy
            if (height(z.left.left) > height(z.left.right)) {  // case LL: The left subtree of the left child is taller than the right subtree of the left child.
                z = rotateRight(z);                                 // rotate right around the current node to balance the subtree
            } else {                                           // case LR: The right subtree of the left child is taller than the left subtree of the left child.
                z.left = rotateLeft(z.left);                        // rotate left around the left child of the current node
                z = rotateRight(z);                                 // rotate right around the current node to balance the subtree
            }
        }
        return z;  // return the new root node of the rebalanced subtree
}
  /**

    Rotates the subtree rooted at node y to the right.
    @param y the root node of the subtree to be rotated
    @return the new root node of the rotated subtree
*/
    private Node rotateRight(Node y) {
        Node<K, V> x = y.left; // get the left child of the node to be rotated y
        Node<K, V> z = x.right;// get the right child of the node x
        x.right = y; // make y the right child of x
        y.left = z; // make z the left child of y
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**

    Rotates the subtree rooted at node y to the left.
    @param y the root node of the subtree to be rotated
    @return the new root node of the rotated subtree
*/
    private Node rotateLeft(Node y) {
        Node<K, V> x = y.right; // get the right child of the node to be rotated y
        Node<K, V> z = x.left; // get the left child of the node x
        x.left = y; // make y the left child of x
        y.right = z; // make z the right child of y
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**

    Update the height of a given node based on the heights of its left and right subtrees.
    If the given node is null, do nothing.
    @param n the node to update the height of
    */
    private void updateHeight(Node<K, V> n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }
    /**

    Returns the height of the given node in the AVL tree.
    If the node is null, returns -1.
    @param n the node whose height is to be determined
    @return the height of the node or -1 if the node is null
    */
    private int height(Node<K, V> n) {
        return n == null ? -1 : n.height;
    }


  
  /**
Calculates the balance factor of a given node in an AVL tree.
@param n the node for which to calculate the balance factor
@return the balance factor of the node; a positive value indicates that the node is right-heavy,
        a negative value indicates that the node is left-heavy, and zero indicates that the node
        is balanced.
*/
    public int getBalance(Node<K, V> n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    /**
     * Calls the private method inOrderList and returns the result as an array
     * @return array of values in order
     */
    public Object[] inOrderArray() {
        CustomArrayList<V> list = new CustomArrayList(10);
        Object[] array = inOrderList(root, list).toArray();
        return array;
    }

    /**
     * Adds all nodes in the tree to the given list in order and returns the result
     * @return arraylist of values in order
     */
    private CustomArrayList<V> inOrderList(Node<K, V> n, CustomArrayList<V> list) {
        if (n != null) {
            inOrderList(n.left, list);
            list.add(n.value);
            inOrderList(n.right, list);
        }
        return list;
    }

    /**
     * Calls the private method inOrderList and returns the result as an array
     * @return array of values in order
     */
    public Object[] getValuesBetween(K start, K end) {
        return getValuesBetween(root, start, end).toArray();
    }

    private CustomArrayList<Object> getValuesBetween(Node<K, V> node, K start, K end) {

        //A list of nodes which have been found between start and end via recursion.
        CustomArrayList<Object> NodeArray = new CustomArrayList(10);
        //If we have reached a null node, return the empty UID array.
        if (node == null) {
            return NodeArray;
        }
        //If the key of our node is larger than the start value, then we will perform recursion on this node. 
        if (start.compareTo(node.key) < 0) { //start < node.key 

            //Perform recursion on the left child and add all correct nodes to our nodeArray.
            CustomArrayList<Object> newNodes = getValuesBetween(node.left, start, end);

            for (int i = 0; i < newNodes.size(); i++) {
                if (newNodes.get(i) != null) NodeArray.add(newNodes.get(i));
            }
            
            
        }
        //If the node key is between the start and end, add it to the NodeArray.
        if (start.compareTo(node.key) < 0 && node.key.compareTo(end) < 0) { 
            NodeArray.add(node.getValue());  
        }

        if (end.compareTo(node.key) > 0) { //end > node.key // If the key of our node is smaller than the end value, then we will perform recursion on this node. 

            //Perform recursion on the left child and add all correct nodes to our nodeArray
            CustomArrayList<Object> newNodes = getValuesBetween(node.right, start, end);
            for (int i = 0; i < newNodes.size(); i++) {
                if (newNodes.get(i) != null) NodeArray.add(newNodes.get(i));
            }
        }
        
        return NodeArray;

        
    }
    


    


}