package view;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("\n실행 결과\n");
    }
    public static void printPlayers(Players players) {
        System.out.println(players.getPlayersNames());
    }

    public static void printLadder(Ladder ladder) {
        for (String ladderLine : ladder.getLadderLines()) {
            System.out.println(ladderLine);
        }
    }
}
