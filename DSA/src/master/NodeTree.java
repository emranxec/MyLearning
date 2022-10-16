package master;

public class NodeTree {

    public static void main(String[] args) {

        BinaryTree binaryTree=new BinaryTree();
        binaryTree.insert(9);
        binaryTree.insert(4);
        binaryTree.insert(6);
        binaryTree.insert(20);
        binaryTree.insert(170);

        System.out.println(binaryTree);
    }


}

class node{
    Integer userObject;
    node left;
    node right;

    node(Integer value){
        userObject=value;
        left=null;
        right=null;
    }

    @Override
    public String toString() {
        return "node{" +
                "userObject=" + userObject +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class BinaryTree {
    node root;
    BinaryTree(){
        root=null;
    }

    BinaryTree insert(Integer value){
        node newNode=new node(value);
        node tempRoot = root;
        insertChild(newNode, tempRoot,null);
        return this;
    }

    private void insertChild(node newNode, node tempRoot,Boolean isbig) {
        if (tempRoot == null) {
            if(isbig!=null){
                if(isbig)
                    tempRoot.right=newNode;
                    tempRoot.left=newNode;
            }
            tempRoot=newNode;
        } else {
            if (newNode.userObject > tempRoot.userObject) {
                tempRoot = tempRoot.right;
                if(tempRoot!=null) {
                    insertChild(newNode, tempRoot, true);
                }else{
                    tempRoot.right=newNode;
                }
            } else if (newNode.userObject < tempRoot.userObject) {
                tempRoot = tempRoot.left;
                if(tempRoot!=null) {
                    insertChild(newNode, tempRoot, false);
                }else{
                    tempRoot.left=newNode;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
