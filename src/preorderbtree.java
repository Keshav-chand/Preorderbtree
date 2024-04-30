import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class preorderbtree{
    static int value;
    static Scanner sc= new Scanner(System.in);

    Deque<Node>queue=new LinkedList<Node>();
    static class Node{
        int key;
        Node left;
        Node right;
    }
    static Node newNode(int data){
        Node temp=new Node();
        temp.key=data;
        temp.left=null;
        temp.right=null;
        return temp;
    }
    Node insertNode(Node root,int key){
        Node newnode=newNode(key);
        if(root==null){
            root=newnode;
            queue.add(root);
            return root;
        }
        else{
            Node node;
            node=queue.remove();
            System.out.println("parent node="+node.key);
            if(node.left==null){
                node.left=newnode;
                queue.add(node.left);
                queue.addFirst(node);
                return root;
            }
            else if(node.right==null){
                node.right=newnode;
                queue.add(node.right);
                return root;
            }
        }
        return root;
    }
    public void preorder(Node root){
        if(root==null){
            return;
        }
        else{
            System.out.println(root.key+"");//first it will go to root , then to left and then finally to right node
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) {
        preorderbtree b= new preorderbtree();
        Node root=null;
        String status="a";
        while(!status.equals("s")){
            System.out.println("Enter the value to insert");
            value=sc.nextInt();
            root=b.insertNode(root,value);// to inset value into the root

            System.out.println("After preorder tranversal");
            b.preorder(root);// to print root after the tranversal

            System.out.println("\n Enter s to stop or any other charachter to continue the insertion");
            status=sc.next();
        }

    }

}
