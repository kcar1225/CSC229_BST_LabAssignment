package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */

public class BinarySearchTree<root> {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    // ToDo 1: complete InOrder Traversal]
    private void doInOrder(BstNode root) {


        if (root != null) {
            doInOrder(root.getLeft()); //visits left nodes
            System.out.println(root.getData()+" "); //process
            doInOrder(root.getRight()); ////visits right nodes

        }

    }
    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    // ToDo 2: complete the pre-order traversal.
    private void doPreOrder(BstNode root){

            if (root != null) {   //condition to check if tree is empty
                System.out.print(root.getData()+" "); //process root
                doPreOrder(root.getLeft()); //visits left nodes
                doPreOrder(root.getRight());//visits right nodes
            }
    }

    public Integer findHeight() {

        return findTreeHeight(this.root);
    }

    // ToDo 3: Find the height of a tree
    private Integer  findTreeHeight(BstNode root){
        if (root == null){
            return -1;
        }
        else {   //find right and left height and return the larger as the tree height
            int leftHeight = findTreeHeight(root.getLeft());
            int rightHeight= findTreeHeight(root.getRight());


            return Math.max(leftHeight, rightHeight);
        }

    }


    public int getDepth(BstNode node) {
        return getTreeDepth(this.root);

    }

    //ToDo 4: complete getDepth of a node
    private int getTreeDepth(BstNode root) {
        if (root == null){
            return -1;
        }
        //find right and left depth and return the larger as the tree depth
        int leftDepth = getTreeDepth(root.getLeft());
        int rightDepth = getTreeDepth(root.getRight());

        return Math.max(leftDepth, rightDepth);

    }


    public  void print(String prefix) {
       System.out.println("\n==== BST Print ===== \n");
        printTree(root, prefix);



    }

    // ToDo 5: complete the print of the BST
    private void printTree(BstNode node, String prefix) {

        if (root == null){
            System.out.println(prefix + "--"+ node.getData());
            printTree(node.getLeft(), prefix + "|   ");
            printTree(node.getRight(), prefix + "|   ");
        }
    }


    }



