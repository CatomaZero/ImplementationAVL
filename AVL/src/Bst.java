

public class Bst<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public Bst() {
        this.root = null;
        size = 0;
    }

    public void addNode(E element) {
        addNode(root, element);
        size++;
    }

    public void addNode(Node<E> pointer, E element) {
        Node<E> node = new Node<>(element);
        if (pointer == null) {
            root = node;
        } else if (element.compareTo(pointer.getElement()) < 0) {
            if (pointer.getLeft() == null) {
                pointer.setLeft(node);
                pointer.getLeft().setParent(pointer);
                evaluateBalance(root);
            } else {
                addNode(pointer.getLeft(), element);
            }
        } else if (element.compareTo(pointer.getElement()) >= 0) {
            if (pointer.getRight() == null) {
                pointer.setRight(node);
                pointer.getRight().setParent(pointer);
                evaluateBalance(root);
            } else {
                addNode(pointer.getRight(), element);
            }
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    public void printInOrder(Node<E> pointer) {
        if (pointer != null) {
            printInOrder(pointer.getLeft());
            System.out.println(pointer.getElement());
            printInOrder(pointer.getRight());
        }
    }

    public void printPreOrder(Node<E> pointer) {
        if (pointer != null) {
            System.out.print(pointer.getElement() + "\n");
            printPreOrder(pointer.getLeft());
            printPreOrder(pointer.getRight());
        }
    }

    public void printPostOrder(Node<E> pointer) {
        if (pointer != null) {
            printPostOrder(pointer.getLeft());
            printPostOrder(pointer.getRight());
            System.out.print(pointer.getElement() + "\n");
        }

    }

    public String deleteNode(E element) {
        String mss = "";
        if (search(element) != null) {
            System.out.println(deleteNode(root, element).getElement());
            evaluateBalance(root);
            mss = "We found the element and it gets deleted from the tree";
            size--;
        } else {
            mss = "That element is not added in the tree yet";
        }
        return mss;
    }

    private Node<E> deleteNode(Node<E> pointer, E element) {
        if (pointer == null) {
            return null;
        }
        if (element.compareTo(pointer.getElement()) < 0) {
            pointer.setLeft(deleteNode(pointer.getLeft(), element));
        } else if (element.compareTo(pointer.getElement()) > 0) {
            pointer.setRight(deleteNode(pointer.getRight(), element));
        } else {
            if (pointer.getLeft() == null) {
                return pointer.getRight();
            } else if (pointer.getRight() == null) {
                return pointer.getLeft();
            }
            pointer.setElement(findMinElement(pointer.getRight()));
            pointer.setRight(deleteNode(pointer.getRight(), pointer.getElement()));
        }
        return pointer;
    }

    private E findMinElement(Node<E> node) {
        E minElement = node.getElement();
        while (node.getLeft() != null) {
            minElement = node.getLeft().getElement();
            node = node.getLeft();
        }
        return minElement;
    }

    public Node<E> search(E element) {
        return search(root, element);
    }

    private Node<E> search(Node<E> pointer, E element) {
        if (pointer == null || element.equals(pointer.getElement())) {
            return pointer;
        }
        if (element.compareTo(pointer.getElement()) < 0) {
            return search(pointer.getLeft(), element);
        }
        return search(pointer.getRight(), element);
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node<E> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getSize() {
        return size;
    }

    public E getMinValue() {
        Node<E> minNode = getMinNode(root);
        return minNode != null ? minNode.getElement() : null;
    }

    private Node<E> getMinNode(Node<E> root) {
        if (root == null) {
            return null;
        }
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    public E getMaxValue() {
        Node<E> maxNode = getMaxNode(root);
        return maxNode != null ? maxNode.getElement() : null;
    }

    private Node<E> getMaxNode(Node<E> root) {
        if (root == null) {
            return null;
        }
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

    public int evaluateBalance(Node<E> pointer) {
        if (pointer == null) {
            return 0;
        }
        int rightHeight = getHeight(pointer.getRight());
        int leftHeight = getHeight(pointer.getLeft());

        int balanceFactor = rightHeight - leftHeight;
        System.out.println("Right Height: " + rightHeight + ", Left Height: " + leftHeight + ", Balance Factor: " + balanceFactor);

        if (balanceFactor > 1) {
            int rightEvaluation=evaluateBalance(pointer.getRight());
            if (rightEvaluation < 0) {
                doubleRotationLeft(pointer);
            } else if (rightEvaluation<2) {
                simpleRotationLeft(pointer);
            }
        } else if (balanceFactor < -1) {
            int leftEvaluation=evaluateBalance(pointer.getLeft());
            if (leftEvaluation > 0) {
                doubleRotationRight(pointer);
            } else if (leftEvaluation>-2) {
                simpleRotationRight(pointer);
            }
        }
        return balanceFactor;
    }

    public void simpleRotationLeft(Node<E> pointer) {
        System.out.println("Necesita una rotación simple a la izquierda");
        System.out.println(pointer);
        Node<E> leftNode = pointer.getLeft();
        Node<E> rightNode = pointer.getRight();

        if (leftNode == null) {
            pointer.setRight(rightNode.getLeft());
            rightNode.setLeft(pointer);
            if (pointer.getParent() == null) {
                root = rightNode;
            } else {
                rightNode.setParent(pointer.getParent());
                pointer.getParent().setRight(rightNode);
            }
            pointer.setParent(rightNode);
        } else {
            pointer.setRight(rightNode.getLeft());
            leftNode.setParent(pointer);
            pointer.setLeft(leftNode);
            rightNode.setLeft(pointer);
            if (pointer.getParent() == null) {
                root = rightNode;
            } else {
                rightNode.setParent(pointer.getParent());
                pointer.getParent().setRight(rightNode);
            }
            pointer.setParent(rightNode);
        }
    }

    public void simpleRotationRight(Node<E> pointer) {
        System.out.println("Necesita una rotación simple a la derecha");
        System.out.println(pointer);
        if (pointer != null) {
            Node<E> leftNode = pointer.getLeft();
            Node<E> rightNode = pointer.getRight();

            if (rightNode == null) {
                pointer.setLeft(leftNode.getRight());
                leftNode.setRight(pointer);
                if (pointer.getParent() == null) {
                    root = leftNode;
                } else {
                    leftNode.setParent(pointer.getParent());
                    pointer.getParent().setLeft(leftNode);
                }
                pointer.setParent(leftNode);
            } else {
                pointer.setLeft(leftNode.getRight());
                rightNode.setParent(pointer);
                pointer.setRight(rightNode);
                leftNode.setRight(pointer);
                if (pointer.getParent() == null) {
                    root = leftNode;
                } else {
                    leftNode.setParent(pointer.getParent());
                    pointer.getParent().setLeft(leftNode);
                }
                pointer.setParent(leftNode);
            }
        }
    }

    public void doubleRotationLeft(Node<E> pointer) {
        System.out.println("Necesita un rotacion doble a la izquiera");
        simpleRotationRight(pointer.getLeft());
        simpleRotationLeft(pointer);
    }

    public void doubleRotationRight(Node<E> pointer) {
        System.out.println("Necesita un rotacion doble a la derecha");
        simpleRotationLeft(pointer.getRight());
        simpleRotationRight(pointer);
    }

    public Node<E> getRoot() {
        return root;
    }
}


