public class Stimulate {

    public static void createTree (String strKey) {

        String[] keys = strKey.split(" ");
        BST tree = new BST();

        for (String i : keys) {
            int key = Integer.parseInt(i);
            tree.insert(key);
        }

        tree.LNR();

    }
    
    public static void main (String[] args) {
        BST BiTree = new BST();

        BiTree.insert(10);
        BiTree.insert(15);
        BiTree.insert(7);
        BiTree.insert(25);
        BiTree.insert(11);
        BiTree.insert(5);
        BiTree.insert(9);

        // BiTree.LNR();
        // Exercise 2:
        // createTree(new String("10 15 7 25 11"));
        // Exercise 3:
        // BiTree.LNR();
        // // Exercise 4:
        // System.out.println();
        // BiTree.RNL();
        // Exercise 5:
        // System.out.println(BiTree.contains(9));
        // Exercise 6:
        // BiTree.deleteMax();
        // BiTree.LNR();
        // Exercise 7:
        BiTree.delete_pre(10);
        BiTree.LNR();
    }

}