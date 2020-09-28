package patterns.command;

public class CloseCommand implements Command{
    private Receiver receiver;

    public CloseCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public String execute() {
        receiver.setCurrentState(State.CLOSED);
        return "Closed";
    }
}


