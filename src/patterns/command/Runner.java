package patterns.command;

        import java.util.ArrayList;
        import java.util.List;

/**
 * the pattern intends to encapsulate in an object all the data required for performing a given action (command),
 * including what method to call, the method's arguments, and the object to which the method belongs.
 * This model allows us to decouple objects that produce the commands from their consumers,
 * so that's why the pattern is commonly known as the producer-consumer pattern.
 */
public class Runner {


    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        System.out.println(invoker.executeOperation(new OpenCommand(receiver)));
        System.out.println(invoker.executeOperation(new CloseCommand(receiver)));
    }

}
