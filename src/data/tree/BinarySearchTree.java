package data.tree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {
    private Node<T> root = null;
    private int nodeCount = 0;

    @Override
    public T leftMostChild(T element) {
        if(!contain(element)) return null;
        else return leftMostChild(root,element);
    }

    @Override
    public T rightSibling(T element) {
        return null;
    }

    @Override
    public Label label(T element) {
        return null;
    }

    @Override
    public boolean setLabel(T element, Label label) {
        return false;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean isEmpty() {
        return nodeCount == 0;
    }

    @Override
    public boolean contain(T element) {
        return contain(element, root);
    }

    @Override
    public boolean add(T element) {
        if (contain(element)) return false;
        else {
            add(element, root);
            nodeCount++;
            return true;
        }
    }

    @Override
    public boolean remove(T element) {
        if(!contain(element)) return false;
        else {
            root=remove(root,element);
            nodeCount--;
            return true;
        }
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        switch (type) {
            case INORDER:
                return inOrderTrv();
            case PREORDER:
                return preOrder();
            case POSTORDER:
                return postOrder();
            case LEVELORDER:
                return levelOrder();
            default:
                return null;
        }
    }

    private int height(Node node) {
        if (node == null) return 0;
        else return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contain(T element, Node<T> node) {
        if (node == null) return false;
        int rs = element.compareTo(node.getData());
        if (rs < 0) return contain(element, node.getLeft());
        else if (rs > 0) return contain(element, node.getRight());
        else return true;
    }

    private Node add(T element, Node<T> node) {
        if (node == null) {
            root = new Node<>(element, null, null, null, null);
            return node;
        } else {
            int rs = element.compareTo(node.getData());
            if (rs < 0) {
                if (node.getLeft() == null) node.setLeft(new Node<>(element, null, null, node, null));
                else return add(element, node.getLeft());
            } else if (rs > 0) {
                if (node.getRight() == null) node.setRight(new Node<>(element, null, null, node, null));
                else return add(element, node.getRight());
            }
        }
        return null;
    }

    private Node<T> remove(Node<T> node, T element) {
        int rs = element.compareTo(node.getData());
        if(rs>0) node.setRight(remove(node.getRight(),element));
        else if(rs<0) node.setLeft(remove(node.getLeft(),element));
        else {
            if(node.getLeft()==null){
                Node<T> r =  node.getRight();
                return r;

            }
            else if(node.getRight()==null) {
                Node<T> l= node.getLeft();
                return l;
            }
            else{
                T nodeData = leftMostChild(node.getRight().getData());
                node.setData(nodeData);
                node.setRight(remove(node.getRight(),nodeData));
            }
        }
        return node;
    }

    private Iterator<T> levelOrder() {
        return null;
    }

    private Iterator<T> postOrder() {
        return null;
    }

    private Iterator<T> preOrder() {
        return null;
    }

    private Iterator<T> inOrderTrv() {
        Stack<Node> stack = new Stack<>();

        int checkSize = nodeCount;
        stack.push(root);
        return new Iterator<T>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                if (checkSize != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.empty();
            }

            @Override
            public T next() {

                if (checkSize != nodeCount) throw new ConcurrentModificationException();
                while (trav != null && trav.getLeft() != null) {
                    stack.push(trav.getLeft());
                    trav = trav.getLeft();
                }
                Node<T> node = stack.pop();
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                    trav = node.getRight();
                }
                return node.getData();
            }
        };
    }
    private T leftMostChild(Node<T> node, T element){
        int rs = element.compareTo(node.getData());
        if(rs<0) return  leftMostChild(node.getLeft(),element);
        else if(rs>0) return leftMostChild(node.getRight(),element);
        else {
            while (node.getLeft()!=null){
                node=node.getLeft();
            }
            return node.getData();
        }
    }
}
