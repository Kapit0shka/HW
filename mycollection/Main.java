package mycollection;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Stack<String> s= new Stack<>();

        MyLinkedList<String > lin = new MyLinkedList<>();

        lin.addLast("one");
        lin.addLast("two");
        lin.addLast("three");


        System.out.println(lin.toString());
        lin.add(0,"new one");
        lin.add(lin.size()-1,"last");
        System.out.println(lin.toString());
        System.out.println("---------------------");

        System.out.println("set: " + lin.set(0,"set one"));
        System.out.println(lin.toString());

        Iterator<String > iterator = lin.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------");
        lin.remove(0);
        lin.remove(2);
        System.out.println(lin.toString());
        System.out.println("------------------------");

        System.out.println("indexOf /last/" + lin.indexOf("last"));
        System.out.println("indexOf /two/" + lin.indexOf("two"));
        String[] mas = new String[1];
        mas = lin.toArray(mas);
        for(String str : mas) {
            System.out.println(str);
        }


        MyLinkedList<Integer > myLinInt = new MyLinkedList<>();

        LinkedList<Integer> linInt = new LinkedList<>();

        for (int i = 0; i<100000; i++) {
            linInt.addLast(i);
            myLinInt.addLast(i);
        }



        long start = System.nanoTime();

        myLinInt.add(15000,12);
        System.out.println("------------------------------");

        long tmpTime = System.nanoTime() - start;
        System.out.println("myLinked.add: " + tmpTime);
        linInt.add(15000,12);


        System.out.println("Linked.add: " + (System.nanoTime()-(start + tmpTime)));


    }
}
