package mycollection;

public class Node<E> {
    private E element;
    private Node nextNode;
    private Node lastNode;

    public Node(E element, Node nextNode, Node lastNode) {
        this.element = element;
        this.nextNode = nextNode;
        this.lastNode = lastNode;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }
}
