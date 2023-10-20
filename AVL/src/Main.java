
public class Main {
    public static void main(String[] args) {

        Bst<Integer> bst = new Bst<>();
        bst.addNode(5);
        bst.printPreOrder();
        bst.addNode(3);
        bst.printPreOrder();
        bst.addNode(2);
        bst.printPreOrder();
        bst.addNode(1);
        bst.printPreOrder();
        bst.addNode(4);
        bst.printPreOrder();
        bst.addNode(9);
        bst.printPreOrder();
        bst.addNode(8);
        bst.printPreOrder();
        bst.addNode(10);
        bst.printPreOrder();
        bst.addNode(12);
        bst.printPreOrder();
        bst.evaluateBalance(bst.getRoot());
        bst.deleteNode(9);
        bst.printPreOrder();
        bst.deleteNode(1);
        bst.printPreOrder();
        bst.deleteNode(10);
        bst.deleteNode(12);
        bst.deleteNode(8);
        bst.printPreOrder();
        /*Person p1 = new Person("123", "Juan");
        Person p2 = new Person("122", "Carlos");
        Person p3 = new Person("111", "Julian");
        Person p4 = new Person("333", "Sara");
        Person p5 = new Person("300", "Raul");
        Person p6 = new Person("444", "Camilo");
        Person p7 = new Person("301", "Thomas");

        bst.addNode(p1);
        bst.printPreOrder();
        bst.addNode(p2);
        bst.printPreOrder();
        bst.addNode(p3);
        bst.printPreOrder();
        bst.addNode(p4);
        bst.printPreOrder();
        bst.addNode(p5);
        bst.printPreOrder();
        bst.addNode(p6);
        bst.printPreOrder();*/
    }
}