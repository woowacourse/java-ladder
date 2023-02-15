import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        List<String> usersName = inputView.inputUsername();
        Ladders ladders = new Ladders(inputView.inputLadderHeight(),new RandomGenerator());
        ladders.make(usersName.size()-1);
        outputView.printUsers(usersName);
        for (Ladder ladder : ladders.getLadders()) {
            outputView.printLadder(ladder);
        }
    }
}
