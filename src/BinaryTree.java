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

        Node value = tree.search(tree.root, 50);

            System.out.println("SEARCH RESULT " + value.key + " has been Found");
        
 

        tree.inOrder();
    }
}
