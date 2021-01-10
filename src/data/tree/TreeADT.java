package data.tree;

import java.util.Iterator;

public interface TreeADT<T extends Comparable<T>> {
    T leftMostChild(T element);
    T rightSibling(T element);
    Label label(T element);
    boolean setLabel(T element,Label label);
    int size();
    int height();
    boolean isEmpty();
    boolean contain(T element);
    boolean add(T node);
    boolean remove(T node);
    Iterator<T> traverse(TreeTraverseType type);
}
