public class BST {

    // Initialize a Node 
    class Node {

        Integer key;
        Node left, right;

        public Node (Integer key) {
            this.key = key;
            this.left = this.right = null;
        }

    }

    Node root = null; // Just declare it, don't initialize it to a new Node

    public void insert (Integer key) {
        root = insertRec(root, key);
    }

    private Node insertRec (Node x, Integer key) {
        if (x == null) {
            return new Node(key);
        }
        
        int cmp = key.compareTo(x.key);

        // key < x.key
        if (cmp < 0) {
            x.left = insertRec(x.left, key);
        }
        // key > x.key
        else if (cmp > 0) {
            x.right = insertRec(x.right, key);
        }
        else {
            x.key = key;
        }
        
        // Base case 
        return x;
    }

    // Pre-order code
    public void NLR () {
        NLR(this.root);
    }

    public void NLR (Node x) {
        if (x == null) {
            return ;
        }

        System.out.print(x.key + " ");
        NLR(x.left);
        NLR(x.right);
    }

    // In-order code
    public void LNR () {
        LNR(this.root);
    }

    public void LNR (Node x) {
        
        if (x == null) {
            return ;
        }

        NLR(x.left);
        System.out.print(x.key + " ");
        NLR(x.right);
    }

    // Post-order code
    public void LRN () {
        LRN(this.root);
    }

    public void LRN (Node x) {
        if (x == null) {
            return ;
        }

        LRN(x.left);
        LRN(x.right);
        System.out.print(x.key + " ");
    }

    // Search a key from Tree code
    public Integer search (Integer key) {
        Node result = search(root, key);
        return result != null ? result.key : null;
    }

    private Node search (Node x, Integer key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return search(x.left, key);
        }
        else if (cmp > 0) {
            return search(x.right, key);
        }
        else 
            return x;
    }

    // Find the min value
    public Integer min () {
        Node minKey = min (root);
        return minKey != null ? minKey.key : null;
    }

    private Node min (Node x) {
        if (x.left == null) {
            return x;
        }
        else 
            return min (x.left);
    }

    // Fine the max value
    public Integer max () {
        Node maxKey = max (root);
        return maxKey != null ? maxKey.key : null;
    }


    private Node max (Node x) {
        if (x.right == null) {
            return x;
        }
        else 
            return max (x.right);
    }

    // Delete the min Node
    public void deleteMin () {
        deleteMin(root);
    }

    private Node deleteMin (Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin (x.left);
        return x;
    }

    // Delete a Node 
    public Integer delete (Integer key) {
        Node delNode = delete(root, key);
        return delNode != null ? delNode.key : null;
    }


    private Node delete(Node x, Integer key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        // Searching the position of key deleted
        if (cmp < 0) {
            x.left = delete(x.left, key);
        }
        else if (cmp > 0) {
            x.right = delete(x.right, key);
        }
        else {
            // node with no child
            if (x.right == null && x.left == null) {
                return x;
            }
            // node with only one child
            else if (x.right == null) {
                return x.left;
            }
            else if (x.left == null) {
                return x.right;            
            }
            // node with two children.
            else {

                Node t = x; // E
                x = min(t.right); // H
                x.right = deleteMin(t.right); // update & delete the min node (dulplicate of min Node) of right
                x.left = t.left;

            }
        }
        return x;
    }

    // Exercise 4: Decending order
    public void RNL () {
        RNL(this.root);
    }

    public void RNL (Node x) {
        
        if (x == null) {
            return ;
        }

        RNL(x.right);
        System.out.print(x.key + " ");
        RNL(x.left);
    }

    // Exercise 5: if whether it contains in the tree.
    public boolean contains(Integer key) {
        return search(root, key) != null;
    }

    // Exercise 6: Delete the max value
    public void deleteMax () {
        deleteMax(root);
    }

    private Node deleteMax (Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        return x;
    }

    // Exercise 7: delete a Node by using a predecessor (maximum node in the left) 
    public void delete_pre (Integer key) {
        root = delete_pre(root, key);
    }

    private Node delete_pre (Node x, Integer key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete_pre(x.right, key);
        }
        else if (cmp < 0) {
            x.left = delete_pre(x.left, key);
        }
        else {
            
            if (x.right == null && x.left == null) {
                return null;
            }
            else if (x.right == null) {
                return x.left;
            }
            else if (x.left == null) {
                return x.right;
            }
            else {
                Node t = x;
                x = max(t.left);
                x.left = deleteMax(t.left);
                x.right = t.right;
            }
        }
        return x;
    }
    
    // Exercise 8: find the height
    public int height () {
        return height(root);
    }

    private int height(Node x) {

        if (root == null) return -1;
        
        int lefth = height(x.left);
        int righth = height(x.right);

        return lefth > righth ? lefth + 1 : righth + 1;
    }
}