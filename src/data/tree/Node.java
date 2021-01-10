package data.tree;

public class Node<T> {
    private T data;
    private Node<T> left,right,parent;
    private Label label;

    public Node() {
    }

    public Node(T data, Node<T> left, Node<T> right, Node<T> parent, Label label) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.label = label;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}

