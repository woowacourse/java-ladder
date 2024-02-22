package view;

import domain.Game;

public class OutputView {

    private final MessageResolver messageResolver;

    public OutputView() {
        this.messageResolver = new MessageResolver();
    }

    public void printResult(Game game) {
        System.out.println("\n실행결과");
        System.out.println(messageResolver.resolveMembers(game.getMembers()));
        System.out.println(messageResolver.resolveLines(game.getLines()));
    }
}
