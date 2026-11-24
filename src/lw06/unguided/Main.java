package lw06.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        Scanner linesc = new Scanner(read.nextLine());
        BinarySearchTree binaryst = new BinarySearchTree();

        while (linesc.hasNextInt()){
            binaryst.insert(linesc.nextInt());
        }
        linesc.close();


        int target = read.nextInt();

        System.out.print("Preorder    : ");
        binaryst.preOrder();

        System.out.print("Inorder   : ");
        binaryst.inOrder();

        System.out.print("Postorder    :");
        binaryst.postOrder();

        
        System.out.println("Search " + target + " : " + binaryst.search(target));
        System.out.println("Nodes     : " + binaryst.countNodes());
        System.out.println("Leaves    : " + binaryst.countLeaves());
        read.close();
    }
}