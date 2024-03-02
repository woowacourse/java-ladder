package view;

import domain.LadderGameResult;

public class OutputView {
    private final LadderGamePrinter ladderGamePrinter;
    private final LadderGameResultPrinter ladderGameResultPrinter;

    public OutputView(LadderGameResult ladderGameResult) {
        ladderGamePrinter = new LadderGamePrinter(ladderGameResult);
        ladderGameResultPrinter = new LadderGameResultPrinter(ladderGameResult);
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
