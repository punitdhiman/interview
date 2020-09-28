package patterns.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    List<Command> commands = new ArrayList<>();
    public String executeOperation(Command command){
        commands.add(command);
        return command.execute();
    }
}
