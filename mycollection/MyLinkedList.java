package mycollection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public MyLinkedList() {
    }

    @Override
    public void addFirst(E element) {
        if (element == null) { throw new NullPointerException(); }
        else {
            Node tmp = head;
            Node node = new Node(element,tmp,null);
            head = node;
            if(size == 0) {
                tail = node;
            } else {
                tmp.setLastNode(node);
                head = node;
            }
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        if (element == null) { throw new NullPointerException(); }
        else {
            Node tmp = tail;
            Node node = new Node(element,null,tmp);
            tail = node;
            if(size == 0) {
                head = node;
            } else {
                tmp.setNextNode(node);
                tail = node;
            }
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (element == null) { throw new NullPointerException(); }
        if (index > size && index < 0) { throw  new IndexOutOfBoundsException(); }

        if (index == 0){ addFirst(element); return; }
        if (index == size) { addLast(element); return; }

        Node cur = head;
        int tempIndex = 0;
        while (true){
            if (tempIndex == index) {
                Node newNode = new Node(element,cur.getLastNode().getNextNode(),cur.getLastNode());
                cur.getLastNode().setNextNode(newNode);
                cur.setLastNode(newNode);
                size++;
                return;
            }
            cur = cur.getNextNode();
            tempIndex++;
        }

    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index > size && index < 0) { throw  new IndexOutOfBoundsException(); }

        Node cur = head;
        int tempIndex = 0;
        while (true){
            if (tempIndex == index) {
                break;
            }
            cur = cur.getNextNode();
            tempIndex++;
        }
        return (E)cur.getElement();
    }

    @Override
    public int indexOf(E element) {
        if (element == null) { throw new NullPointerException(); }

        int index=0;
        Node cur = head;
        while (index != size){
            if (element.equals(cur.getElement())) {
                return index;
            }

            cur = cur.getNextNode();
            index++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index > size && index < 0) { throw  new IndexOutOfBoundsException(); }
        Node cur = head;

        if (index == 0) {
            head = head.getNextNode();
            head.setLastNode(null);
            size--;
            return (E)cur.getElement();
        }

        if (index == size-1) {
            cur = tail;
            tail = tail.getLastNode();
            tail.setNextNode(null);
            size--;
            return (E)cur.getElement();
        }


        int tempIndex = 0;
        while (true){
            if (tempIndex == index) {
                cur.getLastNode().setNextNode(cur.getNextNode());
                cur.getNextNode().setLastNode(cur.getLastNode());
                break;
            }
            cur = cur.getNextNode();
            tempIndex++;
        }
        size--;
        return (E)cur.getElement();
    }

    @Override
    public E set(int index, E element) {
        if (element == null) { throw new NullPointerException(); }
        if (index > size && index < 0) { throw  new IndexOutOfBoundsException(); }

        Node cur = head;
        E tempElement = null;
        int tempIndex = 0;
        while (true){
            if (tempIndex == index) {
                tempElement = (E)cur.getElement();
                cur.setElement(element);
                break;
            }
            cur = cur.getNextNode();
            tempIndex++;
        }
        return tempElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length < size) {
            array = (E[]) java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(), size);
        }

        int i = 0;
        Object[] result = array;
        for (Node<E> temp = head; temp != null; temp = temp.getNextNode()) {
            result[i++] = temp.getElement();
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    public E[] toArray1() {
        E[] array = (E[])new Object[size];
        E[] mas = toArray(array);
        return mas;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for(Node<E> temp = head; temp != null; temp = temp.getNextNode()) {
            array[i++] = temp.getElement();
        }

        return array;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node currentNode = head;

            @Override
            public boolean hasNext() {
                if (currentNode != null) { return true; }
                else { return false; }
            }

            @Override
            public E next() {
                Node tempNode = currentNode;
                currentNode = currentNode.getNextNode();
                return (E)tempNode.getElement();
            }

            @Override
            public void remove() {
                currentNode.getLastNode().getLastNode().setNextNode(currentNode.getLastNode().getNextNode());
                currentNode.getLastNode().getNextNode().setLastNode(currentNode.getLastNode().getLastNode());
                size--;
            }
        };
    }

    @Override
    public String toString() {
        Node temp = head;
        String result = "MyLinkedList{  ";
        for (int i = 0; i < size; i++) {
            result += temp.getElement().toString() + ", ";
            temp = temp.getNextNode();
        }
        result = result.substring(0, result.length() - 2);
        result += " }";
        return result;
    }

    public void printStartHead() {
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.println(tempNode.getElement());
            if (tempNode.getNextNode()==null){
                return;
            }
            tempNode = tempNode.getNextNode();
        }
    }

    public void printStartTail() {
        Node tempNode = tail;
        for (int i = 0; i < size; i++) {
            System.out.println(tempNode.getElement());
            if (tempNode.getLastNode() == null){
                return;
            }
            tempNode = tempNode.getLastNode();
        }
    }
}
