package patterns.command;

public class OpenCommand implements Command{
    //Receiver Object
    private Receiver receiver;
    public OpenCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public String execute() {
        receiver.setCurrentState(State.OPENED);
        return "Opened";
    }
}
