package horstmann3chapter.greeter;

public class Greeter implements Runnable {
    private int n;
    private String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello " + target);
        }
    }
}
//Construct two instances with different messages and execute
//them concurrently in two threads.

//    Greeter greeter1 = new Greeter(3,"World");
//    Greeter greeter2 = new Greeter(4,"Java");
//
//    Thread thread1 = new Thread(greeter1);
//    Thread thread2 = new Thread(greeter2);
//
//    thread1.start();
//    thread2.start();