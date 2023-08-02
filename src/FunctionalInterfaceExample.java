import java.lang.Runnable;
import java.util.function.Function;

class ThreadDemo implements Runnable { // Runnable is a Functional Interface

    @Override       /* Polymorphism */
    public void run() {
        System.out.println("thread running");
    }
}

@FunctionalInterface /* annotation to make sure there is only one abstract method */
interface Printable {
    void print(String message); /* (Public) Abstract Method */
}


public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        /* lambda expression assigned for reference of type Printable (The Functional Interface) */
        Printable printable1 = (msg) -> System.out.println(msg);

        /* using Method Reference instead of lambda expression,
         * in case of the lambda expression refers to a method */
        Printable printable = System.out::println;
        printable.print("Method Reference");

    }
}