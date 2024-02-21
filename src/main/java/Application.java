import java.util.List;
import java.util.Scanner;
import model.Ladder;
import model.Players;
import view.InputView;
import view.OutputView;
import view.dto.LadderResponse;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        List<String> names = inputView.readPlayersName();
        Players players = new Players(names);
        int height = inputView.readHeight();

        Ladder ladder = new Ladder(height, players.size());

        OutputView outputView = new OutputView();
        outputView.printResult(players.getNames(), LadderResponse.from(ladder));
    }
}
