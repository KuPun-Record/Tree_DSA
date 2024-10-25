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
        if (cmp < 0) {
            x.left = delete(x.left, key);
        }
        else if (cmp > 0) {
            x.right = delete(x.right, key);
        }
        else {
            // node with only one child or not
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;            
            }

            // node with two children: Get the successor (smallest in
            // the right subtree
            Node t = x;
            x = min(t.right);

            // Delete the successor
            x.right =  deleteMin(t.right);

            // Re-link left subtree to the node which was replaced 
            x.left = t.left;

        }
        return x;
    }

    // Exercise 4: decending order
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

    // Exercise 6: delete the max value
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

    // Exercise 7: delete a Node by using a predecessor
    public void delete_pre (Integer key) {
        delete_pre (root, key);
    }


    private Node delete_pre (Node x, Integer key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete_pre(x.left, key);
        }
        else if (cmp > 0) {
            x.right = delete_pre(x.right, key);
        }
        else {
            // node with only one child or not
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;            
            }

            // node with two children: Get the successor (smallest in
            // the right subtree
            Node t = x;
            x = max(t.left);

            // Delete the successor
            x.left =  deleteMax(t.left);

            // Re-link left subtree to the node which was replaced 
            x.right = t.right;

        }
        return x;
    }

}