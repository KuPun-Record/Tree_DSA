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

        // BiTree.delete_pre(7);
        BiTree.LNR();
        System.out.println();
        BiTree.delete_pre(7);
        BiTree.LNR();

    }

}