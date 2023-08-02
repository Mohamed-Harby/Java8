import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;


public class MethodReference {

    public static int addition(int a, int b) {
        return a + b;
    }

    public void display(String msg) {
        msg = msg.trim().toUpperCase();
        System.out.println(msg);
    }

    public static void main(String[] args) {

        /* Function is a Functional Interface in java.util.function
         * Function<T, R> with T as the parameter type and R as the return type
         * It refers to a Lambda Expression or Method Reference
         */


        /* 1. Method Reference for Class Method  -> Class::StaticMethod <- */
        Function<Integer, Double> function1 = (input) -> Math.sqrt(input);
        System.out.println(function1.apply(5));
        Function<Integer, Double> function2 = Math::sqrt; // Static Method Reference (Class Method)

        // BiFunction used for functions with two arguments
        BiFunction<Integer, Integer, Integer> additionMethodReference = MethodReference::addition;

        System.out.println(additionMethodReference.apply(3, 6)); // prints 9

        /* 2. Method Reference for Object Method  -> Object::ObjectMethod <- */
        MethodReference methodReference = new MethodReference(); // create object
        Printable printable1 = message -> methodReference.display(message); // use the object function
        // or
        Printable printable2 = methodReference::display;
        printable2.print("Hi from Method Reference for Object Method !!");
        /**** Note: The referenced method (display) must have the same signature if the abstract method (print) in the Functional Interface (Printable) ****/


        /* 3. Method Reference for Object Method of the arguments  -> Class::ObjectMethod <- */
        Function<String, String> lowerCaseFunction = input -> input.toLowerCase(); // input is the object argument of type String and toLowerCase is the Object Method
        Function<String, String> lowerCaseFunction2 = String::toLowerCase;
        /**** Note: toLowerCase is an Object Method not a Class Method ****/

        /* 4. Reference to Constructor  -> Class::new <- */
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Mango");

        Function<List<String>, Set<String>> listToSet = listItems -> new HashSet<>(listItems); // Lambda Expression uses a Constructor
        Function<List<String>, Set<String>> listToSet2 = HashSet::new; //

        System.out.println(listToSet2.apply(fruits));


        BiFunction<Integer, Integer, Door> doorCreationFunction = (width, height) -> new Door(width, height);
        BiFunction<Integer, Integer, Door> doorCreationFunction2 = Door::new;

        System.out.println(doorCreationFunction2.apply(3, 5));

    }

}


class Door {
    private int width;
    private int height;

    public Door(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Door{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}