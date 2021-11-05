public class BinaryTree {  
    
    class Node {
        int key;
        Node left, right;

        public Node(int value) {
            key = value;
            left = right = null;
        }
    }

    // Root lan 
    Node root;

    // constructor and constructor
    BinaryTree() {
        root = null;
    }
    
    // insert method
    void insert(int key) {
        root = insertRec(root, key);
    }


    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //  Otherwise, recur down the tree 

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }
    
    Node search(Node root, int key) {
        //base case
        if (root.key == key || root == null) {
            return root;
        }

        if (root.key < key) {
            return search(root.right, key);
        }

        return search(root.left, key);
    }
    

    void inOrder( ) {
        inOrderRec(root);
    }

    void deleteKey(int key) {
        root  = deleteKeyRec(root,key);
    }




    Node deleteKeyRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (root.key < key) {
            root.left = deleteKeyRec(root.left, key);
        } else if (root.key > key) {
            root.right = deleteKeyRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteKeyRec(root.right, root.key);
        }
        return root;
    }
    
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }


    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        tree.inOrder();
    
        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println(
            "inOrder traversal of the modified tree" );
        tree.inOrder();

    }
}
