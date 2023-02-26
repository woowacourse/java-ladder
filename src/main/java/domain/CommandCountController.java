package domain;

public class CommandCountController {

    private int count;

    public CommandCountController() {
        this.count = 0;
    }

    public void execute(Command command) {
        count++;
    }

    public int getCount() {
        return this.count;
    }

}
