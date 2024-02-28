import domain.Height;
import domain.Ladder;
import domain.Players;
import domain.Prizes;
import domain.generator.Generator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Generator generator;

    public LadderGame(InputView inputView, OutputView outputView, Generator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        List<String> inputNames = inputView.readPlayerNames();
        Players players = new Players(inputNames);
        List<String> inputResults = inputView.readResults();
        Prizes prizes = new Prizes(players, inputResults);
        int inputHeight = inputView.readHeight();
        Height height = new Height(inputHeight);

        Ladder ladder = new Ladder(players, height, generator);

        outputView.printLadderGame(ladder, players.getNames(), prizes.getPrizes());
    }
}
