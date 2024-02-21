import java.util.List;
import java.util.Scanner;
import model.Players;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        List<String> names = inputView.readPlayersName();
        Players players = new Players(names);
        System.out.println("name = " + names);

        inputView.readHeight();

        OutputView outputView = new OutputView();
        outputView.printResult(players.getNames());
    }
}
