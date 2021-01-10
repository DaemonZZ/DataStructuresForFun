package data;

import data.tree.BinarySearchTree;
import data.tree.Label;
import data.tree.TreeTraverseType;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(15);
        tree.add(12);
        tree.add(18);
        tree.add(11);
        tree.add(14);
        tree.add(16);
        tree.add(27);
        tree.add(8);
        tree.add(10);
        tree.add(13);
        tree.add(24);
        tree.add(30);
        tree.add(6);
        tree.add(9);
        tree.add(21);
        tree.add(25);
        tree.add(29);
        tree.add(28);
        tree.add(31);
        tree.remove(18);
        Iterator<Integer> loop = tree.traverse(TreeTraverseType.INORDER);
        while (loop.hasNext()){
            System.out.print(loop.next()+"   ");
        }
        System.out.println("\nheight: "+tree.height());
        System.out.println(tree.leftMostChild(30));
    }
}
