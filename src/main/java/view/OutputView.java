package view;

import domain.LadderGame;

public class OutputView {
    private final LadderGamePrinter ladderGamePrinter;
    private final LadderGameResultPrinter ladderGameResultPrinter;

    public OutputView(LadderGame ladderGame) {
        ladderGamePrinter = new LadderGamePrinter(ladderGame);
        ladderGameResultPrinter = new LadderGameResultPrinter(ladderGame.calculateLadderGameResult());
    }

    public void printLadderResult() {
        ladderGamePrinter.print();
    }

    public void printSearchNameLadderResult(String searchName) {
        ladderGameResultPrinter.printFromName(searchName);
    }

    public void printAllNameLadderResult() {
        ladderGameResultPrinter.printAll();
    }
}
