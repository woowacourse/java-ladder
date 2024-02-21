package controller;

import domain.Height;
import domain.Ladder;
import domain.Player;
import domain.Players;
import domain.booleangenerator.BooleanGenerator;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        List<String> names = repeatUntilValidInput(inputView::readPlayerNames);
        int height = repeatUntilValidInput(inputView::readHeight);

        Ladder ladder = makeLadder(names, height);

        outputView.printPlayer(names);
        outputView.printLadder(ladder, getMaxNameLength(names), names.get(0).length());
    }

    private static int getMaxNameLength(List<String> names) {
        return names.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("이름이 잘못됐습니다."));
    }

    private Ladder makeLadder(List<String> names, int height) {
        return new Ladder(new Players(makePlayers(names)), new Height(height), booleanGenerator);
    }

    private static List<Player> makePlayers(List<String> names) {
        return names.stream()
                .map(Player::new)
                .toList();
    }

    private <T> T repeatUntilValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
