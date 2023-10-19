public class Node<E extends Comparable<E>>{

    private E element;
    private Node<E> left;
    private Node<E> right;
    private Node<E> parent;
    public Node(E element){
        this.element=element;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }
}
